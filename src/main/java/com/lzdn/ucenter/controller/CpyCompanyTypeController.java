package com.lzdn.ucenter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzdn.common.base.BaseController;
import com.lzdn.ucenter.common.UcenterResult;
import com.lzdn.ucenter.common.UcenterResultConstant;
import com.lzdn.ucenter.dao.model.*;
import com.lzdn.ucenter.dto.CpyCompanyTypeDto;
import com.lzdn.ucenter.service.CpyCompanyTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "公司类别管理", description = "公司类别管理")
@Controller
@RequestMapping("ucenter/companyType")
public class CpyCompanyTypeController extends BaseController {
    @Autowired
    private CpyCompanyTypeService cpyCompanyTypeService;


    @ApiOperation(value = "公司类别首页")
    @RequestMapping(value = "index",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:companyType:read")
    public String indexView(ModelMap modelMap){
        return "ucenter/companytype/index.jsp";
    }

    @ApiOperation(value = "公司类别首页")
    @RequestMapping(value = "list/{pid}",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:companyType:read")
    @ResponseBody
    public Object list(
            @PathVariable(value = "pid")int pid,
            @RequestParam(required = false,defaultValue = "0",value = "offset")int offset,
            @RequestParam(required = false,defaultValue = "10",value = "limit")int limit,
            @RequestParam(required = false,defaultValue = "",value = "search")String search,
            @RequestParam(required = false,defaultValue = "id",value = "sort")String sort,
            @RequestParam(required = false,defaultValue = "asc",value = "order")String order){

        CpyCompanyTypeExample cpyCompanyTypeExample = new CpyCompanyTypeExample();
        CpyCompanyTypeExample.Criteria criteria = cpyCompanyTypeExample.createCriteria();
        //条件搜索时取消父子表模式，无条件时恢复父子表模式
        if(StringUtils.isNotBlank(search)){
            criteria.andTypeNameLike("%"+search+"%");
        }else{
            criteria.andPidEqualTo(pid);
        }
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            cpyCompanyTypeExample.setOrderByClause(sort+" "+order);
        }
        List<CpyCompanyType> cpyCompanyTypes = cpyCompanyTypeService.selectByExampleForOffsetPage(cpyCompanyTypeExample,offset,limit);
        int count = cpyCompanyTypeService.countByExample(cpyCompanyTypeExample);
        Map<String,Object> result = new HashMap <>(2);
        result.put("rows",cpyCompanyTypes);
        result.put("total",count);
        return result;
    }
    @ApiOperation(value = "新增类别")
    @RequestMapping(value = "create",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:companyType:create")
    public String createView(ModelMap modelMap){
        CpyCompanyTypeExample cpyCompanyTypeExample = new CpyCompanyTypeExample();
        //查询顶级分类
        cpyCompanyTypeExample.createCriteria().andPidEqualTo(0);
        List<CpyCompanyType> cpyCompanyTypes = cpyCompanyTypeService.selectByExample(cpyCompanyTypeExample);
        modelMap.put("cpyCompanyTypes",cpyCompanyTypes);
        return "ucenter/companytype/create.jsp";
    }
    @ApiOperation(value = "新增类别")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @RequiresPermissions("ucenter:companyType:create")
    @ResponseBody
    public Object create(CpyCompanyType cpyCompanyType){
        int count = cpyCompanyTypeService.insert(cpyCompanyType);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }
    @ApiOperation(value = "编辑类别")
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    @RequiresPermissions("ucenter:companyType:update")
    public String updateView(@PathVariable("id")int id, ModelMap modelMap){
        //TODO 遍历所有父节点，暂无后续操作，待添加 2018.07.27
        List<CpyCompanyType> cpyCompansyTypes = cpyCompanyTypeService.getParentList(id);
        System.out.println(cpyCompansyTypes);
        //获取选中的类别属性（简化jsp页面复杂度）
        int finalId = id;
        cpyCompansyTypes.forEach(cpyCompanyType -> {if(cpyCompanyType.getId()== finalId){ modelMap.put("cpyCompanyType",cpyCompanyType); }});
        //暂时不添加节点改变
//        List<CpyCompanyTypeDto> cpyCompanyTypeDtoList = cpyCompanyTypeService.getTree(0);
//        modelMap.put("cpyCompanyTypeDtoList",cpyCompanyTypeDtoList);
//        modelMap.put("cpyCompanyTypes",cpyCompansyTypes);
//        List<CpyCompanyTypeDto> cl1 = new ArrayList <>(4);
//        for(int i=0;i<cpyCompansyTypes.size();i++){
//            CpyCompanyTypeDto cctd = new CpyCompanyTypeDto();
//            cctd.setId(cpyCompansyTypes.get(i).getId());
//            cctd.setPid(cpyCompansyTypes.get(i).getPid());
//            cctd.setTypeName(cpyCompansyTypes.get(i).getTypeName());
//            cl1.add(cctd);
//        }
//        for(int i = 0;i<cl1.size();i++){
//            for(int j = 0;j<cl1.size();j++){
//                if(cl1.get(i).getId().equals(cl1.get(j).getPid())){
//                    List<CpyCompanyTypeDto> cl2 = new ArrayList <>();
//                    cl2.add(cl1.get(j));
//                    cl1.get(i).setCpyCompanyTypeDtoList(cl2);
//                }
//            }
//        }
//        while(cl1.size()>1){
//            Map<String,Object> map = find(cl1,id);
//            cl1 = (List <CpyCompanyTypeDto>) map.get("list");
//            id = (int) map.get(id);
//            if(map.isEmpty()){
//                return "500.jsp";
//            }
//        }
//        System.out.println(cl1);
        return "ucenter/companytype/update.jsp";
    }
    @ApiOperation(value = "编辑类别")
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    @RequiresPermissions("ucenter:companyType:update")
    @ResponseBody
    public Object update(@PathVariable("id")int id,CpyCompanyType cpyCompanyType){
        cpyCompanyType.setId(id);
        int count  =cpyCompanyTypeService.updateByPrimaryKeySelective(cpyCompanyType);
        return new UcenterResult(UcenterResultConstant.SUCCESS,count);
    }

//    Map<String ,Object> find(List<CpyCompanyTypeDto> list,int id){
//        Map<String ,Object> map = new HashMap <>();
//        for(int i =0;i<list.size();i++){
//            if(list.get(i).getId()==id){
//                List<CpyCompanyTypeDto> cctdlist = new ArrayList <>(1);
//                CpyCompanyTypeDto cpyCompanyTypeDto = cpyCompanyTypeDto = list.get(i);
//                cctdlist.add(cpyCompanyTypeDto);
//                list.remove(i);
//                for(int j=0;j<list.size();j++){
//                    if(cpyCompanyTypeDto.getPid().equals(list.get(j).getId())){
//                        list.get(j).setCpyCompanyTypeDtoList(cctdlist);
//                        id = list.get(i).getId();
//                        map.put("list",list);
//                        map.put("id",id);
//                    }
//                }
//
//            }
//        }
//        return map;
//    }

}
