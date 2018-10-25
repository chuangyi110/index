package com.lzdn.ucenter.controller;

import com.lzdn.cms.common.CmsConstants;
import com.lzdn.cms.common.CmsResult;
import com.lzdn.common.base.BaseController;
import com.lzdn.common.util.StringUtil;
import com.lzdn.ucenter.common.UcenterResult;
import com.lzdn.ucenter.common.UcenterResultConstant;
import com.lzdn.ucenter.dao.model.*;
import com.lzdn.ucenter.service.CpyActivityService;
import com.lzdn.ucenter.service.CpyActivityTypeService;
import com.lzdn.ucenter.service.CpyCompanyService;
import com.lzdn.ucenter.service.CpyGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "活动管理",description = "活动管理")
@Controller
@RequestMapping("ucenter/activity")
public class CpyActivityController  extends BaseController {
    @Autowired
    private CpyActivityService cpyActivityService;
    @Autowired
    private CpyActivityTypeService cpyActivityTypeService;
    @Autowired
    private CpyCompanyService cpyCompanyService;
    @Autowired
    private CpyGoodsService cpyGoodsService;



    @ApiOperation(value = "活动管理首页")
    @RequestMapping("index")
    @RequiresPermissions("ucenter:activity:read")
    public String indexView(ModelMap modelMap) {
        CpyActivityTypeExample cpyActivityTypeExample = new CpyActivityTypeExample();
        List<CpyActivityType> cpyActivityTypes = cpyActivityTypeService.selectByExample(cpyActivityTypeExample);
        modelMap.put("cpyActivityTypes",cpyActivityTypes);
        return "ucenter/activity/index.jsp";
    }
    @ApiOperation(value = "活动管理列表")
    @RequestMapping("list")
    @RequiresPermissions("ucenter:activity:read")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, defaultValue = "activity_type_id", value = "sort") String sort,
            @RequestParam(required = false, defaultValue = "", value = "activitytype") int activitytype,
            @RequestParam(required = false, defaultValue = "asc", value = "order") String order){
        System.out.println(activitytype);
        CpyActivityExample cpyActivityExample = new CpyActivityExample();
        CpyActivityExample.Criteria criteria = cpyActivityExample.createCriteria();
        //模糊搜索活动规则
        if(StringUtils.isNotBlank(search)){
            criteria.andActivityRulesLike("%"+search+"%");
        }
        //附加条件
        if(activitytype!=0){
            criteria.andActivityTypeIdEqualTo(activitytype);
        }
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            sort = StringUtil.humpToLine(sort);
            cpyActivityExample.setOrderByClause(sort+" "+order);
        }

        List<CpyActivity> cpyActivities = cpyActivityService.selectByExampleForOffsetPage(cpyActivityExample,offset,limit);
        int total = cpyActivityService.countByExample(cpyActivityExample);
        Map<String,Object> result = new HashMap<>(2);
        result.put("rows",cpyActivities);
        result.put("total",total);
        return result;
    }
    @ApiOperation("产品")
    @RequestMapping(value="goods/{id}",method = RequestMethod.POST)
    @RequiresPermissions("ucenter:activity:create")
    @ResponseBody
    public Object goodsList(@PathVariable("id")int id){
        System.out.println(id);
        CpyGoodsExample cpyGoodsExample = new CpyGoodsExample();
        cpyGoodsExample.createCriteria().andCompanyIdEqualTo(id);
        List<CpyGoods> cpyGoods = cpyGoodsService.selectByExample(cpyGoodsExample);
        Map<String,Object> result = new HashMap <>(2);
        result.put("rows",cpyGoods);
        return result;
    }

    @ApiOperation("添加活动")
    @RequestMapping(value = "create",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:activity:create")
    public String createView(ModelMap modelMap){
        CpyCompanyExample  cpyCompanyExample = new CpyCompanyExample();
        List<CpyCompany> cpyCompanies = cpyCompanyService.selectByExample(cpyCompanyExample);
        modelMap.put("cpyCompanies",cpyCompanies);
        CpyActivityTypeExample cpyActivityTypeExample = new CpyActivityTypeExample();
        List<CpyActivityType> cpyActivityTypes = cpyActivityTypeService.selectByExample(cpyActivityTypeExample);
        modelMap.put("cpyActivityTypes",cpyActivityTypes);
        return "ucenter/activity/create.jsp";
    }
    @ApiOperation("添加活动")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @RequiresPermissions("ucenter:activity:create")
    @ResponseBody
    public Object create(CpyActivity cpyActivity){
        cpyActivity.setActivityStatus((byte)0);
        int typeId = cpyActivity.getActivityTypeId();
        if(typeId==1){
            cpyActivity.setMoneyOff(null);
            cpyActivity.setMoneyOffPrerequisite(null);
            cpyActivity.setMoneyOffType(null);
            cpyActivity.setSendFull(null);
            cpyActivity.setSendFullOtherGoodsId(null);
            cpyActivity.setSendFullType(null);
        }else if(typeId==2){
            cpyActivity.setDiscount(null);
            if(cpyActivity.getSendFullType()==0){
                cpyActivity.setSendFullOtherGoodsId(null);
            }
            cpyActivity.setMoneyOff(null);
            cpyActivity.setMoneyOffPrerequisite(null);
            cpyActivity.setMoneyOffType(null);
        }else if(typeId==3){
            cpyActivity.setDiscount(null);
            cpyActivity.setSendFull(null);
            cpyActivity.setSendFullOtherGoodsId(null);
            cpyActivity.setSendFullType(null);
        }else{
            return new UcenterResult(UcenterResultConstant.FAILED,"");
        }
        System.out.println(cpyActivity);
        int count = cpyActivityService.insertSelective(cpyActivity);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }
    @ApiOperation("编辑活动")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:activity:update")
    public String updateView(@PathVariable("id")int id,ModelMap modelMap){
        CpyGoodsExample cpyGoodsExample = new CpyGoodsExample();
        cpyGoodsExample.createCriteria().andCompanyIdEqualTo(id);
        List<CpyGoods> cpyGoods = cpyGoodsService.selectByExample(cpyGoodsExample);
        modelMap.put("cpyGoods",cpyGoods);
        CpyActivity cpyActivity = cpyActivityService.selectByPrimaryKey(id);
        modelMap.put("cpyActivity",cpyActivity);
        return "ucenter/activity/update.jsp";
    }
    @ApiOperation("编辑活动")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @RequiresPermissions("ucenter:activity:update")
    @ResponseBody
    public Object update(@PathVariable("id")int id,CpyActivity cpyActivity){
        cpyActivity.setActivityId(id);
        int count = cpyActivityService.updateByPrimaryKey(cpyActivity);
        System.out.println(cpyActivity);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

    @ApiOperation("活动状态")
    @RequestMapping(value = "status/{id}",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:activity:delete")
    @ResponseBody
    public Object status(@PathVariable("id")int id){
        CpyActivity cpyActivity = new CpyActivity();
        cpyActivity.setActivityId(id);
        int count = cpyActivityService.changeStatusById(id);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }





}