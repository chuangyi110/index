package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dao.model.ProAreas;
import com.lzdn.ucenter.dao.model.ProAreasExample;
import com.lzdn.ucenter.service.ProAreasService;
import com.lzdn.ucenter.dao.mapper.ProAreasMapper;

/**
* 降级实现ProAreasService接口
* Created by shuzheng on 2018/7/19.
*/
public class ProAreasServiceMock extends BaseServiceMock<ProAreasMapper, ProAreas, ProAreasExample> implements ProAreasService {

}
