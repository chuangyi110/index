package com.lzdn.ucenter.controller;

import com.lzdn.common.base.BaseController;
import com.lzdn.common.util.StringUtil;
import com.lzdn.ucenter.common.UcenterResult;
import com.lzdn.ucenter.common.UcenterResultConstant;
import com.lzdn.ucenter.dao.model.CpyActivityExample;
import com.lzdn.ucenter.dao.model.CpyActivityType;
import com.lzdn.ucenter.dao.model.CpyActivityTypeExample;
import com.lzdn.ucenter.dao.model.CpyCompany;
import com.lzdn.ucenter.service.CpyActivityTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.gluegen.runtime.CPU;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(value = "活动类型管理",description = "活动类型管理")
@Controller
@RequestMapping("ucenter/activitytype")
public class CpyActivityTypeController extends BaseController {
    @Autowired
    private CpyActivityTypeService cpyActivityTypeService;

    @ApiOperation(value = "首页")
    @RequestMapping("index")
    @RequiresPermissions("ucenter:activitytype:read")
    public String indexView(ModelMap modelMap){
        return ("ucenter/activitytype/index.jsp");
    }

    @ApiOperation(value = "首页列表")
    @RequestMapping("list")
    @RequiresPermissions("ucenter:activitytype:read")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, defaultValue = "activity_type_id", value = "sort") String sort,
            @RequestParam(required = false, defaultValue = "asc", value = "order") String order){
        CpyActivityTypeExample cpyActivityTypeExample  = new CpyActivityTypeExample();
        CpyActivityTypeExample.Criteria criteria = cpyActivityTypeExample.createCriteria();
        if(StringUtils.isNotBlank(search)){
            criteria.andActivityTypeLike("%"+search+"%");
        }
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            sort = StringUtil.humpToLine(sort);
            cpyActivityTypeExample.setOrderByClause(sort+" "+order);
        }
        List<CpyActivityType> cpyActivityTypes = cpyActivityTypeService.selectByExampleForOffsetPage(cpyActivityTypeExample,offset,limit);
        int count = cpyActivityTypeService.countByExample(cpyActivityTypeExample);
        Map<String,Object> result = new HashMap <>(2);
        result.put("rows",cpyActivityTypes);
        result.put("total",count);
        return result;
    }
    @ApiOperation("添加活动类别")
    @RequiresPermissions("ucenter:activitytype:create")
    @RequestMapping(value = "create",method = RequestMethod.GET)
    public String createView(ModelMap modelMap){
        return "ucenter/ativitytype/create.jsp";
    }
    @ApiOperation("添加活动类别")
    @RequiresPermissions("ucenter:activitytype:create")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Object create(CpyActivityType cpyActivityType){
        int count = cpyActivityTypeService.insertSelective(cpyActivityType);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);

    }
}
