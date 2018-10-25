package com.lzdn.ucenter.dao.mapper;

import java.util.List;

import com.lzdn.ucenter.dao.model.ProZipcode;
import com.lzdn.ucenter.dao.model.ProZipcodeExample;
import org.apache.ibatis.annotations.Param;

public interface ProZipcodeMapper {
    long countByExample(ProZipcodeExample example);

    int deleteByExample(ProZipcodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProZipcode record);

    int insertSelective(ProZipcode record);

    List<ProZipcode> selectByExample(ProZipcodeExample example);

    ProZipcode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProZipcode record, @Param("example") ProZipcodeExample example);

    int updateByExample(@Param("record") ProZipcode record, @Param("example") ProZipcodeExample example);

    int updateByPrimaryKeySelective(ProZipcode record);

    int updateByPrimaryKey(ProZipcode record);
}