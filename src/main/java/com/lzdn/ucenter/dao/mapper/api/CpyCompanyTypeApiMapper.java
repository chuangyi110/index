package com.lzdn.ucenter.dao.mapper.api;

import com.lzdn.ucenter.dao.model.CpyCompanyType;
import com.lzdn.ucenter.dto.CpyCompanyTypeDto;

import java.util.List;

public interface CpyCompanyTypeApiMapper {
    //获取类型及其所有父类型信息
    public List<CpyCompanyType> getParentList(int id);

    List<CpyCompanyTypeDto> getTree(int pid);
}
