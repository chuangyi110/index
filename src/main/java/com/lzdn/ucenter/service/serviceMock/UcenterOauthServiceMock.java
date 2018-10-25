package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dto.UcenterOauthDto;
import com.lzdn.ucenter.service.UcenterOauthService;
import com.lzdn.ucenter.dao.mapper.UcenterOauthMapper;
import com.lzdn.ucenter.dao.model.UcenterOauth;
import com.lzdn.ucenter.dao.model.UcenterOauthExample;

import java.util.List;

/**
* 降级实现UcenterOauthService接口
* Created by shuzheng on 2018/7/19.
*/
public class UcenterOauthServiceMock extends BaseServiceMock<UcenterOauthMapper, UcenterOauth, UcenterOauthExample> implements UcenterOauthService {

    @Override
    public List<UcenterOauthDto> selectUcenterDtoByUserId(int id) {
        return null;
    }
}
