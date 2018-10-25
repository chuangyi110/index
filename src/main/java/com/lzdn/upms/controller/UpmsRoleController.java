package com.lzdn.upms.controller;

import com.alibaba.fastjson.JSONArray;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.lzdn.common.base.BaseController;
import com.lzdn.common.validator.LengthValidator;
import com.lzdn.sys.common.SysResult;
import com.lzdn.upms.common.UpmsResult;
import com.lzdn.upms.common.UpmsResultConstant;
import com.lzdn.upms.dao.model.UpmsRole;
import com.lzdn.upms.dao.model.UpmsRoleExample;
import com.lzdn.upms.dao.model.UpmsRolePermission;
import com.lzdn.upms.service.UpmsRolePermissionService;
import com.lzdn.upms.service.UpmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("upms/role")
@Api(value = "角色管理", description = "角色管理")
public class UpmsRoleController extends BaseController {
    @Autowired
    private UpmsRoleService upmsRoleService;
    @Autowired
    private UpmsRolePermissionService upmsRolePermissionService;


    @ApiOperation(value = "角色首页")
    @RequiresPermissions("upms:role:read")
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String indexView(){
        return "upms/role/index.jsp";
    }

    @ApiOperation(value = "角色权限")
    @RequiresPermissions("upms:role:permission")
    @RequestMapping(value = "permission/{id}",method = RequestMethod.GET)
    public String permissionView(@PathVariable("id")int id, ModelMap modelMap){
        UpmsRole role = upmsRoleService.selectByPrimaryKey(id);
        modelMap.put("role",role);
        return "upms/role/permission.jsp";
    }

    @ApiOperation(value="角色权限")
    @RequiresPermissions("upms:role:permission")
    @RequestMapping(value = "permission/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object permission(@PathVariable("id")int id, HttpServletRequest req){
        JSONArray datas = JSONArray.parseArray(req.getParameter("datas"));
        int result = upmsRolePermissionService.rolePermisssion(datas,id);
        return new UpmsResult(UpmsResultConstant.SUCCESS,result);
    }
    @ApiOperation(value = "角色列表")
    @RequiresPermissions("upms:role:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object listView(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsRoleExample upmsRoleExample = new UpmsRoleExample();
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsRoleExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            upmsRoleExample.or()
                    .andTitleLike("%" + search + "%");
        }
        List<UpmsRole> rows = upmsRoleService.selectByExampleForOffsetPage(upmsRoleExample, offset, limit);
        long total = upmsRoleService.countByExample(upmsRoleExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }
    @ApiOperation(value = "新增角色")
    @RequiresPermissions("upms:role:create")
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createView(ModelMap modelMap){
        return "upms/role/create.jsp";
    }
    @ApiOperation(value = "新增角色")
    @RequiresPermissions("upms:role:create")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Object create(UpmsRole upmsRole){
        ComplexResult result =FluentValidator.checkAll()
                .on(upmsRole.getName(),new LengthValidator(1,20,"名称"))
                .on(upmsRole.getTitle(),new LengthValidator(1,20,"标题"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if(!result.isSuccess()){
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH,result.getErrors());
        }
        long time = System.currentTimeMillis();
        upmsRole.setCtime(time);
        upmsRole.setOrders(time);
        int count = upmsRoleService.insertSelective(upmsRole);
        return new UpmsResult(UpmsResultConstant.SUCCESS,count);
    }


    @ApiOperation(value = "删除角色")
    @RequiresPermissions("upms:role:delete")
    @RequestMapping(value = "delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids")String ids){
        int count = upmsRoleService.deleteByPrimaryKeys(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS,count);
    }


    @ApiOperation(value = "修改角色")
    @RequiresPermissions("upms:role:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String updateView(@PathVariable("id")int id,ModelMap modelMap){
        UpmsRole role = upmsRoleService.selectByPrimaryKey(id);
        modelMap.put("role",role);
        return "upms/role/update.jsp";
    }
    @ApiOperation(value = "修改角色")
    @RequiresPermissions("upms:role:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id")int id, UpmsRole upmsRole){
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsRole.getName(),new LengthValidator(1,20,"名称"))
                .on(upmsRole.getTitle(),new LengthValidator(1,20,"标题"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if(!result.isSuccess()){
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH,result.getErrors());
        }
        upmsRole.setRoleId(id);
        int count = upmsRoleService.updateByPrimaryKeySelective(upmsRole);
        return new UpmsResult(UpmsResultConstant.SUCCESS,count);
    }
}
