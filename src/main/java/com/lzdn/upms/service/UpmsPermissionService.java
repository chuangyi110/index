package com.lzdn.upms.service;

import com.alibaba.fastjson.JSONArray;
import com.lzdn.common.base.BaseService;
import com.lzdn.upms.dao.model.UpmsPermission;
import com.lzdn.upms.dao.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* Created by realMess on 2018/7/11.
*/
public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {
    JSONArray getTreeByRoleId(Integer roleId);

    JSONArray getTreeByUserId(Integer usereId, Byte type);
}