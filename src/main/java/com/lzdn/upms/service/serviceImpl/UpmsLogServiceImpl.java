package com.lzdn.upms.service.serviceImpl;

import com.lzdn.common.annotation.BaseService;
import com.lzdn.common.base.BaseServiceImpl;
import com.lzdn.upms.service.UpmsLogService;
import com.lzdn.upms.dao.mapper.UpmsLogMapper;
import com.lzdn.upms.dao.model.UpmsLog;
import com.lzdn.upms.dao.model.UpmsLogExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsLogService实现
* Created by shuzheng on 2018/7/11.
*/
@Service
@Transactional
@BaseService
public class UpmsLogServiceImpl extends BaseServiceImpl<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsLogServiceImpl.class);

    @Autowired
    UpmsLogMapper upmsLogMapper;

}