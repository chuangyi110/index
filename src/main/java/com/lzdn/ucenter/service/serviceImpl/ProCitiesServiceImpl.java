package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.dao.mapper.ProCitiesMapper;
import com.lzdn.ucenter.dao.model.ProCities;
import com.lzdn.ucenter.dao.model.ProCitiesExample;
import com.lzdn.ucenter.service.ProCitiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ProCitiesService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class ProCitiesServiceImpl extends BaseServiceImpl<ProCitiesMapper, ProCities, ProCitiesExample> implements ProCitiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProCitiesServiceImpl.class);

    @Autowired
    ProCitiesMapper proCitiesMapper;

}