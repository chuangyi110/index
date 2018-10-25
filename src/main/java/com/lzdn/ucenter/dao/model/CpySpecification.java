package com.lzdn.ucenter.dao.model;

import java.io.Serializable;

public class CpySpecification implements Serializable {
    private Integer specificationId;

    /**
     * 所属公司id
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     * 规格类型（总类型）
     *
     * @mbg.generated
     */
    private String specificationTypes;

    /**
     * 类型id 当为总类型时该字段为0
     *
     * @mbg.generated
     */
    private Integer pid;

    /**
     * 规格种类
     *
     * @mbg.generated
     */
    private String specificationType;

    private static final long serialVersionUID = 1L;

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getSpecificationTypes() {
        return specificationTypes;
    }

    public void setSpecificationTypes(String specificationTypes) {
        this.specificationTypes = specificationTypes;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSpecificationType() {
        return specificationType;
    }

    public void setSpecificationType(String specificationType) {
        this.specificationType = specificationType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", specificationId=").append(specificationId);
        sb.append(", companyId=").append(companyId);
        sb.append(", specificationTypes=").append(specificationTypes);
        sb.append(", pid=").append(pid);
        sb.append(", specificationType=").append(specificationType);
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
        CpySpecification other = (CpySpecification) that;
        return (this.getSpecificationId() == null ? other.getSpecificationId() == null : this.getSpecificationId().equals(other.getSpecificationId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getSpecificationTypes() == null ? other.getSpecificationTypes() == null : this.getSpecificationTypes().equals(other.getSpecificationTypes()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getSpecificationType() == null ? other.getSpecificationType() == null : this.getSpecificationType().equals(other.getSpecificationType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecificationId() == null) ? 0 : getSpecificationId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getSpecificationTypes() == null) ? 0 : getSpecificationTypes().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getSpecificationType() == null) ? 0 : getSpecificationType().hashCode());
        return result;
    }
}