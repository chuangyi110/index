package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyCompanyType;
import com.lzdn.ucenter.dao.model.CpyCompanyTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpyCompanyTypeMapper {
    long countByExample(CpyCompanyTypeExample example);

    int deleteByExample(CpyCompanyTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CpyCompanyType record);

    int insertSelective(CpyCompanyType record);

    List<CpyCompanyType> selectByExample(CpyCompanyTypeExample example);

    CpyCompanyType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CpyCompanyType record, @Param("example") CpyCompanyTypeExample example);

    int updateByExample(@Param("record") CpyCompanyType record, @Param("example") CpyCompanyTypeExample example);

    int updateByPrimaryKeySelective(CpyCompanyType record);

    int updateByPrimaryKey(CpyCompanyType record);
}