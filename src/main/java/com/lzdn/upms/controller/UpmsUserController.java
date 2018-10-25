package com.lzdn.upms.controller;

import com.alibaba.fastjson.JSONArray;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.lzdn.common.base.BaseController;
import com.lzdn.common.util.MD5Util;
import com.lzdn.common.validator.LengthValidator;
import com.lzdn.common.validator.NotNullValidator;
import com.lzdn.upms.common.UpmsConstant;
import com.lzdn.upms.common.UpmsResult;
import com.lzdn.upms.common.UpmsResultConstant;
import com.lzdn.upms.dao.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.lzdn.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Api(value = "用户管理", description = "用户管理")
@RequestMapping("upms/users")
public class UpmsUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserController.class);

    @Autowired
    private UpmsUserService upmsUserService;
    @Autowired
    private UpmsApiService upmsApiService;
    @Autowired
    private UpmsRoleService upmsRoleService;
    @Autowired
    private UpmsUserRoleService upmsUserRoleService;
    @Autowired
    private UpmsUserPermissionService upmsUserPermissionService;
    @Autowired
    private UpmsUserOrganizationService upmsUserOrganizationService;
    @Autowired
    private UpmsOrganizationService upmsOrganizationService;


    @ApiOperation(value = "用户首页")
    @RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/upms/user/index.jsp";
    }

    @ApiOperation(value = "用户首页")
    @ResponseBody
    @RequiresPermissions("upms:users:read")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    //TODO 未作权限限制
    public Object Userlist(
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "user_id",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order){
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            upmsUserExample.setOrderByClause(sort+" "+order);
        }
        if(StringUtils.isNotBlank(search)){
            upmsUserExample.or().andUsernameLike("%"+search+"%");
            upmsUserExample.or().andRealnameLike("%"+search+"%");
        }
        List<UpmsUser> upmsUsers = upmsUserService.selectByExampleForOffsetPage(upmsUserExample,offset,limit);
        //粗脱敏删除密码，盐
        upmsUsers.forEach(upmsUser ->{upmsUser.setSalt("");upmsUser.setPassword("");});
        System.out.println(upmsUsers);
        long total = upmsUserService.countByExample(upmsUserExample);
        Map<String,Object> result = new HashMap <>();
        result.put("rows",upmsUsers);
        result.put("total",total);
        return result;
    }




    @ResponseBody
    @RequiresPermissions("upms:users:read")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public Object selectUser(@PathVariable("id")int id, HttpServletRequest req, HttpServletResponse res){
        UpmsUser upmsUser = upmsUserService.selectByPrimaryKey(id);
        upmsUser.setPassword("");
        upmsUser.setSalt("");
        List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(id);
        List<UpmsRole> upmsRoles = upmsApiService.selectUpmsRoleByUpmsUserId(id);
        Map<String,Object> result = new HashMap <>();
        result.put("upmsUser",upmsUser);
        result.put("upmsPermissions",upmsPermissions);
        result.put("upmsRole",upmsRoles);
        return new UpmsResult(UpmsResultConstant.SUCCESS,result);
    }


    @ApiOperation(value = "新增用户")
    @RequiresPermissions("upms:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/upms/user/create.jsp";
    }


    @ApiOperation(value = "新增用户")
    @ResponseBody
    @RequiresPermissions("upms:users:create")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Object addUser(UpmsUser upmsUser){
        //判断输入数据是否合规
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(),new LengthValidator(1,20,"账号"))
                .on(upmsUser.getPassword(),new LengthValidator(5,32,"密码"))
                .on(upmsUser.getRealname(),new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if(!result.isSuccess()){
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH,result.getErrors());
        }
        //判断是否账号是否已注册
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andUsernameEqualTo(upmsUser.getUsername());
        if (upmsUserService.countByExample(upmsUserExample)> 0) {
            return new UpmsResult(UpmsResultConstant.FAILED, "帐号名已存在！");
        }
        //注册账号
        upmsUser.setLocked(UpmsConstant.USER_UNLOCKED);
        long ctime = System.currentTimeMillis();
        String salt = MD5Util.md5(ctime+"");
        upmsUser.setSalt(salt);
        upmsUser.setPassword(MD5Util.md5(upmsUser.getPassword()+salt));
        upmsUser.setCtime(ctime);
        int count = upmsUserService.insert(upmsUser);
        return new UpmsResult(UpmsResultConstant.SUCCESS,count);
    }

    @ApiOperation(value = "删除用户")
    @RequiresPermissions("upms:user:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsUserService.deleteByPrimaryKeys(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        modelMap.put("user", user);
        return "/upms/user/update.jsp";
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsUser upmsUser) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
                .on(upmsUser.getRealname(), new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
        }
        // 不允许直接改密码
        upmsUser.setPassword(null);
        upmsUser.setUserId(id);
        int count = upmsUserService.updateByPrimaryKeySelective(upmsUser);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }
    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String role(@PathVariable("id") int id, ModelMap modelMap) {
        // 所有角色
        List<UpmsRole> upmsRoles = upmsRoleService.selectByExample(new UpmsRoleExample());
        // 用户拥有角色
        UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserRole> upmsUserRoles = upmsUserRoleService.selectByExample(upmsUserRoleExample);
        modelMap.put("upmsRoles", upmsRoles);
        modelMap.put("upmsUserRoles", upmsUserRoles);
        return "/upms/user/role.jsp";
    }

    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object role(@PathVariable("id") int id, HttpServletRequest request) {
        String[] roleIds = request.getParameterValues("roleId");
        upmsUserRoleService.role(roleIds, id);
        return new UpmsResult(UpmsResultConstant.SUCCESS, "");
    }

    @ApiOperation(value = "用户权限")
    @RequiresPermissions("upms:user:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public String permission(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        modelMap.put("user", user);
        return "/upms/user/permission.jsp";
    }

    @ApiOperation(value = "用户权限")
    @RequiresPermissions("upms:user:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object permission(@PathVariable("id") int id, HttpServletRequest request) {
        JSONArray datas = JSONArray.parseArray(request.getParameter("datas"));
        upmsUserPermissionService.permission(datas, id);
        return new UpmsResult(UpmsResultConstant.SUCCESS, datas.size());
    }

    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    public String organization(@PathVariable("id") int id, ModelMap modelMap) {
        // 所有组织
        List<UpmsOrganization> upmsOrganizations = upmsOrganizationService.selectByExample(new UpmsOrganizationExample());
        // 用户拥有组织
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserOrganization> upmsUserOrganizations = upmsUserOrganizationService.selectByExample(upmsUserOrganizationExample);
        modelMap.put("upmsOrganizations", upmsOrganizations);
        modelMap.put("upmsUserOrganizations", upmsUserOrganizations);
        return "/upms/user/organization.jsp";
    }


    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object organization(@PathVariable("id") int id, HttpServletRequest request) {
        String[] organizationIds = request.getParameterValues("organizationId");
        upmsUserOrganizationService.organization(organizationIds, id);
        return new UpmsResult(UpmsResultConstant.SUCCESS, "");
    }


}
