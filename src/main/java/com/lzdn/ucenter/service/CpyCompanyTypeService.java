package com.lzdn.ucenter.service;

import com.lzdn.common.base.BaseService;
import com.lzdn.ucenter.dao.model.CpyCompanyType;
import com.lzdn.ucenter.dao.model.CpyCompanyTypeExample;
import com.lzdn.ucenter.dto.CpyCompanyTypeDto;

import java.util.List;

/**
* CpyCompanyTypeService接口
* Created by realMess on 2018/7/5.
*/
public interface CpyCompanyTypeService extends BaseService<CpyCompanyType, CpyCompanyTypeExample> {
    //获取类型及其父类型
    List<CpyCompanyType> getParentList(int id);
    //Tree形式存入
    List<CpyCompanyTypeDto> getTree(int id);
}