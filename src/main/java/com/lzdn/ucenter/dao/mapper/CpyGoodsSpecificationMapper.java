package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyGoodsSpecification;
import com.lzdn.ucenter.dao.model.CpyGoodsSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpyGoodsSpecificationMapper {
    long countByExample(CpyGoodsSpecificationExample example);

    int deleteByExample(CpyGoodsSpecificationExample example);

    int deleteByPrimaryKey(Integer goodsSpecificationId);

    int insert(CpyGoodsSpecification record);

    int insertSelective(CpyGoodsSpecification record);

    List<CpyGoodsSpecification> selectByExample(CpyGoodsSpecificationExample example);

    CpyGoodsSpecification selectByPrimaryKey(Integer goodsSpecificationId);

    int updateByExampleSelective(@Param("record") CpyGoodsSpecification record, @Param("example") CpyGoodsSpecificationExample example);

    int updateByExample(@Param("record") CpyGoodsSpecification record, @Param("example") CpyGoodsSpecificationExample example);

    int updateByPrimaryKeySelective(CpyGoodsSpecification record);

    int updateByPrimaryKey(CpyGoodsSpecification record);
}