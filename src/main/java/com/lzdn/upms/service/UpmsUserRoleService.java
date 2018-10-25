package com.lzdn.upms.service;

import com.lzdn.common.base.BaseService;
import com.lzdn.upms.dao.model.UpmsUserRole;
import com.lzdn.upms.dao.model.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* Created by realMess on 2018/7/11.
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {
    /**
     * 用户角色
     * @param roleIds 角色ids
     * @param id 用户id
     * @return
     */
    int role(String[] roleIds, int id);
}