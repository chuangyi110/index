package com.lzdn.ucenter.dao.mapper;

import com.lzdn.ucenter.dao.model.CpyActivityType;
import com.lzdn.ucenter.dao.model.CpyActivityTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpyActivityTypeMapper {
    long countByExample(CpyActivityTypeExample example);

    int deleteByExample(CpyActivityTypeExample example);

    int deleteByPrimaryKey(Integer activityTypeId);

    int insert(CpyActivityType record);

    int insertSelective(CpyActivityType record);

    List<CpyActivityType> selectByExample(CpyActivityTypeExample example);

    CpyActivityType selectByPrimaryKey(Integer activityTypeId);

    int updateByExampleSelective(@Param("record") CpyActivityType record, @Param("example") CpyActivityTypeExample example);

    int updateByExample(@Param("record") CpyActivityType record, @Param("example") CpyActivityTypeExample example);

    int updateByPrimaryKeySelective(CpyActivityType record);

    int updateByPrimaryKey(CpyActivityType record);
}