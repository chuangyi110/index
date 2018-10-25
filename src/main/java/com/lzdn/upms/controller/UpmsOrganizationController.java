package com.lzdn.upms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.lzdn.common.util.StringUtil;
import com.lzdn.common.validator.LengthValidator;
import com.lzdn.upms.common.UpmsResult;
import com.lzdn.upms.common.UpmsResultConstant;
import com.lzdn.upms.dao.model.UpmsOrganization;
import com.lzdn.upms.dao.model.UpmsOrganizationExample;
import com.lzdn.upms.service.UpmsOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(value = "组织管理", description = "组织管理")
@RequestMapping("upms/organization")
public class UpmsOrganizationController {
    @Autowired
    private UpmsOrganizationService upmsOrganizationService;

    @ApiOperation("组织管理首页")
    @RequestMapping(value = "index",method = RequestMethod.GET)
    @RequiresPermissions("upms:organization:read")
    public String organizationView(ModelMap modelMap){
        return "upms/organization/index.jsp";
    }
    @ApiOperation("组织管理首页")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @RequiresPermissions(" upms:organization:read")
    @ResponseBody
    public Object list(
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "organization_id",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order){
        UpmsOrganizationExample upmsOrganizationExample = new UpmsOrganizationExample();
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            sort = StringUtil.humpToLine(sort);
            upmsOrganizationExample.setOrderByClause(sort+" "+order);
        }
        if(StringUtils.isNotBlank(search)){
            upmsOrganizationExample.or().andNameLike("%"+search+"%");
        }
        List<UpmsOrganization> rows = upmsOrganizationService.selectByExampleForOffsetPage(upmsOrganizationExample,offset,limit);
        long total = upmsOrganizationService.countByExample(upmsOrganizationExample);
        Map<String,Object> result = new HashMap <>(2);
        result.put("rows",rows);
        result.put("total",total);
        return result;
    }

    @ApiOperation("新增组织")
    @RequiresPermissions("upms:organization:create")
    @RequestMapping(value = "create",method = RequestMethod.GET)
    public String create(ModelMap modelMap){
        return "upms/organization/create.jsp";
    }

    @ApiOperation("新增组织")
    @RequiresPermissions("upms:organization:create")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Object create(UpmsOrganization upmsOrganization){
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsOrganization.getName(),new LengthValidator(1,20,"名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if(!result.isSuccess()){
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH,result.getErrors());
        }
        long time = System.currentTimeMillis();
        upmsOrganization.setCtime(time);
        int count = upmsOrganizationService.insertSelective(upmsOrganization);
        return new UpmsResult(UpmsResultConstant.SUCCESS,count);

    }

    @ApiOperation("删除组织")
    @RequiresPermissions("upms:organization:delete")
    @RequestMapping(value = "delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids")String ids){
        int count = upmsOrganizationService.deleteByPrimaryKeys(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS,count);
    }

    @ApiOperation(value = "修改组织")
    @RequiresPermissions("upms:organization:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id")int id,ModelMap modelMap){
        UpmsOrganization upmsOrganization = upmsOrganizationService.selectByPrimaryKey(id);
        modelMap.put("organization",upmsOrganization);
        return "/upms/organization/update.jsp";
    }

    @ApiOperation(value = "修改组织")
    @RequiresPermissions("upms:organization:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id")int id,UpmsOrganization upmsOrganization){
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsOrganization.getName(),new LengthValidator(1,20,"名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if(!result.isSuccess()){
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH,result.getErrors());
        }
        upmsOrganization.setOrganizationId(id);
        int count = upmsOrganizationService.updateByPrimaryKeySelective(upmsOrganization);
        return new UpmsResult(UpmsResultConstant.SUCCESS,count);
    }
}
