package com.lzdn.ucenter.controller;

import com.lzdn.common.base.BaseController;
import com.lzdn.common.base.BaseTableAo;
import com.lzdn.common.util.StringUtil;
import com.lzdn.ucenter.ao.UcenterTableAo;
import com.lzdn.ucenter.common.UcenterResult;
import com.lzdn.ucenter.common.UcenterResultConstant;
import com.lzdn.ucenter.dao.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lzdn.ucenter.dto.UcenterOauthDto;
import com.lzdn.ucenter.dto.UcenterUserDto;
import com.lzdn.ucenter.service.UcenterOauthService;
import com.lzdn.ucenter.service.UcenterUserDetailsService;
import com.lzdn.ucenter.service.UcenterUserOauthService;
import com.lzdn.ucenter.service.UcenterUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "ucenter/user")
@Api(value = "注册用户管理", description = "注册用户管理")
public class UcenterUserController extends BaseController {
    @Autowired
    private UcenterOauthService ucenterOauthService;
    @Autowired
    private UcenterUserService ucenterUserService;
    @Autowired
    private UcenterUserDetailsService ucenterUserDetailsService;
    @Autowired
    private UcenterUserOauthService ucenterUserOauthService;

    @ApiOperation(value = "注册用户首页")
    @RequiresPermissions("ucenter:user:read")
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String userView(ModelMap modelMap) {
        UcenterOauthExample ucenterOauthExample = new UcenterOauthExample();
        List<UcenterOauth> ucenterOauths = ucenterOauthService.selectByExample(ucenterOauthExample);
        modelMap.put("ucenterOauths",ucenterOauths);
        return  "ucenter/user/index.jsp";
    }
    @ApiOperation(value = "注册用户首页")
    @RequiresPermissions("ucenter:user:read")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Object userList(
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "user_id",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order,
            @RequestParam(required = false,defaultValue = "",value = "ucenterOauths")String ucenterOauths){

        UcenterUserExample ucenterUserExample = new UcenterUserExample();
        UcenterUserExample.Criteria criteria = ucenterUserExample.createCriteria();
        if(StringUtils.isNotBlank(search)){
            criteria.andNicknameLike("search");
        }
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            sort = StringUtil.humpToLine(sort);
            ucenterUserExample.setOrderByClause(sort+" "+order);
        }
        //List<UcenterUser> ucenterUsers = ucenterUserService.selectByExampleForOffsetPage(ucenterUserExample,offset,limit);
        //粗脱敏删除敏感数据
        //ucenterUsers.forEach(ucenterUser->{ucenterUser.setPassword("");ucenterUser.setSalt("");});
//        if(!StringUtils.isNumeric(ucenterOauths)){
//            return new UcenterResult(UcenterResultConstant.FAILED,"错误参数");
//        }
        UcenterTableAo ucenterTableAo = new UcenterTableAo();
        ucenterTableAo.setLimit(limit);
        ucenterTableAo.setOffset(offset);
        ucenterTableAo.setOrder(order);
        ucenterTableAo.setSearch(search);
        ucenterTableAo.setSort(sort);
        List<UcenterUserDto> ucenterUserDtos = ucenterUserService.selectFullMessageForOffsetPage(ucenterTableAo,ucenterOauths);
        System.out.println("ucenterUserDtos"+ucenterUserDtos);
        long count = ucenterUserService.countByExample(ucenterUserExample);
        System.out.println(count);
        Map<String,Object> result = new HashMap <>(2);
        result.put("rows",ucenterUserDtos);
        result.put("total",count);
        return result;
    }

    @ApiOperation(value = "用户详情" )
    @RequiresPermissions("ucenter:user:detailed:read")
    @RequestMapping(value = "detailed/{id}" ,method = RequestMethod.GET)
    public String detailedView(@PathVariable("id")int id, ModelMap modelMap){
        UcenterUserDetails ucenterUserDetails = ucenterUserDetailsService.selectByPrimaryKey(id);
        modelMap.put("ucenterUserDetails",ucenterUserDetails);
        return "ucenter/user/detailed.jsp";
    }
    @ApiOperation(value = "用户详情")
    @RequiresPermissions("ucenter:user:detailed:update")
    @RequestMapping(value = "detailed/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object detailed(@PathVariable("id")int id, UcenterUserDetails ucenterUserDetails){
        ucenterUserDetails.setUserId(id);
        int count = ucenterUserDetailsService.updateByPrimaryKeySelective(ucenterUserDetails);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

    @ApiOperation(value = "用户编辑")
    @RequiresPermissions("ucenter:user:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String updateView(@PathVariable("id")int id,ModelMap modelMap){
        UcenterUser ucenterUser = ucenterUserService.selectByPrimaryKey(id);
        modelMap.put("ucenterUser",ucenterUser);
        return "ucenter/user/update.jsp";
    }

    @ApiOperation(value = "用户编辑")
    @RequiresPermissions("ucenter:user:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id")int id,UcenterUser ucenterUser){
        ucenterUser.setUserId(id);
        int count = ucenterUserService.updateByPrimaryKeySelective(ucenterUser);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

    @ApiOperation(value = "用户认证状态管理")
    @RequiresPermissions("ucenter:user:oauth:read")
    @RequestMapping(value = "oauth/{id}",method = RequestMethod.GET)
    public String oauthView(@PathVariable("id")int id, ModelMap modelMap){
        List<UcenterOauthDto> ucenterOauthDto = ucenterOauthService.selectUcenterDtoByUserId(id);
        System.out.println(ucenterOauthDto);
        modelMap.put("UcenterOauthDto",ucenterOauthDto);
        return "ucenter/user/oauth.jsp";
    }
    @ApiOperation(value = "用户认证状态管理")
    @RequiresPermissions("ucenter:user:oauth:update")
    @RequestMapping(value = "oauth/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object oauth(@PathVariable("id")int id, HttpServletRequest request){
        String userOauthId = request.getParameter("userOauthId");
        String status = request.getParameter("status");
        if(!StringUtils.isNumeric(userOauthId)||!StringUtils.isNumeric(status)){
            return new UcenterResult(UcenterResultConstant.INVALID_PARAMETER,"错误参数");
        }
        UcenterUserOauth ucenterUserOauth = new UcenterUserOauth();
        ucenterUserOauth.setUserOauthId(Integer.parseInt(userOauthId));
        ucenterUserOauth.setStatus(Byte.parseByte(status));
        int count = ucenterUserOauthService.updateByPrimaryKeySelective(ucenterUserOauth);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }
}
