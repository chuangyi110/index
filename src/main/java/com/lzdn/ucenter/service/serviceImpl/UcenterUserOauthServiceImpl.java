package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.ucenter.dao.mapper.api.UcenterUserOauthApiMapper;
import com.lzdn.ucenter.service.UcenterUserOauthService;
import com.lzdn.ucenter.dao.mapper.UcenterUserOauthMapper;
import com.lzdn.ucenter.dao.model.UcenterUserOauth;
import com.lzdn.ucenter.dao.model.UcenterUserOauthExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserOauthService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class UcenterUserOauthServiceImpl extends BaseServiceImpl<UcenterUserOauthMapper, UcenterUserOauth, UcenterUserOauthExample> implements UcenterUserOauthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UcenterUserOauthServiceImpl.class);

    @Autowired
    UcenterUserOauthMapper ucenterUserOauthMapper;
    @Autowired
    UcenterUserOauthApiMapper ucenterUserOauthApiMapper;

    @Override
    public int updateStatusByPrimaryKey(String ids) {
        String[] array =  ids.split("-");
        int count = ucenterUserOauthApiMapper.updateStatusByPrimaryKey(array);
        return 0;
    }
}