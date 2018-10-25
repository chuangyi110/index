package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyGoodsType;
import com.lzdn.ucenter.dao.model.CpyGoodsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpyGoodsTypeMapper {
    long countByExample(CpyGoodsTypeExample example);

    int deleteByExample(CpyGoodsTypeExample example);

    int deleteByPrimaryKey(Integer goodsTypeId);

    int insert(CpyGoodsType record);

    int insertSelective(CpyGoodsType record);

    List<CpyGoodsType> selectByExample(CpyGoodsTypeExample example);

    CpyGoodsType selectByPrimaryKey(Integer goodsTypeId);

    int updateByExampleSelective(@Param("record") CpyGoodsType record, @Param("example") CpyGoodsTypeExample example);

    int updateByExample(@Param("record") CpyGoodsType record, @Param("example") CpyGoodsTypeExample example);

    int updateByPrimaryKeySelective(CpyGoodsType record);

    int updateByPrimaryKey(CpyGoodsType record);
}