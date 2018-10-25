package com.lzdn.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CpyActivityExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public CpyActivityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdIsNull() {
            addCriterion("activity_type_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdIsNotNull() {
            addCriterion("activity_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdEqualTo(Integer value) {
            addCriterion("activity_type_id =", value, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdNotEqualTo(Integer value) {
            addCriterion("activity_type_id <>", value, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdGreaterThan(Integer value) {
            addCriterion("activity_type_id >", value, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_type_id >=", value, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdLessThan(Integer value) {
            addCriterion("activity_type_id <", value, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_type_id <=", value, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdIn(List<Integer> values) {
            addCriterion("activity_type_id in", values, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdNotIn(List<Integer> values) {
            addCriterion("activity_type_id not in", values, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_type_id between", value1, value2, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_type_id not between", value1, value2, "activityTypeId");
            return (Criteria) this;
        }

        public Criteria andActivityRulesIsNull() {
            addCriterion("activity_rules is null");
            return (Criteria) this;
        }

        public Criteria andActivityRulesIsNotNull() {
            addCriterion("activity_rules is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRulesEqualTo(String value) {
            addCriterion("activity_rules =", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesNotEqualTo(String value) {
            addCriterion("activity_rules <>", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesGreaterThan(String value) {
            addCriterion("activity_rules >", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesGreaterThanOrEqualTo(String value) {
            addCriterion("activity_rules >=", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesLessThan(String value) {
            addCriterion("activity_rules <", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesLessThanOrEqualTo(String value) {
            addCriterion("activity_rules <=", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesLike(String value) {
            addCriterion("activity_rules like", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesNotLike(String value) {
            addCriterion("activity_rules not like", value, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesIn(List<String> values) {
            addCriterion("activity_rules in", values, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesNotIn(List<String> values) {
            addCriterion("activity_rules not in", values, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesBetween(String value1, String value2) {
            addCriterion("activity_rules between", value1, value2, "activityRules");
            return (Criteria) this;
        }

        public Criteria andActivityRulesNotBetween(String value1, String value2) {
            addCriterion("activity_rules not between", value1, value2, "activityRules");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Long value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Long value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Long value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Long value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Long value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Long> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Long> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Long value1, Long value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Long value1, Long value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Long value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Long value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Long value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Long value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Long> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Long> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Long value1, Long value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNull() {
            addCriterion("activity_status is null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNotNull() {
            addCriterion("activity_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusEqualTo(Byte value) {
            addCriterion("activity_status =", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotEqualTo(Byte value) {
            addCriterion("activity_status <>", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThan(Byte value) {
            addCriterion("activity_status >", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("activity_status >=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThan(Byte value) {
            addCriterion("activity_status <", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThanOrEqualTo(Byte value) {
            addCriterion("activity_status <=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIn(List<Byte> values) {
            addCriterion("activity_status in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotIn(List<Byte> values) {
            addCriterion("activity_status not in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusBetween(Byte value1, Byte value2) {
            addCriterion("activity_status between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("activity_status not between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Byte value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Byte value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Byte value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Byte value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Byte value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Byte value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Byte> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Byte> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Byte value1, Byte value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Byte value1, Byte value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andSendFullIsNull() {
            addCriterion("send_full is null");
            return (Criteria) this;
        }

        public Criteria andSendFullIsNotNull() {
            addCriterion("send_full is not null");
            return (Criteria) this;
        }

        public Criteria andSendFullEqualTo(Byte value) {
            addCriterion("send_full =", value, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullNotEqualTo(Byte value) {
            addCriterion("send_full <>", value, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullGreaterThan(Byte value) {
            addCriterion("send_full >", value, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_full >=", value, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullLessThan(Byte value) {
            addCriterion("send_full <", value, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullLessThanOrEqualTo(Byte value) {
            addCriterion("send_full <=", value, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullIn(List<Byte> values) {
            addCriterion("send_full in", values, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullNotIn(List<Byte> values) {
            addCriterion("send_full not in", values, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullBetween(Byte value1, Byte value2) {
            addCriterion("send_full between", value1, value2, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullNotBetween(Byte value1, Byte value2) {
            addCriterion("send_full not between", value1, value2, "sendFull");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeIsNull() {
            addCriterion("send_full_type is null");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeIsNotNull() {
            addCriterion("send_full_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeEqualTo(Byte value) {
            addCriterion("send_full_type =", value, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeNotEqualTo(Byte value) {
            addCriterion("send_full_type <>", value, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeGreaterThan(Byte value) {
            addCriterion("send_full_type >", value, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_full_type >=", value, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeLessThan(Byte value) {
            addCriterion("send_full_type <", value, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeLessThanOrEqualTo(Byte value) {
            addCriterion("send_full_type <=", value, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeIn(List<Byte> values) {
            addCriterion("send_full_type in", values, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeNotIn(List<Byte> values) {
            addCriterion("send_full_type not in", values, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeBetween(Byte value1, Byte value2) {
            addCriterion("send_full_type between", value1, value2, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("send_full_type not between", value1, value2, "sendFullType");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdIsNull() {
            addCriterion("send_full_other_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdIsNotNull() {
            addCriterion("send_full_other_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdEqualTo(Long value) {
            addCriterion("send_full_other_goods_id =", value, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdNotEqualTo(Long value) {
            addCriterion("send_full_other_goods_id <>", value, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdGreaterThan(Long value) {
            addCriterion("send_full_other_goods_id >", value, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("send_full_other_goods_id >=", value, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdLessThan(Long value) {
            addCriterion("send_full_other_goods_id <", value, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("send_full_other_goods_id <=", value, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdIn(List<Long> values) {
            addCriterion("send_full_other_goods_id in", values, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdNotIn(List<Long> values) {
            addCriterion("send_full_other_goods_id not in", values, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdBetween(Long value1, Long value2) {
            addCriterion("send_full_other_goods_id between", value1, value2, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andSendFullOtherGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("send_full_other_goods_id not between", value1, value2, "sendFullOtherGoodsId");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeIsNull() {
            addCriterion("money_off_type is null");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeIsNotNull() {
            addCriterion("money_off_type is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeEqualTo(Byte value) {
            addCriterion("money_off_type =", value, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeNotEqualTo(Byte value) {
            addCriterion("money_off_type <>", value, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeGreaterThan(Byte value) {
            addCriterion("money_off_type >", value, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("money_off_type >=", value, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeLessThan(Byte value) {
            addCriterion("money_off_type <", value, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeLessThanOrEqualTo(Byte value) {
            addCriterion("money_off_type <=", value, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeIn(List<Byte> values) {
            addCriterion("money_off_type in", values, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeNotIn(List<Byte> values) {
            addCriterion("money_off_type not in", values, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeBetween(Byte value1, Byte value2) {
            addCriterion("money_off_type between", value1, value2, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("money_off_type not between", value1, value2, "moneyOffType");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteIsNull() {
            addCriterion("money_off_prerequisite is null");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteIsNotNull() {
            addCriterion("money_off_prerequisite is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteEqualTo(Long value) {
            addCriterion("money_off_prerequisite =", value, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteNotEqualTo(Long value) {
            addCriterion("money_off_prerequisite <>", value, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteGreaterThan(Long value) {
            addCriterion("money_off_prerequisite >", value, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteGreaterThanOrEqualTo(Long value) {
            addCriterion("money_off_prerequisite >=", value, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteLessThan(Long value) {
            addCriterion("money_off_prerequisite <", value, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteLessThanOrEqualTo(Long value) {
            addCriterion("money_off_prerequisite <=", value, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteIn(List<Long> values) {
            addCriterion("money_off_prerequisite in", values, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteNotIn(List<Long> values) {
            addCriterion("money_off_prerequisite not in", values, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteBetween(Long value1, Long value2) {
            addCriterion("money_off_prerequisite between", value1, value2, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffPrerequisiteNotBetween(Long value1, Long value2) {
            addCriterion("money_off_prerequisite not between", value1, value2, "moneyOffPrerequisite");
            return (Criteria) this;
        }

        public Criteria andMoneyOffIsNull() {
            addCriterion("money_off is null");
            return (Criteria) this;
        }

        public Criteria andMoneyOffIsNotNull() {
            addCriterion("money_off is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyOffEqualTo(Long value) {
            addCriterion("money_off =", value, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffNotEqualTo(Long value) {
            addCriterion("money_off <>", value, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffGreaterThan(Long value) {
            addCriterion("money_off >", value, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffGreaterThanOrEqualTo(Long value) {
            addCriterion("money_off >=", value, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffLessThan(Long value) {
            addCriterion("money_off <", value, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffLessThanOrEqualTo(Long value) {
            addCriterion("money_off <=", value, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffIn(List<Long> values) {
            addCriterion("money_off in", values, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffNotIn(List<Long> values) {
            addCriterion("money_off not in", values, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffBetween(Long value1, Long value2) {
            addCriterion("money_off between", value1, value2, "moneyOff");
            return (Criteria) this;
        }

        public Criteria andMoneyOffNotBetween(Long value1, Long value2) {
            addCriterion("money_off not between", value1, value2, "moneyOff");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}