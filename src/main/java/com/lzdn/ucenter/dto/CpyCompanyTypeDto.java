package com.lzdn.ucenter.dto;

import java.util.List;

public class CpyCompanyTypeDto {

    private Integer id;
    private Integer pid;
    private String typeName;
    private List<CpyCompanyTypeDto> cpyCompanyTypeDtoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List <CpyCompanyTypeDto> getCpyCompanyTypeDtoList() {
        return cpyCompanyTypeDtoList;
    }

    public void setCpyCompanyTypeDtoList(List <CpyCompanyTypeDto> cpyCompanyTypeDtoList) {
        this.cpyCompanyTypeDtoList = cpyCompanyTypeDtoList;
    }

    @Override
    public String toString() {
        return "CpyCompanyTypeDto{" +
                "id=" + id +
                ", pid=" + pid +
                ", typeName='" + typeName + '\'' +
                ", cpyCompanyTypeDtoList=" + cpyCompanyTypeDtoList +
                '}';
    }
}
