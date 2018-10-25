package com.lzdn.ucenter.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.common.db.DataSourceEnum;
import com.lzdn.common.db.DynamicDataSource;
import com.lzdn.ucenter.dao.mapper.api.CpyActivityApiMapper;
import com.lzdn.ucenter.dao.model.CpyActivityExample;
import com.lzdn.ucenter.service.CpyActivityService;
import com.lzdn.ucenter.dao.mapper.CpyActivityMapper;
import com.lzdn.ucenter.dao.model.CpyActivity;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CpyActivityService实现
* Created by shuzheng on 2018/7/5.
*/
@Service
@Transactional
@BaseService
public class CpyActivityServiceImpl extends BaseServiceImpl<CpyActivityMapper, CpyActivity, CpyActivityExample> implements CpyActivityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpyActivityServiceImpl.class);

    @Autowired
    CpyActivityMapper cpyActivityMapper;
    @Autowired
    CpyActivityApiMapper cpyActivityApiMapper;

    @Override
    public int changeStatusById(int id) {
        DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
        int count = cpyActivityApiMapper.changeStatusById(id);
        return 0;
    }
}