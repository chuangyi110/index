package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.CpyGoodsService;
import com.lzdn.ucenter.dao.mapper.CpyGoodsMapper;
import com.lzdn.ucenter.dao.model.CpyGoods;
import com.lzdn.ucenter.dao.model.CpyGoodsExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpyGoodsService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpyGoodsServiceImpl extends BaseServiceImpl<CpyGoodsMapper, CpyGoods, CpyGoodsExample> implements CpyGoodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyGoodsServiceImpl.class);

    @Autowired
    CpyGoodsMapper cpyGoodsMapper;

}