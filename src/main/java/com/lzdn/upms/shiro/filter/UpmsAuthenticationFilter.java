package com.lzdn.upms.shiro.filter;

import com.alibaba.fastjson.JSONObject;

import com.lzdn.common.util.PropertiesFileUtil;
import com.lzdn.common.util.RedisUtil;
import com.lzdn.common.util.RequestParameterUtil;
import com.lzdn.upms.common.UpmsConstant;
import com.lzdn.upms.shiro.session.UpmsSessionDao;
import org.apache.commons.lang.StringUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import org.apache.http.client.HttpClient;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 重写authc过滤器
 * Created by shulee on 2017/3/11.
 */
public class UpmsAuthenticationFilter extends AuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsAuthenticationFilter.class);

    // 局部会话key
    private final static String LEE_UPMS_CLIENT_SESSION_ID = "lee-upms-client-session-id";
    // 单点同一个code所有局部会话key
    private final static String LEE_UPMS_CLIENT_SESSION_IDS = "lee-upms-client-session-ids";

    @Autowired
    UpmsSessionDao upmsSessionDao;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        // 判断请求类型
        //String upmsType = PropertiesFileUtil.getInstance("lee-upms-client").get("lee.upms.type");
        String upmsType = "server";
        session.setAttribute(UpmsConstant.UPMS_TYPE, upmsType);
        if ("client".equals(upmsType)) {
            return validateClient(request, response);
        }
        if ("server".equals(upmsType)) {
            return subject.isAuthenticated();
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //StringBuffer ssoServerUrl = new StringBuffer(PropertiesFileUtil.getInstance("lee-upms-client").get("lee.upms.sso.server.url"));
        StringBuffer ssoServerUrl = new StringBuffer("http://127.0.0.1:9777");
        // server需要登录
        //String upmsType = PropertiesFileUtil.getInstance("lee-upms-client").get("lee.upms.type");
        String upmsType = "server";
        if ("server".equals(upmsType)) {
            WebUtils.toHttp(response).sendRedirect(ssoServerUrl.append("/sys/login").toString());
            return false;
        }
        //ssoServerUrl.append("/sso/index").append("?").append("appid").append("=").append(PropertiesFileUtil.getInstance("lee-upms-client").get("lee.upms.appID"));
        ssoServerUrl.append("/sys/index").append("?").append("appid").append("=").append("lee-upms-server");

        // 回跳地址
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        StringBuffer backurl = httpServletRequest.getRequestURL();
        String queryString = httpServletRequest.getQueryString();
        if (StringUtils.isNotBlank(queryString)) {
            backurl.append("?").append(queryString);
        }
        ssoServerUrl.append("&").append("backurl").append("=").append(URLEncoder.encode(backurl.toString(), "utf-8"));
        WebUtils.toHttp(response).sendRedirect(ssoServerUrl.toString());
        return false;
    }

    /**
     * 认证中心登录成功带回code
     * @param request
     */
    private boolean validateClient(ServletRequest request, ServletResponse response) {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        int timeOut = (int) session.getTimeout() / 1000;
        // 判断局部会话是否登录
        String cacheClientSession = RedisUtil.get(LEE_UPMS_CLIENT_SESSION_ID + "_" + session.getId());
        LOGGER.info("red",cacheClientSession);
        if (StringUtils.isNotBlank(cacheClientSession)) {
            // 更新code有效期
            RedisUtil.set(LEE_UPMS_CLIENT_SESSION_ID + "_" + sessionId, cacheClientSession, timeOut);
            Jedis jedis = RedisUtil.getJedis();
            jedis.expire(LEE_UPMS_CLIENT_SESSION_IDS + "_" + cacheClientSession, timeOut);
            jedis.close();
            // 移除url中的code参数
            if (null != request.getParameter("code")) {
                String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
                HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
                try {
                    httpServletResponse.sendRedirect(backUrl.toString());
                } catch (IOException e) {
                    LOGGER.error("局部会话已登录，移除code参数跳转出错：", e);
                }
            } else {
                return true;
            }
        }
        // 判断是否有认证中心code
        String code = request.getParameter("upms_code");
        // 已拿到code
        if (StringUtils.isNotBlank(code)) {
            // HttpPost去校验code
            try {
                //StringBuffer ssoServerUrl = new StringBuffer(PropertiesFileUtil.getInstance("lee-upms-client").get("lee.upms.sso.server.url"));
                StringBuffer ssoServerUrl =new StringBuffer("http://127.0.0.1:9777");
                HttpClient httpclient = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost(ssoServerUrl.toString() + "/sys/code");

                List<NameValuePair> nameValuePairs = new ArrayList<>();
                nameValuePairs.add(new BasicNameValuePair("code", code));
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse httpResponse = httpclient.execute(httpPost);
                if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    JSONObject result = JSONObject.parseObject(EntityUtils.toString(httpEntity));
                    if (1 == result.getIntValue("code") && result.getString("data").equals(code)) {
                        // code校验正确，创建局部会话
                        RedisUtil.set(LEE_UPMS_CLIENT_SESSION_ID + "_" + sessionId, code, timeOut);
                        // 保存code对应的局部会话sessionId，方便退出操作
                        RedisUtil.sadd(LEE_UPMS_CLIENT_SESSION_IDS + "_" + code, sessionId, timeOut);
                        LOGGER.info("当前code={}，对应的注册系统个数：{}个", code, RedisUtil.getJedis().scard(LEE_UPMS_CLIENT_SESSION_IDS + "_" + code));
                        // 移除url中的token参数
                        String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
                        // 返回请求资源
                        try {
                            // client无密认证
                            String username = request.getParameter("upms_username");
                            subject.login(new UsernamePasswordToken(username, ""));
                            HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
                            httpServletResponse.sendRedirect(backUrl.toString());
                            return true;
                        } catch (IOException e) {
                            LOGGER.error("已拿到code，移除code参数跳转出错：", e);
                        }
                    } else {
                        LOGGER.warn(result.getString("data"));
                    }
                }
            } catch (IOException e) {
                LOGGER.error("验证token失败：", e);
            }
        }
        return false;
    }

}