package com.lzdn.ucenter.dao.model;

import java.io.Serializable;

public class CpyCompany implements Serializable {
    private Integer companyId;

    /**
     * 公司名称
     *
     * @mbg.generated
     */
    private String companyName;

    /**
     * 公司图标/店铺图片
     *
     * @mbg.generated
     */
    private String companyAvatar;

    /**
     * 公司执照
     *
     * @mbg.generated
     */
    private String companyLicense;

    private Integer contry;

    private Integer provincesId;

    private Integer citiesId;

    private Integer areasId;

    /**
     * 公司状态 0正常/1打烊/2关闭/3封停
     *
     * @mbg.generated
     */
    private Byte companyStatus;

    /**
     * 公司地址
     *
     * @mbg.generated
     */
    private String address;

    /**
     * 联系电话
     *
     * @mbg.generated
     */
    private String tel;

    /**
     * 传真
     *
     * @mbg.generated
     */
    private String fax;

    private String email;

    private static final long serialVersionUID = 1L;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAvatar() {
        return companyAvatar;
    }

    public void setCompanyAvatar(String companyAvatar) {
        this.companyAvatar = companyAvatar;
    }

    public String getCompanyLicense() {
        return companyLicense;
    }

    public void setCompanyLicense(String companyLicense) {
        this.companyLicense = companyLicense;
    }

    public Integer getContry() {
        return contry;
    }

    public void setContry(Integer contry) {
        this.contry = contry;
    }

    public Integer getProvincesId() {
        return provincesId;
    }

    public void setProvincesId(Integer provincesId) {
        this.provincesId = provincesId;
    }

    public Integer getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(Integer citiesId) {
        this.citiesId = citiesId;
    }

    public Integer getAreasId() {
        return areasId;
    }

    public void setAreasId(Integer areasId) {
        this.areasId = areasId;
    }

    public Byte getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(Byte companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyAvatar=").append(companyAvatar);
        sb.append(", companyLicense=").append(companyLicense);
        sb.append(", contry=").append(contry);
        sb.append(", provincesId=").append(provincesId);
        sb.append(", citiesId=").append(citiesId);
        sb.append(", areasId=").append(areasId);
        sb.append(", companyStatus=").append(companyStatus);
        sb.append(", address=").append(address);
        sb.append(", tel=").append(tel);
        sb.append(", fax=").append(fax);
        sb.append(", email=").append(email);
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
        CpyCompany other = (CpyCompany) that;
        return (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyAvatar() == null ? other.getCompanyAvatar() == null : this.getCompanyAvatar().equals(other.getCompanyAvatar()))
            && (this.getCompanyLicense() == null ? other.getCompanyLicense() == null : this.getCompanyLicense().equals(other.getCompanyLicense()))
            && (this.getContry() == null ? other.getContry() == null : this.getContry().equals(other.getContry()))
            && (this.getProvincesId() == null ? other.getProvincesId() == null : this.getProvincesId().equals(other.getProvincesId()))
            && (this.getCitiesId() == null ? other.getCitiesId() == null : this.getCitiesId().equals(other.getCitiesId()))
            && (this.getAreasId() == null ? other.getAreasId() == null : this.getAreasId().equals(other.getAreasId()))
            && (this.getCompanyStatus() == null ? other.getCompanyStatus() == null : this.getCompanyStatus().equals(other.getCompanyStatus()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyAvatar() == null) ? 0 : getCompanyAvatar().hashCode());
        result = prime * result + ((getCompanyLicense() == null) ? 0 : getCompanyLicense().hashCode());
        result = prime * result + ((getContry() == null) ? 0 : getContry().hashCode());
        result = prime * result + ((getProvincesId() == null) ? 0 : getProvincesId().hashCode());
        result = prime * result + ((getCitiesId() == null) ? 0 : getCitiesId().hashCode());
        result = prime * result + ((getAreasId() == null) ? 0 : getAreasId().hashCode());
        result = prime * result + ((getCompanyStatus() == null) ? 0 : getCompanyStatus().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        return result;
    }
}