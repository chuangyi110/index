package com.lzdn.ucenter.service;

import com.lzdn.common.base.BaseService;
import com.lzdn.ucenter.dao.model.UcenterUserOauth;
import com.lzdn.ucenter.dao.model.UcenterUserOauthExample;

/**
* UcenterUserOauthService接口
* Created by realMess on 2018/7/19.
*/
public interface UcenterUserOauthService extends BaseService<UcenterUserOauth, UcenterUserOauthExample> {

    int updateStatusByPrimaryKey(String ids);
}