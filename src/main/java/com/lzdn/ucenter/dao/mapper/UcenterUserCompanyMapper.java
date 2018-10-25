package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.UcenterUserCompany;
import com.lzdn.ucenter.dao.model.UcenterUserCompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UcenterUserCompanyMapper {
    long countByExample(UcenterUserCompanyExample example);

    int deleteByExample(UcenterUserCompanyExample example);

    int deleteByPrimaryKey(Integer userCompanyId);

    int insert(UcenterUserCompany record);

    int insertSelective(UcenterUserCompany record);

    List<UcenterUserCompany> selectByExample(UcenterUserCompanyExample example);

    UcenterUserCompany selectByPrimaryKey(Integer userCompanyId);

    int updateByExampleSelective(@Param("record") UcenterUserCompany record, @Param("example") UcenterUserCompanyExample example);

    int updateByExample(@Param("record") UcenterUserCompany record, @Param("example") UcenterUserCompanyExample example);

    int updateByPrimaryKeySelective(UcenterUserCompany record);

    int updateByPrimaryKey(UcenterUserCompany record);
}