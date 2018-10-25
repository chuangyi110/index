package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.ao.UcenterTableAo;
import com.lzdn.ucenter.dto.UcenterUserDto;
import com.lzdn.ucenter.service.UcenterUserService;
import com.lzdn.ucenter.dao.mapper.UcenterUserMapper;
import com.lzdn.ucenter.dao.model.UcenterUser;
import com.lzdn.ucenter.dao.model.UcenterUserExample;

import java.util.List;

/**
* 降级实现UcenterUserService接口
* Created by shuzheng on 2018/7/19.
*/
public class UcenterUserServiceMock extends BaseServiceMock<UcenterUserMapper, UcenterUser, UcenterUserExample> implements UcenterUserService {

    @Override
    public List<UcenterUserDto> selectFullMessageForOffsetPage(UcenterTableAo ucenterTableAo, String ucenterOauths) {
        return null;
    }
}
