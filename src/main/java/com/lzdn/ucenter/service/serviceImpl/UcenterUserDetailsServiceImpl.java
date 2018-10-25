package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.service.UcenterUserDetailsService;
import com.lzdn.ucenter.dao.mapper.UcenterUserDetailsMapper;
import com.lzdn.ucenter.dao.model.UcenterUserDetails;
import com.lzdn.ucenter.dao.model.UcenterUserDetailsExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserDetailsService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class UcenterUserDetailsServiceImpl extends BaseServiceImpl<UcenterUserDetailsMapper, UcenterUserDetails, UcenterUserDetailsExample> implements UcenterUserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UcenterUserDetailsServiceImpl.class);

    @Autowired
    UcenterUserDetailsMapper ucenterUserDetailsMapper;

}