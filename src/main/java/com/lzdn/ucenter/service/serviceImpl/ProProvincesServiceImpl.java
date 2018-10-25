package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.dao.mapper.ProProvincesMapper;
import com.lzdn.ucenter.dao.model.ProProvinces;
import com.lzdn.ucenter.dao.model.ProProvincesExample;
import com.lzdn.ucenter.service.ProProvincesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ProProvincesService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class ProProvincesServiceImpl extends BaseServiceImpl<ProProvincesMapper, ProProvinces, ProProvincesExample> implements ProProvincesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProProvincesServiceImpl.class);

    @Autowired
    ProProvincesMapper proProvincesMapper;

}