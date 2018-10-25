package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.CpySpecificationService;
import com.lzdn.ucenter.dao.mapper.CpySpecificationMapper;
import com.lzdn.ucenter.dao.model.CpySpecification;
import com.lzdn.ucenter.dao.model.CpySpecificationExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpySpecificationService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpySpecificationServiceImpl extends BaseServiceImpl<CpySpecificationMapper, CpySpecification, CpySpecificationExample> implements CpySpecificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpySpecificationServiceImpl.class);

    @Autowired
    CpySpecificationMapper cpySpecificationMapper;

}