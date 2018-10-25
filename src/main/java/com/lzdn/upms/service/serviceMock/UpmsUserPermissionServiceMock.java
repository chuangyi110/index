package com.lzdn.upms.service.serviceMock;

import com.alibaba.fastjson.JSONArray;
import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.upms.service.UpmsUserPermissionService;
import com.lzdn.upms.dao.mapper.UpmsUserPermissionMapper;
import com.lzdn.upms.dao.model.UpmsUserPermission;
import com.lzdn.upms.dao.model.UpmsUserPermissionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsUserPermissionService接口
* Created by shuzheng on 2018/7/11.
*/
public class UpmsUserPermissionServiceMock extends BaseServiceMock<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserPermissionServiceMock.class);

    @Override
    public int permission(JSONArray datas, int id) {
        LOGGER.info("UpmsUserPermissionServiceMock => permission");
        return 0;
    }
}
