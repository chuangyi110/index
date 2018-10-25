package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.service.UcenterUserDetailsService;
import com.lzdn.ucenter.dao.mapper.UcenterUserDetailsMapper;
import com.lzdn.ucenter.dao.model.UcenterUserDetails;
import com.lzdn.ucenter.dao.model.UcenterUserDetailsExample;

/**
* 降级实现UcenterUserDetailsService接口
* Created by shuzheng on 2018/7/19.
*/
public class UcenterUserDetailsServiceMock extends BaseServiceMock<UcenterUserDetailsMapper, UcenterUserDetails, UcenterUserDetailsExample> implements UcenterUserDetailsService {

}
