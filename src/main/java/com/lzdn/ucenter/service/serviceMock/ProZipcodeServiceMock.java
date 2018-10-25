package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dao.model.ProZipcode;
import com.lzdn.ucenter.dao.model.ProZipcodeExample;
import com.lzdn.ucenter.service.ProZipcodeService;
import com.lzdn.ucenter.dao.mapper.ProZipcodeMapper;

/**
* 降级实现ProZipcodeService接口
* Created by shuzheng on 2018/7/19.
*/
public class ProZipcodeServiceMock extends BaseServiceMock<ProZipcodeMapper, ProZipcode, ProZipcodeExample> implements ProZipcodeService {

}
