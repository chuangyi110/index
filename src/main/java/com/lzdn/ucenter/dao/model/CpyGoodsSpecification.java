package com.lzdn.ucenter.dao.model;

import java.io.Serializable;

public class CpyGoodsSpecification implements Serializable {
    private Integer goodsSpecificationId;

    /**
     * 商品id
     *
     * @mbg.generated
     */
    private Integer goodsId;

    /**
     * 分类id
     *
     * @mbg.generated
     */
    private Integer specificationId;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(Integer goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsSpecificationId=").append(goodsSpecificationId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", specificationId=").append(specificationId);
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
        CpyGoodsSpecification other = (CpyGoodsSpecification) that;
        return (this.getGoodsSpecificationId() == null ? other.getGoodsSpecificationId() == null : this.getGoodsSpecificationId().equals(other.getGoodsSpecificationId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getSpecificationId() == null ? other.getSpecificationId() == null : this.getSpecificationId().equals(other.getSpecificationId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsSpecificationId() == null) ? 0 : getGoodsSpecificationId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getSpecificationId() == null) ? 0 : getSpecificationId().hashCode());
        return result;
    }
}