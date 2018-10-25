package com.lzdn.ucenter.controller;

import com.lzdn.common.base.BaseController;
import com.lzdn.ucenter.common.UcenterResult;
import com.lzdn.ucenter.common.UcenterResultConstant;
import com.lzdn.ucenter.dao.model.UcenterOauth;
import com.lzdn.ucenter.dao.model.UcenterOauthExample;
import com.lzdn.ucenter.dao.model.UcenterUserOauth;
import com.lzdn.ucenter.dto.UcenterOauthDto;
import com.lzdn.ucenter.service.UcenterOauthService;
import com.lzdn.ucenter.service.UcenterUserOauthService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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


@Api(value = "认证方式管理",description = "认证方式管理")
@Controller
@RequestMapping("ucenter/oauth")
public class UcenterOauthController extends BaseController {
    @Autowired
    private UcenterOauthService ucenterOauthService;

    @Autowired
    private UcenterUserOauthService ucenterUserOauthService;

    @ApiOperation("认证方式首页")
    @RequestMapping(value = "index",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:oauth:read")
    public String indexView(ModelMap modelMap){
        return "ucenter/oauth/index.jsp";
    }

    @ApiOperation("认证方式列表")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:oauth:read")
    @ResponseBody
    public Object list(
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order){
        UcenterOauthExample ucenterOauthExample = new UcenterOauthExample();
        UcenterOauthExample.Criteria criteria = ucenterOauthExample.createCriteria();
        if(StringUtils.isNotBlank(search)){
            criteria.andNameLike(search);
        }
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            ucenterOauthExample.setOrderByClause(sort+" "+order);
        }
        List<UcenterOauth> ucenterOauths = ucenterOauthService.selectByExampleForOffsetPage(ucenterOauthExample,offset,limit);
        int count = ucenterOauthService.countByExample(ucenterOauthExample);
        Map<String,Object> result = new HashMap<>(2);
        result.put("rows",ucenterOauths);
        result.put("total",count);
        return result;
    }
    @ApiOperation("添加认证方式")
    @RequestMapping(value = "create",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:oauth:create")
    public String createView(ModelMap modelMap){
        return "ucenter/oauth/create.jsp";
    }

    @ApiOperation("添加认证方式")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @RequiresPermissions("ucenter:oauth:create")
    @ResponseBody
    public Object create(UcenterOauth ucenterOauth){
        int count  = ucenterOauthService.insertSelective(ucenterOauth);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }
    @ApiOperation("编辑认证方式")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:oauth:update")
    public String updateView(@PathVariable("id")int id,ModelMap modelMap){
        UcenterOauthExample ucenterOauthExample = new UcenterOauthExample();
        UcenterOauth ucenterOauth = ucenterOauthService.selectByPrimaryKey(id);
        modelMap.put("ucenterOauth",ucenterOauth);
        return "ucenter/oauth/update.jsp";
    }

    @ApiOperation("编辑认证方式")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @RequiresPermissions("ucenter:oauth:update")
    @ResponseBody
    public Object update(@PathVariable("id")int id,UcenterOauth ucenterOauth){
        ucenterOauth.setOauthId(id);
        int count = ucenterOauthService.updateByPrimaryKeySelective(ucenterOauth);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }
    @ApiOperation("删除认证方式")
    @RequestMapping(value = "delete/{ids}",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:oauth:delete")
    @ResponseBody
    //TODO
    public Object delete(@PathVariable("ids")String ids,ModelMap modelMap){
        int count = ucenterUserOauthService.updateStatusByPrimaryKey(ids);
        return "";
    }


}
