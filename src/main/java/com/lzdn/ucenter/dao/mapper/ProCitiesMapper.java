package com.lzdn.ucenter.dao.mapper;

import java.util.List;

import com.lzdn.ucenter.dao.model.ProCities;
import com.lzdn.ucenter.dao.model.ProCitiesExample;
import org.apache.ibatis.annotations.Param;

public interface ProCitiesMapper {
    long countByExample(ProCitiesExample example);

    int deleteByExample(ProCitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProCities record);

    int insertSelective(ProCities record);

    List<ProCities> selectByExample(ProCitiesExample example);

    ProCities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProCities record, @Param("example") ProCitiesExample example);

    int updateByExample(@Param("record") ProCities record, @Param("example") ProCitiesExample example);

    int updateByPrimaryKeySelective(ProCities record);

    int updateByPrimaryKey(ProCities record);
}