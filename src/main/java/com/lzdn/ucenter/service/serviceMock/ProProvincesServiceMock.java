package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dao.model.ProProvinces;
import com.lzdn.ucenter.dao.model.ProProvincesExample;
import com.lzdn.ucenter.service.ProProvincesService;
import com.lzdn.ucenter.dao.mapper.ProProvincesMapper;

/**
* 降级实现ProProvincesService接口
* Created by shuzheng on 2018/7/19.
*/
public class ProProvincesServiceMock extends BaseServiceMock<ProProvincesMapper, ProProvinces, ProProvincesExample> implements ProProvincesService {

}
