package com.lzdn.ucenter.dao.model;

import java.io.Serializable;

public class CpyActivityType implements Serializable {
    /**
     * 促销类型id
     *
     * @mbg.generated
     */
    private Integer activityTypeId;

    /**
     * 活动类别
     *
     * @mbg.generated
     */
    private String activityType;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String activityRemark;

    /**
     * 活动关联列 以“,”（英文逗号分割）
     *
     * @mbg.generated
     */
    private String relationshipFields;

    private static final long serialVersionUID = 1L;

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityRemark() {
        return activityRemark;
    }

    public void setActivityRemark(String activityRemark) {
        this.activityRemark = activityRemark;
    }

    public String getRelationshipFields() {
        return relationshipFields;
    }

    public void setRelationshipFields(String relationshipFields) {
        this.relationshipFields = relationshipFields;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityTypeId=").append(activityTypeId);
        sb.append(", activityType=").append(activityType);
        sb.append(", activityRemark=").append(activityRemark);
        sb.append(", relationshipFields=").append(relationshipFields);
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
        CpyActivityType other = (CpyActivityType) that;
        return (this.getActivityTypeId() == null ? other.getActivityTypeId() == null : this.getActivityTypeId().equals(other.getActivityTypeId()))
            && (this.getActivityType() == null ? other.getActivityType() == null : this.getActivityType().equals(other.getActivityType()))
            && (this.getActivityRemark() == null ? other.getActivityRemark() == null : this.getActivityRemark().equals(other.getActivityRemark()))
            && (this.getRelationshipFields() == null ? other.getRelationshipFields() == null : this.getRelationshipFields().equals(other.getRelationshipFields()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityTypeId() == null) ? 0 : getActivityTypeId().hashCode());
        result = prime * result + ((getActivityType() == null) ? 0 : getActivityType().hashCode());
        result = prime * result + ((getActivityRemark() == null) ? 0 : getActivityRemark().hashCode());
        result = prime * result + ((getRelationshipFields() == null) ? 0 : getRelationshipFields().hashCode());
        return result;
    }
}