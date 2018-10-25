package com.lzdn.ucenter.dao.mapper;

import java.util.List;

import com.lzdn.ucenter.dao.model.ProProvinces;
import com.lzdn.ucenter.dao.model.ProProvincesExample;
import org.apache.ibatis.annotations.Param;

public interface ProProvincesMapper {
    long countByExample(ProProvincesExample example);

    int deleteByExample(ProProvincesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProProvinces record);

    int insertSelective(ProProvinces record);

    List<ProProvinces> selectByExample(ProProvincesExample example);

    ProProvinces selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProProvinces record, @Param("example") ProProvincesExample example);

    int updateByExample(@Param("record") ProProvinces record, @Param("example") ProProvincesExample example);

    int updateByPrimaryKeySelective(ProProvinces record);

    int updateByPrimaryKey(ProProvinces record);
}