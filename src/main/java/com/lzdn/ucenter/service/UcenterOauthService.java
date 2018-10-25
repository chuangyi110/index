package com.lzdn.ucenter.service;

import com.lzdn.common.base.BaseService;
import com.lzdn.ucenter.dao.model.UcenterOauth;
import com.lzdn.ucenter.dao.model.UcenterOauthExample;
import com.lzdn.ucenter.dto.UcenterOauthDto;

import java.util.List;

/**
* UcenterOauthService接口
* Created by realMess on 2018/7/19.
*/
public interface UcenterOauthService extends BaseService<UcenterOauth, UcenterOauthExample> {

    List<UcenterOauthDto> selectUcenterDtoByUserId(int id);
}