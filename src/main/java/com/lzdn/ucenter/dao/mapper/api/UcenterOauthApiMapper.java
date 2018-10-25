package com.lzdn.ucenter.dao.mapper.api;

import com.lzdn.ucenter.dto.UcenterOauthDto;

import java.util.List;

public interface UcenterOauthApiMapper {
    //查询所有认证方式信息
    List<UcenterOauthDto> selectOauthByUserId(int id);
}
