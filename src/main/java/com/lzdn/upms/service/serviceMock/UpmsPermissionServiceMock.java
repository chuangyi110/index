package com.lzdn.upms.service.serviceMock;

import com.alibaba.fastjson.JSONArray;
import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.upms.service.UpmsPermissionService;
import com.lzdn.upms.dao.mapper.UpmsPermissionMapper;
import com.lzdn.upms.dao.model.UpmsPermission;
import com.lzdn.upms.dao.model.UpmsPermissionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsPermissionService接口
* Created by shuzheng on 2018/7/11.
*/
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsPermissionServiceMock.class);

    @Override
    public JSONArray getTreeByRoleId(Integer roleId) {
        LOGGER.info("UpmsPermissionServiceMock => getTreeByRoleId");
        return null;
    }

    @Override
    public JSONArray getTreeByUserId(Integer usereId, Byte type) {
        LOGGER.info("UpmsPermissionServiceMock => getTreeByUserId");
        return null;
    }
}
