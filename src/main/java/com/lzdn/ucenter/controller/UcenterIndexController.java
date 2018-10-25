//package com.lzdn.ucenter.controller;
//
//import com.lzdn.common.base.BaseController;
//import com.lzdn.upms.dao.model.UpmsPermission;
//import com.lzdn.upms.dao.model.UpmsSystem;
//import com.lzdn.upms.dao.model.UpmsSystemExample;
//import com.lzdn.upms.dao.model.UpmsUser;
//import com.lzdn.upms.service.UpmsApiService;
//import com.lzdn.upms.service.UpmsSystemService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//
//@Controller
//@RequestMapping("/ucenter")
//public class UcenterIndexController extends BaseController {
//    @Autowired
//    private UpmsSystemService upmsSystemService;
//
//    @Autowired
//    private UpmsApiService upmsApiService;
//
//    @RequestMapping("")
//    public String index(ModelMap modelMap){
//        //已注册系统
//        UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
//        upmsSystemExample.createCriteria().andStatusEqualTo((byte)1);
//        List<UpmsSystem> upmsSystems = upmsSystemService.selectByExample(upmsSystemExample);
//        modelMap.put("upmsSystems",upmsSystems);
//        //当前登陆用户权限
//        Subject subject = SecurityUtils.getSubject();
//        String username = (String)subject.getPrincipal();
//        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
//        modelMap.put("upmsUser",upmsUser);
//        List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(upmsUser.getUserId());
//        modelMap.put("upmsPermissions",upmsPermissions);
//        return "ucenter/index.jsp";
//    }
//}
