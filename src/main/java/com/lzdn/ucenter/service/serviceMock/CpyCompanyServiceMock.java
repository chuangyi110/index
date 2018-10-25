package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dao.model.CpyCompany;
import com.lzdn.ucenter.dao.model.CpyCompanyExample;
import com.lzdn.ucenter.service.CpyCompanyService;
import com.lzdn.ucenter.dao.mapper.CpyCompanyMapper;

/**
* 降级实现CpyCompanyService接口
* Created by shuzheng on 2018/7/5.
*/
public class CpyCompanyServiceMock extends BaseServiceMock<CpyCompanyMapper, CpyCompany, CpyCompanyExample> implements CpyCompanyService {

}
