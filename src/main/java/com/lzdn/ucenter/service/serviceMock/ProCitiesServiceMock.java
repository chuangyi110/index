package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dao.model.ProCities;
import com.lzdn.ucenter.dao.model.ProCitiesExample;
import com.lzdn.ucenter.service.ProCitiesService;
import com.lzdn.ucenter.dao.mapper.ProCitiesMapper;

/**
* 降级实现ProCitiesService接口
* Created by shuzheng on 2018/7/19.
*/
public class ProCitiesServiceMock extends BaseServiceMock<ProCitiesMapper, ProCities, ProCitiesExample> implements ProCitiesService {

}
