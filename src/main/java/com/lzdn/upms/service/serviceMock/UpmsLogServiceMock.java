package com.lzdn.upms.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.upms.service.UpmsLogService;
import com.lzdn.upms.dao.mapper.UpmsLogMapper;
import com.lzdn.upms.dao.model.UpmsLog;
import com.lzdn.upms.dao.model.UpmsLogExample;

/**
* 降级实现UpmsLogService接口
* Created by shuzheng on 2018/7/11.
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
