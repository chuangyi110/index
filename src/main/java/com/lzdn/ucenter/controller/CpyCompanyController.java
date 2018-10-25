package com.lzdn.ucenter.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.lzdn.common.validator.LengthValidator;
import com.lzdn.common.validator.NotNullValidator;
import com.lzdn.ucenter.common.UcenterConstants;
import com.lzdn.ucenter.common.UcenterResult;
import com.lzdn.ucenter.common.UcenterResultConstant;
import com.lzdn.ucenter.dao.model.*;
import com.lzdn.ucenter.service.*;
import com.lzdn.common.base.BaseController;
import com.lzdn.common.util.StringUtil;
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
@RequestMapping("ucenter/company")
@Api(value = "公司管理", description = "公司管理")
public class CpyCompanyController extends BaseController {
    @Autowired
    private CpyCompanyService cpyCompanyService;
    @Autowired
    private ProProvincesService proProvincesService;
    @Autowired
    private ProCitiesService proCitiesService;
    @Autowired
    private ProAreasService proAreasService;
    @Autowired
    private CpyCompanyTypeService cpyCompanyTypeService;

    @ApiOperation("公司管理首页")
    @RequestMapping("index")
    @RequiresPermissions("ucenter:company:read")
    public String companyView(ModelMap modelMap){
        ProProvincesExample proProvincesExample = new ProProvincesExample();
        List<ProProvinces> proProvinces = proProvincesService.selectByExample(proProvincesExample);
        modelMap.put("proProvinces",proProvinces);
        return "ucenter/company/index.jsp";
    }


    @ApiOperation("公司管理首页")
    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:company:read")
    public Object companyList(
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "company_id",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order,
            @RequestParam(required = false,defaultValue = "0",value = "provinceId")int provinceId,
            @RequestParam(required = false,defaultValue = "0",value = "cityId")int cityId,
            @RequestParam(required = false,defaultValue = "0",value = "areaId")int areaId){
        CpyCompanyExample cpyCompanyExample = new CpyCompanyExample();
        CpyCompanyExample.Criteria criteria = cpyCompanyExample.createCriteria();
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            sort = StringUtil.humpToLine(sort);
            cpyCompanyExample.setOrderByClause(sort+" "+order);
        }
        if(StringUtils.isNotBlank(search)){
            criteria.andCompanyNameLike("%"+search+"%");
        }
        //设置选中城市
        if(areaId!=0){
            criteria.andAreasIdEqualTo(areaId);
        }else {
            if(cityId!=0) {
                criteria.andCitiesIdEqualTo(cityId);
            }else{
                if(provinceId!=0){
                    criteria.andProvincesIdEqualTo(provinceId);
                }
            }
        }
        List<CpyCompany> rows = cpyCompanyService.selectByExampleForOffsetPage(cpyCompanyExample,offset,limit);
        long total = cpyCompanyService.countByExample(cpyCompanyExample);
        Map<String,Object> result = new HashMap<>();
        result.put("rows",rows);
        result.put("total",total);
        return result;
    }

    @ApiOperation(value = "新增公司")
    @RequiresPermissions("ucenter:company:create")
    @RequestMapping(value = "create",method = RequestMethod.GET)
    public String createView(ModelMap modelMap){
        ProProvincesExample proProvincesExample = new ProProvincesExample();
        List<ProProvinces> proProvinces = proProvincesService.selectByExample(proProvincesExample);
        CpyCompanyTypeExample cpyCompanyTypeExample = new CpyCompanyTypeExample();
        List<CpyCompanyType> cpyCompanyTypes = cpyCompanyTypeService.selectByExample(cpyCompanyTypeExample);
        System.out.println(proProvinces.size());
        modelMap.put("proProvinces",proProvinces);
        modelMap.put("cpyCompanyTypes",cpyCompanyTypes);
        return "ucenter/company/create.jsp";
    }
    @ApiOperation(value = "查询城市列表")
    @RequiresPermissions("")
    @RequestMapping(value = "city/list",method = RequestMethod.POST)
    @ResponseBody
    public Object cityList(
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "0",value = "provinceId")int provinceId,
            @RequestParam(required = false,defaultValue = "id",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order){
        ProCitiesExample proCitiesExample = new ProCitiesExample();
        ProCitiesExample.Criteria criteria = proCitiesExample.createCriteria();
        criteria.andProvinceidEqualTo(provinceId);
        List<ProCities> rows = proCitiesService.selectByExampleForOffsetPage(proCitiesExample,offset,limit);
        int total = proCitiesService.countByExample(proCitiesExample);
        Map<String,Object> result = new HashMap<>(2);
        result.put("rows",rows);
        result.put("total",total);
        return result;
    }
    @ApiOperation(value = "查询区市列表")
    @RequiresPermissions("")
    @RequestMapping(value = "area/list",method = RequestMethod.POST)
    @ResponseBody
    public Object areaList(
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "0",value = "cityId")int cityId,
            @RequestParam(required = false,defaultValue = "id",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order){
        ProAreasExample proAreasExample = new ProAreasExample();
        ProAreasExample.Criteria criteria = proAreasExample.createCriteria();
        criteria.andCityidEqualTo(cityId);
        List<ProAreas> rows = proAreasService.selectByExampleForOffsetPage(proAreasExample,offset,limit);
        int total = proAreasService.countByExample(proAreasExample);
        Map<String,Object> result = new HashMap <>(2);
        result.put("rows",rows);
        result.put("total",total);
        return result;
    }

    @ApiOperation(value = "新增公司")
    @RequiresPermissions("ucenter:company:create")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Object create(CpyCompany cpyCompany,HttpServletRequest request){
        System.out.println(cpyCompany);
        ComplexResult result = FluentValidator.checkAll()
                .on(cpyCompany.getCompanyName(),new LengthValidator(1,20,"名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if(!result.isSuccess()){
            return new UcenterResult(UcenterResultConstant.INVALID_LENGTH,result.getErrors());
        }
        ComplexResult result1 = FluentValidator.checkAll()
                .on(cpyCompany.getProvincesId().toString(),new NotNullValidator("所属省份"))
                .on(cpyCompany.getCitiesId().toString(),new NotNullValidator("所属市区"))
                .on(cpyCompany.getAreasId().toString(),new NotNullValidator("所属区县"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if(!result.isSuccess()){
            return new UcenterResult(UcenterResultConstant.FAILED,result.getErrors());
        }
        if(StringUtils.isBlank(cpyCompany.getCompanyAvatar())){
            cpyCompany.setCompanyAvatar(UcenterConstants.DEFAULT_AVATAR);
        }
        cpyCompany.setCompanyStatus(UcenterConstants.COMPANY_TYPE_NORMAL);
        cpyCompany.setContry(UcenterConstants.CHINA);
        int count = cpyCompanyService.insertSelective(cpyCompany);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }


    @ApiOperation(value = "封停公司")
    @RequiresPermissions("ucenter:company:delete")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@PathVariable("id")int id){
        CpyCompanyExample cpyCompanyExample = new CpyCompanyExample();
        CpyCompany cpyCompany = new CpyCompany();
        cpyCompany.setCompanyId(id);
        cpyCompany.setCompanyStatus(UcenterConstants.COMPANY_TYPE_BLOCK);
        int count = cpyCompanyService.updateByPrimaryKeySelective(cpyCompany);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

    @ApiOperation(value = "编辑公司")
    @RequiresPermissions("ucenter:company:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String updateView(@PathVariable("id")int id ,ModelMap modelMap){
        CpyCompany cpyCompany =cpyCompanyService.selectByPrimaryKey(id);
        modelMap.put("cpyCompany",cpyCompany);
        //查询所有省份
        ProProvincesExample proProvincesExample = new ProProvincesExample();
        List<ProProvinces> proProvinces = proProvincesService.selectByExample(proProvincesExample);
        modelMap.put("proProvinces",proProvinces);
        //查询公司对应省的所有市
        ProCitiesExample proCitiesExample = new ProCitiesExample();
        proCitiesExample.createCriteria().andProvinceidEqualTo(cpyCompany.getProvincesId());
        List<ProCities> proCities = proCitiesService.selectByExample(proCitiesExample);
        modelMap.put("proCites",proCities);
        //查询公司对应市的所有区县
        ProAreasExample proAreasExample = new ProAreasExample();
        proAreasExample.createCriteria().andCityidEqualTo(cpyCompany.getCitiesId());
        List<ProAreas> proAreas = proAreasService.selectByExample(proAreasExample);
        modelMap.put("proAreas",proAreas);
        return "ucenter/company/update.jsp";
    }
    @ApiOperation(value = "编辑公司")
    @RequiresPermissions("ucenter:company:update")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id")int id,CpyCompany cpyCompany){
        cpyCompany.setCompanyId(id);
        System.out.println(cpyCompany);
        int count = cpyCompanyService.updateByPrimaryKeySelective(cpyCompany);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

}
