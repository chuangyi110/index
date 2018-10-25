package com.lzdn.upms.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.upms.service.UpmsOrganizationService;
import com.lzdn.upms.dao.mapper.UpmsOrganizationMapper;
import com.lzdn.upms.dao.model.UpmsOrganization;
import com.lzdn.upms.dao.model.UpmsOrganizationExample;

/**
* 降级实现UpmsOrganizationService接口
* Created by shuzheng on 2018/7/11.
*/
public class UpmsOrganizationServiceMock extends BaseServiceMock<UpmsOrganizationMapper, UpmsOrganization, UpmsOrganizationExample> implements UpmsOrganizationService {

}
