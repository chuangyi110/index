package com.lzdn.upms.service;

import com.alibaba.fastjson.JSONArray;
import com.lzdn.common.base.BaseService;
import com.lzdn.upms.dao.model.UpmsUserPermission;
import com.lzdn.upms.dao.model.UpmsUserPermissionExample;

/**
* UpmsUserPermissionService接口
* Created by realMess on 2018/7/11.
*/
public interface UpmsUserPermissionService extends BaseService<UpmsUserPermission, UpmsUserPermissionExample> {
    /**
     * 用户权限
     * @param datas 权限数据
     * @param id 用户id
     * @return
     */
    int permission(JSONArray datas, int id);
}