package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyGoods;
import com.lzdn.ucenter.dao.model.CpyGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpyGoodsMapper {
    long countByExample(CpyGoodsExample example);

    int deleteByExample(CpyGoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(CpyGoods record);

    int insertSelective(CpyGoods record);

    List<CpyGoods> selectByExample(CpyGoodsExample example);

    CpyGoods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") CpyGoods record, @Param("example") CpyGoodsExample example);

    int updateByExample(@Param("record") CpyGoods record, @Param("example") CpyGoodsExample example);

    int updateByPrimaryKeySelective(CpyGoods record);

    int updateByPrimaryKey(CpyGoods record);
}