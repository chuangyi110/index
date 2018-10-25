package com.lzdn.ucenter.dto;

import com.lzdn.ucenter.dao.model.UcenterOauth;

import java.util.List;
import java.util.Objects;

public class UcenterUserDto {
    private Integer userId;
    private String nickname;
    private Byte sex;
    private String avatar;
    private Long ctime;
    private String cip;
    private String phone;
    private String email;
    private Long lastLoginTime;
    private String lastLoginIp;
    private List<UcenterOauthDto> ucenterOauthDtoList;
    public UcenterUserDto(){
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public List <UcenterOauthDto> getUcenterOauthDtoList() {
        return ucenterOauthDtoList;
    }

    public void setUcenterOauthDtoList(List <UcenterOauthDto> ucenterOauthDtoList) {
        this.ucenterOauthDtoList = ucenterOauthDtoList;
    }

    @Override
    public String toString() {
        return "UcenterUserDto{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", ctime=" + ctime +
                ", cip='" + cip + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", ucenterOauthDtoList=" + ucenterOauthDtoList +
                '}';
    }
}
