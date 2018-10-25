package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.common.db.DataSourceEnum;
import com.lzdn.common.db.DynamicDataSource;
import com.lzdn.ucenter.dao.mapper.api.UcenterOauthApiMapper;
import com.lzdn.ucenter.dao.mapper.api.UcenterUserApiMapper;
import com.lzdn.ucenter.dto.UcenterOauthDto;
import com.lzdn.ucenter.service.UcenterOauthService;
import com.lzdn.ucenter.dao.mapper.UcenterOauthMapper;
import com.lzdn.ucenter.dao.model.UcenterOauth;
import com.lzdn.ucenter.dao.model.UcenterOauthExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* UcenterOauthService实现
* Created by shuzheng on 2018/7/19.
*/
@Service
@Transactional
@BaseService
public class UcenterOauthServiceImpl extends BaseServiceImpl<UcenterOauthMapper, UcenterOauth, UcenterOauthExample> implements UcenterOauthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UcenterOauthServiceImpl.class);

    @Autowired
    UcenterOauthMapper ucenterOauthMapper;
    @Autowired
    UcenterOauthApiMapper ucenterOauthApiMapper;
    @Autowired
    UcenterUserApiMapper ucenterUserApiMapper;
    @Override
    public List<UcenterOauthDto> selectUcenterDtoByUserId(int id) {
        DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
        List<UcenterOauthDto> ucenterOauthDtos = ucenterOauthApiMapper.selectOauthByUserId(id);
        return ucenterOauthDtos;
    }
}