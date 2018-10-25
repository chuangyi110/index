package com.lzdn.upms.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.upms.service.UpmsUserService;
import com.lzdn.upms.dao.mapper.UpmsUserMapper;
import com.lzdn.upms.dao.model.UpmsUser;
import com.lzdn.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by shuzheng on 2018/7/11.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

}
