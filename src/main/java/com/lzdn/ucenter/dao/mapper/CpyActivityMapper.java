package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyActivity;

import java.util.List;

import com.lzdn.ucenter.dao.model.CpyActivityExample;
import org.apache.ibatis.annotations.Param;

public interface CpyActivityMapper {
    long countByExample(CpyActivityExample example);

    int deleteByExample(CpyActivityExample example);

    int deleteByPrimaryKey(Integer activityId);

    int insert(CpyActivity record);

    int insertSelective(CpyActivity record);

    List<CpyActivity> selectByExample(CpyActivityExample example);

    CpyActivity selectByPrimaryKey(Integer activityId);

    int updateByExampleSelective(@Param("record") CpyActivity record, @Param("example") CpyActivityExample example);

    int updateByExample(@Param("record") CpyActivity record, @Param("example") CpyActivityExample example);

    int updateByPrimaryKeySelective(CpyActivity record);

    int updateByPrimaryKey(CpyActivity record);
}