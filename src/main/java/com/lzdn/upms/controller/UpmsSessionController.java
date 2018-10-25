package com.lzdn.upms.controller;

import com.lzdn.common.base.BaseController;
import com.lzdn.upms.common.UpmsResult;
import com.lzdn.upms.common.UpmsResultConstant;
import com.lzdn.upms.shiro.session.UpmsSessionDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;

@Controller
@Api(value = "会话管理",description = "会话管理")
@RequestMapping(value = "upms/session")
public class UpmsSessionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsSessionController.class);

    @Autowired
    private UpmsSessionDao upmsSessionDao;
    @ApiOperation(value = "会话首页")
    @RequiresPermissions("upms:session:read")
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String indexView(){
        return "upms/session/index.jsp";
    }

    @ApiOperation(value = "会话列表")
    @RequiresPermissions("upms:session:read")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit){
        return upmsSessionDao.getActiveSessions(offset, limit);
    }
    @ApiOperation(value = "强制退出")
    @RequiresPermissions("upms:session:forceout")
    @RequestMapping(value = "/forceout/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object forceout(@PathVariable("ids") String ids) {
        int count = upmsSessionDao.forceout(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }
}
