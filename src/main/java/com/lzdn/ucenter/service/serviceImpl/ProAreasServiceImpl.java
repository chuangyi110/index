package com.lzdn.ucenter.service.serviceImpl;


import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.dao.mapper.ProAreasMapper;
import com.lzdn.ucenter.dao.model.ProAreas;
import com.lzdn.ucenter.dao.model.ProAreasExample;
import com.lzdn.ucenter.service.ProAreasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ProAreasService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class ProAreasServiceImpl extends BaseServiceImpl<ProAreasMapper, ProAreas, ProAreasExample> implements ProAreasService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProAreasServiceImpl.class);

    @Autowired
    ProAreasMapper proAreasMapper;

}