package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.CpyActivityTypeService;
import com.lzdn.ucenter.dao.mapper.CpyActivityTypeMapper;
import com.lzdn.ucenter.dao.model.CpyActivityType;
import com.lzdn.ucenter.dao.model.CpyActivityTypeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpyActivityTypeService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpyActivityTypeServiceImpl extends BaseServiceImpl<CpyActivityTypeMapper, CpyActivityType, CpyActivityTypeExample> implements CpyActivityTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyActivityTypeServiceImpl.class);

    @Autowired
    CpyActivityTypeMapper cpyActivityTypeMapper;

}