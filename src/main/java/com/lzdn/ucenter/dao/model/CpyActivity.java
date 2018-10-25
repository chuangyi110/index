package com.lzdn.ucenter.dao.model;

import java.io.Serializable;

public class CpyActivity implements Serializable {
    /**
     * 促销活动id
     *
     * @mbg.generated
     */
    private Integer activityId;

    /**
     * 活动名称
     *
     * @mbg.generated
     */
    private String activityName;

    /**
     * 所属公司
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     * 商品id
     *
     * @mbg.generated
     */
    private Integer goodsId;

    /**
     * 活动类别id
     *
     * @mbg.generated
     */
    private Integer activityTypeId;

    /**
     * 活动规则
     *
     * @mbg.generated
     */
    private String activityRules;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private Long beginTime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private Long endTime;

    /**
     * 活动状态
     *
     * @mbg.generated
     */
    private Byte activityStatus;

    /**
     * 折扣 e.g. 75(75折)
     *
     * @mbg.generated
     */
    private Byte discount;

    /**
     * 满送（满10次送1次）
     *
     * @mbg.generated
     */
    private Byte sendFull;

    /**
     * 满送类型 0送本产品/1送其他产品
     *
     * @mbg.generated
     */
    private Byte sendFullType;

    /**
     * 满送为其他产品时id
     *
     * @mbg.generated
     */
    private Long sendFullOtherGoodsId;

    /**
     * 满减类型 0为满立减/1为每满立减
     *
     * @mbg.generated
     */
    private Byte moneyOffType;

    /**
     * 满减条件(单位分)
     *
     * @mbg.generated
     */
    private Long moneyOffPrerequisite;

    /**
     * 满减数额(单位分)
     *
     * @mbg.generated
     */
    private Long moneyOff;

    private static final long serialVersionUID = 1L;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityRules() {
        return activityRules;
    }

    public void setActivityRules(String activityRules) {
        this.activityRules = activityRules;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Byte getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Byte activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Byte getDiscount() {
        return discount;
    }

    public void setDiscount(Byte discount) {
        this.discount = discount;
    }

    public Byte getSendFull() {
        return sendFull;
    }

    public void setSendFull(Byte sendFull) {
        this.sendFull = sendFull;
    }

    public Byte getSendFullType() {
        return sendFullType;
    }

    public void setSendFullType(Byte sendFullType) {
        this.sendFullType = sendFullType;
    }

    public Long getSendFullOtherGoodsId() {
        return sendFullOtherGoodsId;
    }

    public void setSendFullOtherGoodsId(Long sendFullOtherGoodsId) {
        this.sendFullOtherGoodsId = sendFullOtherGoodsId;
    }

    public Byte getMoneyOffType() {
        return moneyOffType;
    }

    public void setMoneyOffType(Byte moneyOffType) {
        this.moneyOffType = moneyOffType;
    }

    public Long getMoneyOffPrerequisite() {
        return moneyOffPrerequisite;
    }

    public void setMoneyOffPrerequisite(Long moneyOffPrerequisite) {
        this.moneyOffPrerequisite = moneyOffPrerequisite;
    }

    public Long getMoneyOff() {
        return moneyOff;
    }

    public void setMoneyOff(Long moneyOff) {
        this.moneyOff = moneyOff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", activityName=").append(activityName);
        sb.append(", companyId=").append(companyId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", activityTypeId=").append(activityTypeId);
        sb.append(", activityRules=").append(activityRules);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", activityStatus=").append(activityStatus);
        sb.append(", discount=").append(discount);
        sb.append(", sendFull=").append(sendFull);
        sb.append(", sendFullType=").append(sendFullType);
        sb.append(", sendFullOtherGoodsId=").append(sendFullOtherGoodsId);
        sb.append(", moneyOffType=").append(moneyOffType);
        sb.append(", moneyOffPrerequisite=").append(moneyOffPrerequisite);
        sb.append(", moneyOff=").append(moneyOff);
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
        CpyActivity other = (CpyActivity) that;
        return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
                && (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
                && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
                && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
                && (this.getActivityTypeId() == null ? other.getActivityTypeId() == null : this.getActivityTypeId().equals(other.getActivityTypeId()))
                && (this.getActivityRules() == null ? other.getActivityRules() == null : this.getActivityRules().equals(other.getActivityRules()))
                && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getActivityStatus() == null ? other.getActivityStatus() == null : this.getActivityStatus().equals(other.getActivityStatus()))
                && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
                && (this.getSendFull() == null ? other.getSendFull() == null : this.getSendFull().equals(other.getSendFull()))
                && (this.getSendFullType() == null ? other.getSendFullType() == null : this.getSendFullType().equals(other.getSendFullType()))
                && (this.getSendFullOtherGoodsId() == null ? other.getSendFullOtherGoodsId() == null : this.getSendFullOtherGoodsId().equals(other.getSendFullOtherGoodsId()))
                && (this.getMoneyOffType() == null ? other.getMoneyOffType() == null : this.getMoneyOffType().equals(other.getMoneyOffType()))
                && (this.getMoneyOffPrerequisite() == null ? other.getMoneyOffPrerequisite() == null : this.getMoneyOffPrerequisite().equals(other.getMoneyOffPrerequisite()))
                && (this.getMoneyOff() == null ? other.getMoneyOff() == null : this.getMoneyOff().equals(other.getMoneyOff()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getActivityTypeId() == null) ? 0 : getActivityTypeId().hashCode());
        result = prime * result + ((getActivityRules() == null) ? 0 : getActivityRules().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getActivityStatus() == null) ? 0 : getActivityStatus().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getSendFull() == null) ? 0 : getSendFull().hashCode());
        result = prime * result + ((getSendFullType() == null) ? 0 : getSendFullType().hashCode());
        result = prime * result + ((getSendFullOtherGoodsId() == null) ? 0 : getSendFullOtherGoodsId().hashCode());
        result = prime * result + ((getMoneyOffType() == null) ? 0 : getMoneyOffType().hashCode());
        result = prime * result + ((getMoneyOffPrerequisite() == null) ? 0 : getMoneyOffPrerequisite().hashCode());
        result = prime * result + ((getMoneyOff() == null) ? 0 : getMoneyOff().hashCode());
        return result;
    }
}