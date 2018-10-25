package com.lzdn.ucenter.service;

import com.lzdn.common.base.BaseService;
import com.lzdn.ucenter.ao.UcenterTableAo;
import com.lzdn.ucenter.dao.model.UcenterUser;
import com.lzdn.ucenter.dao.model.UcenterUserExample;
import com.lzdn.ucenter.dto.UcenterUserDto;

import java.util.List;

/**
* UcenterUserService接口
* Created by realMess on 2018/7/19.
*/
public interface UcenterUserService extends BaseService<UcenterUser, UcenterUserExample> {

    List<UcenterUserDto> selectFullMessageForOffsetPage(UcenterTableAo ucenterTableAo, String ucenterOauths);
}