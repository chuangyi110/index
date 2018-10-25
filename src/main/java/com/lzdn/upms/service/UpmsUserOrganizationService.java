package com.lzdn.upms.service;

import com.lzdn.common.base.BaseService;
import com.lzdn.upms.dao.model.UpmsUserOrganization;
import com.lzdn.upms.dao.model.UpmsUserOrganizationExample;

/**
* UpmsUserOrganizationService接口
* Created by realMess on 2018/7/11.
*/
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {
    /**
     * 用户组织
     * @param organizationIds 组织ids
     * @param id 用户id
     * @return
     */
    int organization(String[] organizationIds, int id);
}