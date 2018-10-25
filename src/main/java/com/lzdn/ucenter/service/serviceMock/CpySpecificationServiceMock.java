package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.service.CpySpecificationService;
import com.lzdn.ucenter.dao.mapper.CpySpecificationMapper;
import com.lzdn.ucenter.dao.model.CpySpecification;
import com.lzdn.ucenter.dao.model.CpySpecificationExample;

/**
* 降级实现CpySpecificationService接口
* Created by shuzheng on 2018/7/5.
*/
public class CpySpecificationServiceMock extends BaseServiceMock<CpySpecificationMapper, CpySpecification, CpySpecificationExample> implements CpySpecificationService {

}
