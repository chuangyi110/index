package com.lzdn.upms.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.upms.service.UpmsSystemService;
import com.lzdn.upms.dao.mapper.UpmsSystemMapper;
import com.lzdn.upms.dao.model.UpmsSystem;
import com.lzdn.upms.dao.model.UpmsSystemExample;

/**
* 降级实现UpmsSystemService接口
* Created by shuzheng on 2018/7/11.
*/
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

}
