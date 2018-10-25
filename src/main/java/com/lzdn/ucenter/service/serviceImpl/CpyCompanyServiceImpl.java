package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.dao.model.CpyCompany;
import com.lzdn.ucenter.dao.model.CpyCompanyExample;
import com.lzdn.ucenter.service.CpyCompanyService;
import com.lzdn.ucenter.dao.mapper.CpyCompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpyCompanyService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpyCompanyServiceImpl extends BaseServiceImpl<CpyCompanyMapper, CpyCompany, CpyCompanyExample> implements CpyCompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyCompanyServiceImpl.class);

    @Autowired
    CpyCompanyMapper cpyCompanyMapper;

}