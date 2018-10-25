package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyCompanytypeCompany;
import com.lzdn.ucenter.dao.model.CpyCompanytypeCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpyCompanytypeCompanyMapper {
    long countByExample(CpyCompanytypeCompanyExample example);

    int deleteByExample(CpyCompanytypeCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CpyCompanytypeCompany record);

    int insertSelective(CpyCompanytypeCompany record);

    List<CpyCompanytypeCompany> selectByExample(CpyCompanytypeCompanyExample example);

    CpyCompanytypeCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CpyCompanytypeCompany record, @Param("example") CpyCompanytypeCompanyExample example);

    int updateByExample(@Param("record") CpyCompanytypeCompany record, @Param("example") CpyCompanytypeCompanyExample example);

    int updateByPrimaryKeySelective(CpyCompanytypeCompany record);

    int updateByPrimaryKey(CpyCompanytypeCompany record);
}