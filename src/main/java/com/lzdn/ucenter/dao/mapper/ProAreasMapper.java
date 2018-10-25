package com.lzdn.ucenter.dao.mapper;

import java.util.List;

import com.lzdn.ucenter.dao.model.ProAreas;
import com.lzdn.ucenter.dao.model.ProAreasExample;
import org.apache.ibatis.annotations.Param;

public interface ProAreasMapper {
    long countByExample(ProAreasExample example);

    int deleteByExample(ProAreasExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProAreas record);

    int insertSelective(ProAreas record);

    List<ProAreas> selectByExample(ProAreasExample example);

    ProAreas selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProAreas record, @Param("example") ProAreasExample example);

    int updateByExample(@Param("record") ProAreas record, @Param("example") ProAreasExample example);

    int updateByPrimaryKeySelective(ProAreas record);

    int updateByPrimaryKey(ProAreas record);
}