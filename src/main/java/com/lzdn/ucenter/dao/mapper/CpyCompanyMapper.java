package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyCompany;
import com.lzdn.ucenter.dao.model.CpyCompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpyCompanyMapper {
    long countByExample(CpyCompanyExample example);

    int deleteByExample(CpyCompanyExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(CpyCompany record);

    int insertSelective(CpyCompany record);

    List<CpyCompany> selectByExample(CpyCompanyExample example);

    CpyCompany selectByPrimaryKey(Integer companyId);

    int updateByExampleSelective(@Param("record") CpyCompany record, @Param("example") CpyCompanyExample example);

    int updateByExample(@Param("record") CpyCompany record, @Param("example") CpyCompanyExample example);

    int updateByPrimaryKeySelective(CpyCompany record);

    int updateByPrimaryKey(CpyCompany record);
}