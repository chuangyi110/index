package com.lzdn.ucenter.controller;

import com.lzdn.common.base.BaseController;
import com.lzdn.common.util.StringUtil;
import com.lzdn.ucenter.common.UcenterResult;
import com.lzdn.ucenter.common.UcenterResultConstant;
import com.lzdn.ucenter.dao.model.CpyCompany;
import com.lzdn.ucenter.dao.model.CpyGoodsType;
import com.lzdn.ucenter.dao.model.CpyGoodsTypeExample;
import com.lzdn.ucenter.service.CpyGoodsTypeService;
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

@Api(value = "通用产品类别",description = "通用产品类别")
@Controller
@RequestMapping("ucenter/goodstype")
public class CpyGoodsTypeController extends BaseController {

    @Autowired
    private CpyGoodsTypeService cpyGoodsTypeService;
    @ApiOperation("通用产品类别首页")
    @RequestMapping("index")
    @RequiresPermissions("ucenter:goodstype:read")
    public String indexView(ModelMap modelMap) {
        return "ucenter/goodstype/index.jsp";
    }

    @ApiOperation("通用产品类别列表")
    @RequestMapping("list/{pid}")
    @RequiresPermissions("ucenter:goodstype:read")
    @ResponseBody
    public Object list(
            @PathVariable("pid") int pid,
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, defaultValue = "goodsTypeId", value = "sort") String sort,
            @RequestParam(required = false, defaultValue = "asc", value = "order") String order) {
        CpyGoodsTypeExample cpyGoodsTypeExample = new CpyGoodsTypeExample();
        CpyGoodsTypeExample.Criteria criteria = cpyGoodsTypeExample.createCriteria();
        //条件搜索时取消父子表模式，无条件时恢复父子表模式
        if(StringUtils.isNotBlank(search)){
            criteria.andNameLike("%"+search+"%");
        }else {
            criteria.andPidEqualTo(pid);
        }
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            sort = StringUtil.humpToLine(sort);
            cpyGoodsTypeExample.setOrderByClause(sort+" "+order);
        }
        List<CpyGoodsType> cpyGoodsTypes = cpyGoodsTypeService.selectByExampleForOffsetPage(cpyGoodsTypeExample,offset,limit);
        int count = cpyGoodsTypeService.countByExample(cpyGoodsTypeExample);
        Map<String,Object> result = new HashMap <>(2);
        result.put("rows",cpyGoodsTypes);
        result.put("total",count);
        return result;
    }
    @ApiOperation("添加通用产品类型")
    @RequiresPermissions("ucenter:goodstype:create")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createView(ModelMap modelMap){
        CpyGoodsTypeExample cpyGoodsTypeExample = new CpyGoodsTypeExample();
        //查询首级菜单
        cpyGoodsTypeExample.createCriteria().andPidEqualTo(0);
        List<CpyGoodsType> cpyGoodsTypes = cpyGoodsTypeService.selectByExample(cpyGoodsTypeExample);
        modelMap.put("cpyGoodsTypes",cpyGoodsTypes);
        return "ucenter/goodstype/create.jsp";
    }
    @ApiOperation("添加通用产品类型")
    @RequiresPermissions("ucenter:goodstype:create")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Object create(CpyGoodsType cpyGoodsType){
        System.out.println(cpyGoodsType);
        int count = cpyGoodsTypeService.insertSelective(cpyGoodsType);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

    @ApiOperation("修改通用产品类型")
    @RequiresPermissions("ucenter:goodstype:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String updateView(@PathVariable("id")int id,ModelMap modelMap){
        CpyGoodsType cpyGoodsType = cpyGoodsTypeService.selectByPrimaryKey(id);
        modelMap.put("cpyGoodsType",cpyGoodsType);
        return "ucenter/goodstype/update.jsp";
    }
    @ApiOperation("修改通用产品类型")
    @RequiresPermissions("ucenter:goodstype:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id")int id,CpyGoodsType cpyGoodsType){
        cpyGoodsType.setGoodsTypeId(id);
        int count = cpyGoodsTypeService.updateByPrimaryKeySelective(cpyGoodsType);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

    @ApiOperation("删除通用产品类型")
    @RequiresPermissions("ucenter:goodstype:delete")
    @RequestMapping(value ="delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("id")int id ){
        CpyGoodsTypeExample cpyGoodsTypeExample = new CpyGoodsTypeExample();
        cpyGoodsTypeExample.createCriteria().andPidEqualTo(id);
        int count = cpyGoodsTypeService.countByExample(cpyGoodsTypeExample);
        if(count>0){
            return new UcenterResult(UcenterResultConstant.FAILED,"类型下有子类型未处理，无法删除");
        }else{
            int count2 = cpyGoodsTypeService.deleteByPrimaryKey(id);
            return new UcenterResult(UcenterResultConstant.SUCCESS,count2);
        }

    }

}
