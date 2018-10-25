package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.service.UcenterUserCompanyService;
import com.lzdn.ucenter.dao.mapper.UcenterUserCompanyMapper;
import com.lzdn.ucenter.dao.model.UcenterUserCompany;
import com.lzdn.ucenter.dao.model.UcenterUserCompanyExample;

/**
* 降级实现UcenterUserCompanyService接口
* Created by shuzheng on 2018/7/19.
*/
public class UcenterUserCompanyServiceMock extends BaseServiceMock<UcenterUserCompanyMapper, UcenterUserCompany, UcenterUserCompanyExample> implements UcenterUserCompanyService {

}
