package com.lzdn.ucenter.dao.mapper.api;

import com.lzdn.ucenter.ao.UcenterTableAo;
import com.lzdn.ucenter.dao.model.UcenterOauth;
import com.lzdn.ucenter.dto.UcenterOauthDto;
import com.lzdn.ucenter.dto.UcenterUserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UcenterUserApiMapper {
    //查询所有学生信息
    List<UcenterUserDto> selectFullMessageForOffsetPage(@Param("ucenterTableAo") UcenterTableAo ucenterTableAo, @Param("ucenterOauths") String ucenterOauths);
}
