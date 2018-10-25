package com.lzdn.upms.service.serviceMock;

import com.alibaba.fastjson.JSONArray;
import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.upms.service.UpmsRolePermissionService;
import com.lzdn.upms.dao.mapper.UpmsRolePermissionMapper;
import com.lzdn.upms.dao.model.UpmsRolePermission;
import com.lzdn.upms.dao.model.UpmsRolePermissionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsRolePermissionService接口
* Created by shuzheng on 2018/7/11.
*/
public class UpmsRolePermissionServiceMock extends BaseServiceMock<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRolePermissionServiceMock.class);



    @Override
    public int rolePermisssion(JSONArray datas, int id) {
        LOGGER.info("UpmsRolePermissionServiceMock => rolePermission");
        return 0;
    }
}
