package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.UcenterUserCompanyService;
import com.lzdn.ucenter.dao.mapper.UcenterUserCompanyMapper;
import com.lzdn.ucenter.dao.model.UcenterUserCompany;
import com.lzdn.ucenter.dao.model.UcenterUserCompanyExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserCompanyService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class UcenterUserCompanyServiceImpl extends BaseServiceImpl<UcenterUserCompanyMapper, UcenterUserCompany, UcenterUserCompanyExample> implements UcenterUserCompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UcenterUserCompanyServiceImpl.class);

    @Autowired
    UcenterUserCompanyMapper ucenterUserCompanyMapper;

}