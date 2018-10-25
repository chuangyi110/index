package com.lzdn.ucenter.dto;

public class UcenterOauthDto {
    private Integer userOauthId;
    private Integer userId;
    private Integer oauthId;
    private String oauthName;
    private String openId;
    private Byte status;
    private Long ctime;

    public UcenterOauthDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOauthId() {
        return oauthId;
    }

    public void setOauthId(Integer oauthId) {
        this.oauthId = oauthId;
    }

    public String getOauthName() {
        return oauthName;
    }

    public void setOauthName(String oauthName) {
        this.oauthName = oauthName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Integer getUserOauthId() {
        return userOauthId;
    }

    public void setUserOauthId(Integer userOauthId) {
        this.userOauthId = userOauthId;
    }

    @Override
    public String toString() {
        return "UcenterOauthDto{" +
                "userOauthId=" + userOauthId +
                ", userId=" + userId +
                ", oauthId=" + oauthId +
                ", oauthName='" + oauthName + '\'' +
                ", openId='" + openId + '\'' +
                ", status=" + status +
                ", ctime=" + ctime +
                '}';
    }
}
