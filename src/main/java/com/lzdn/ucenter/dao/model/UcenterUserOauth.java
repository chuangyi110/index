package com.lzdn.ucenter.dao.model;

import java.io.Serializable;
import java.util.Arrays;

public class UcenterUserOauth implements Serializable {
    private Integer userOauthId;

    /**
     * 账号id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 认证方式id
     *
     * @mbg.generated
     */
    private Integer oauthId;

    /**
     * 绑定状态（0解绑/1绑定）
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Long ctime;

    /**
     * 第三方id
     *
     * @mbg.generated
     */
    private byte[] openId;

    private static final long serialVersionUID = 1L;

    public Integer getUserOauthId() {
        return userOauthId;
    }

    public void setUserOauthId(Integer userOauthId) {
        this.userOauthId = userOauthId;
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

    public byte[] getOpenId() {
        return openId;
    }

    public void setOpenId(byte[] openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userOauthId=").append(userOauthId);
        sb.append(", userId=").append(userId);
        sb.append(", oauthId=").append(oauthId);
        sb.append(", status=").append(status);
        sb.append(", ctime=").append(ctime);
        sb.append(", openId=").append(openId);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UcenterUserOauth other = (UcenterUserOauth) that;
        return (this.getUserOauthId() == null ? other.getUserOauthId() == null : this.getUserOauthId().equals(other.getUserOauthId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOauthId() == null ? other.getOauthId() == null : this.getOauthId().equals(other.getOauthId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (Arrays.equals(this.getOpenId(), other.getOpenId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserOauthId() == null) ? 0 : getUserOauthId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOauthId() == null) ? 0 : getOauthId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + (Arrays.hashCode(getOpenId()));
        return result;
    }
}