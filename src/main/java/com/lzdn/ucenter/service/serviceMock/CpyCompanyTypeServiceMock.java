package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dto.CpyCompanyTypeDto;
import com.lzdn.ucenter.service.CpyCompanyTypeService;
import com.lzdn.ucenter.dao.mapper.CpyCompanyTypeMapper;
import com.lzdn.ucenter.dao.model.CpyCompanyType;
import com.lzdn.ucenter.dao.model.CpyCompanyTypeExample;

import java.util.List;

/**
* 降级实现CpyCompanyTypeService接口
* Created by shuzheng on 2018/7/5.
*/
public class CpyCompanyTypeServiceMock extends BaseServiceMock<CpyCompanyTypeMapper, CpyCompanyType, CpyCompanyTypeExample> implements CpyCompanyTypeService {

    @Override
    public List<CpyCompanyType> getParentList(int id) {
        return null;
    }

    @Override
    public List <CpyCompanyTypeDto> getTree(int id) {
        return null;
    }
}
