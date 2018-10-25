package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpySpecification;
import com.lzdn.ucenter.dao.model.CpySpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpySpecificationMapper {
    long countByExample(CpySpecificationExample example);

    int deleteByExample(CpySpecificationExample example);

    int deleteByPrimaryKey(Integer specificationId);

    int insert(CpySpecification record);

    int insertSelective(CpySpecification record);

    List<CpySpecification> selectByExample(CpySpecificationExample example);

    CpySpecification selectByPrimaryKey(Integer specificationId);

    int updateByExampleSelective(@Param("record") CpySpecification record, @Param("example") CpySpecificationExample example);

    int updateByExample(@Param("record") CpySpecification record, @Param("example") CpySpecificationExample example);

    int updateByPrimaryKeySelective(CpySpecification record);

    int updateByPrimaryKey(CpySpecification record);
}