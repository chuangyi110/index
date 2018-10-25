package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.dao.mapper.ProZipcodeMapper;
import com.lzdn.ucenter.dao.model.ProZipcode;
import com.lzdn.ucenter.dao.model.ProZipcodeExample;
import com.lzdn.ucenter.service.ProZipcodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ProZipcodeService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class ProZipcodeServiceImpl extends BaseServiceImpl<ProZipcodeMapper, ProZipcode, ProZipcodeExample> implements ProZipcodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProZipcodeServiceImpl.class);

    @Autowired
    ProZipcodeMapper proZipcodeMapper;

}