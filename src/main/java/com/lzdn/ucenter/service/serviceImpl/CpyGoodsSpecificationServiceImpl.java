package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.CpyGoodsSpecificationService;
import com.lzdn.ucenter.dao.mapper.CpyGoodsSpecificationMapper;
import com.lzdn.ucenter.dao.model.CpyGoodsSpecification;
import com.lzdn.ucenter.dao.model.CpyGoodsSpecificationExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpyGoodsSpecificationService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpyGoodsSpecificationServiceImpl extends BaseServiceImpl<CpyGoodsSpecificationMapper, CpyGoodsSpecification, CpyGoodsSpecificationExample> implements CpyGoodsSpecificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyGoodsSpecificationServiceImpl.class);

    @Autowired
    CpyGoodsSpecificationMapper cpyGoodsSpecificationMapper;

}