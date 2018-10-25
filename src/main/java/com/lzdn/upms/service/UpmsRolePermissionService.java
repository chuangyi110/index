package com.lzdn.upms.service;

import com.alibaba.fastjson.JSONArray;
import com.lzdn.common.base.BaseService;
import com.lzdn.upms.dao.model.UpmsRolePermission;
import com.lzdn.upms.dao.model.UpmsRolePermissionExample;

/**
* UpmsRolePermissionService接口
* Created by realMess on 2018/7/11.
*/
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {
    /**
     * 角色权限
     * @param datas 权限数据
     * @param id 角色id
     * @return
     */
    int rolePermisssion(JSONArray datas, int id);
}