package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.service.UcenterUserOauthService;
import com.lzdn.ucenter.dao.mapper.UcenterUserOauthMapper;
import com.lzdn.ucenter.dao.model.UcenterUserOauth;
import com.lzdn.ucenter.dao.model.UcenterUserOauthExample;

/**
* 降级实现UcenterUserOauthService接口
* Created by shuzheng on 2018/7/19.
*/
public class UcenterUserOauthServiceMock extends BaseServiceMock<UcenterUserOauthMapper, UcenterUserOauth, UcenterUserOauthExample> implements UcenterUserOauthService {

    @Override
    public int updateStatusByPrimaryKey(String ids) {
        return 0;
    }
}
