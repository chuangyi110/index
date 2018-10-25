package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.CpyGoodsTypeService;
import com.lzdn.ucenter.dao.mapper.CpyGoodsTypeMapper;
import com.lzdn.ucenter.dao.model.CpyGoodsType;
import com.lzdn.ucenter.dao.model.CpyGoodsTypeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpyGoodsTypeService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpyGoodsTypeServiceImpl extends BaseServiceImpl<CpyGoodsTypeMapper, CpyGoodsType, CpyGoodsTypeExample> implements CpyGoodsTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyGoodsTypeServiceImpl.class);

    @Autowired
    CpyGoodsTypeMapper cpyGoodsTypeMapper;

}