package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.CpyCompanytypeCompanyService;
import com.lzdn.ucenter.dao.mapper.CpyCompanytypeCompanyMapper;
import com.lzdn.ucenter.dao.model.CpyCompanytypeCompany;
import com.lzdn.ucenter.dao.model.CpyCompanytypeCompanyExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpyCompanytypeCompanyService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class CpyCompanytypeCompanyServiceImpl extends BaseServiceImpl<CpyCompanytypeCompanyMapper, CpyCompanytypeCompany, CpyCompanytypeCompanyExample> implements CpyCompanytypeCompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyCompanytypeCompanyServiceImpl.class);

    @Autowired
    CpyCompanytypeCompanyMapper cpyCompanytypeCompanyMapper;

}