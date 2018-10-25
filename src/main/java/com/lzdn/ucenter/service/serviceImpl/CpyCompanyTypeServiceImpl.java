package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.dao.mapper.api.CpyCompanyTypeApiMapper;
import com.lzdn.ucenter.dto.CpyCompanyTypeDto;
import com.lzdn.ucenter.service.CpyCompanyTypeService;
import com.lzdn.ucenter.dao.mapper.CpyCompanyTypeMapper;
import com.lzdn.ucenter.dao.model.CpyCompanyType;
import com.lzdn.ucenter.dao.model.CpyCompanyTypeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* CpyCompanyTypeService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpyCompanyTypeServiceImpl extends BaseServiceImpl<CpyCompanyTypeMapper, CpyCompanyType, CpyCompanyTypeExample> implements CpyCompanyTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyCompanyTypeServiceImpl.class);

    @Autowired
    CpyCompanyTypeMapper cpyCompanyTypeMapper;
    @Autowired
    CpyCompanyTypeApiMapper cpyCompanyTypeApiMapper;
    @Override
    public List<CpyCompanyType> getParentList(int id) {
        return cpyCompanyTypeApiMapper.getParentList(id);
    }

    @Override
    public List <CpyCompanyTypeDto> getTree(int id) {
         List<CpyCompanyTypeDto> cpyCompanyTypeDtoList = cpyCompanyTypeApiMapper.getTree(0);
         return cpyCompanyTypeDtoList;
    }
}