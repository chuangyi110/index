package com.lzdn.sys.controller;

import com.lzdn.common.base.BaseController;
import com.lzdn.common.util.PropertiesFileUtil;
import com.lzdn.common.util.RedisUtil;
import com.lzdn.sys.common.SysResult;
import com.lzdn.sys.common.SysResultConstant;
import com.lzdn.upms.common.UpmsResult;
import com.lzdn.upms.common.UpmsResultConstant;
import com.lzdn.upms.dao.model.UpmsSystem;
import com.lzdn.upms.dao.model.UpmsSystemExample;
import com.lzdn.upms.service.UpmsSystemService;
import com.lzdn.upms.service.UpmsUserService;
import com.lzdn.upms.shiro.session.UpmsSession;
import com.lzdn.upms.shiro.session.UpmsSessionDao;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.List;

@Controller
@RequestMapping("sys")
public class LoginController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    // 全局会话key
    private final static String LEE_UPMS_SERVER_SESSION_ID = "lee-upms-server-session-id";
    // 全局会话key列表
    private final static String LEE_UPMS_SERVER_SESSION_IDS = "lee-upms-server-session-ids";
    // code key
    private final static String LEE_UPMS_SERVER_CODE = "lee-upms-server-code";

    @Autowired
    UpmsSystemService upmsSystemService;

    @Autowired
    UpmsUserService upmsUserService;

    @Autowired
    UpmsSessionDao upmsSessionDao;

    @ApiOperation(value = "认证中心首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws Exception {
        String appid = request.getParameter("appid");
        String backurl = request.getParameter("backurl");
        if (StringUtils.isBlank(appid)) {
            throw new RuntimeException("无效访问！");
        }
        // 判断请求认证系统是否注册
        UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
        upmsSystemExample.createCriteria()
                .andNameEqualTo(appid);
        int count = upmsSystemService.countByExample(upmsSystemExample);
        if (0 == count) {
            throw new RuntimeException(String.format("未注册的系统:%s", appid));
        }
        return "redirect:/sys/login?backurl=" + URLEncoder.encode(backurl, "utf-8");
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String bkLogin(HttpServletRequest req){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String serverSessionId = session.getId().toString();
        String code = RedisUtil.get(LEE_UPMS_SERVER_SESSION_ID+"_"+serverSessionId);
        if(StringUtils.isNotBlank(code)){
            String backurl = req.getParameter("backurl");
            System.out.println("backurl:"+backurl);
            String username = (String)subject.getPrincipal();
            System.out.println("user:"+username);
            if(StringUtils.isBlank(backurl)){
                backurl="/upms";
                return "redirect:"+backurl;
            }else{
                if(backurl.contains("?")){
                    backurl+="&upms_code="+code+"&upms_username="+username;
                }else {
                    backurl+="?upms_code="+code+"&upms_username="+username;
                }
                System.out.println("backurl:"+backurl);
                LOGGER.debug("认证中心账号通过，带code回跳：{}",backurl);
                return "redirect:"+backurl;
            }
        }
        return "login.html";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest req, HttpServletResponse res, ModelMap modelMap){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        if(StringUtils.isBlank(username)){
            return new SysResult(SysResultConstant.EMPTY_USERNAME,"账号不能为空！");
        }
        if(StringUtils.isBlank(password)){
            return new SysResult(SysResultConstant.EMPTY_PASSWORD,"密码不能为空！");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        //判断是否登陆，如果登陆则回跳，防止重复登陆
        String hasCode = RedisUtil.get(LEE_UPMS_SERVER_SESSION_ID+"_"+sessionId);
        //code
        if(StringUtils.isBlank(hasCode)){
            UsernamePasswordToken  usernamePasswordToken = new UsernamePasswordToken(username,password);
            try {
                if(BooleanUtils.toBoolean(rememberMe)){
                    usernamePasswordToken.setRememberMe(true);
                } else {
                  usernamePasswordToken.setRememberMe(false);
                }
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                return new SysResult(SysResultConstant.INVALID_USERNAME, "帐号不存在！");
            } catch (IncorrectCredentialsException e) {
                return new SysResult(SysResultConstant.INVALID_PASSWORD, "密码错误！");
            } catch (LockedAccountException e) {
                return new SysResult(SysResultConstant.INVALID_ACCOUNT, "帐号已锁定！");
            }
            //更新session状态
            upmsSessionDao.updateStatus(sessionId,UpmsSession.OnlineStatus.on_line);
            //全局会话sessionId列表，供会话管理
            RedisUtil.lpush(LEE_UPMS_SERVER_SESSION_IDS,sessionId.toString());
            String code = UUID.randomUUID().toString();
            RedisUtil.set(LEE_UPMS_SERVER_SESSION_ID+"_"+sessionId,code,(int)subject.getSession().getTimeout()/1000);
            RedisUtil.set(LEE_UPMS_SERVER_CODE+"_"+code,code,(int)subject.getSession().getTimeout()/1000);
        }
        String backurl =req.getParameter("backurl");
        if(StringUtils.isBlank(backurl)){
            UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
            upmsSystemExample.createCriteria().andNameEqualTo("upms");
            List<UpmsSystem> upmsSystems = upmsSystemService.selectByExample(upmsSystemExample);
            if(upmsSystems.size()>1){
                return new SysResult(SysResultConstant.INTERNAL_ERROR,"内部错误，请联系系统管理员");
            }
            UpmsSystem upmsSystem = upmsSystems.get(0);
            backurl = null == upmsSystem ? "/":upmsSystem.getBasepath();
            return new UpmsResult(UpmsResultConstant.SUCCESS,backurl);
        }else{
            return new UpmsResult(UpmsResultConstant.FAILED,backurl);
        }
    }
    @ApiOperation(value = "校验code")
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @ResponseBody
    public Object code(HttpServletRequest request) {
        String codeParam = request.getParameter("code");
        String code = RedisUtil.get(LEE_UPMS_SERVER_CODE + "_" + codeParam);
        if (StringUtils.isBlank(codeParam) || !codeParam.equals(code)) {
            new UpmsResult(UpmsResultConstant.FAILED, "无效code");
        }
        return new UpmsResult(UpmsResultConstant.SUCCESS, code);
    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req){
        SecurityUtils.getSubject().logout();
        String redirecUrl = req.getHeader("Referer");
        //System.out.println("redirecUrl:"+redirecUrl);
        if(null==redirecUrl){
            redirecUrl = "/";
        }
        return  "redirect:"+"/sys/login";
    }




}
