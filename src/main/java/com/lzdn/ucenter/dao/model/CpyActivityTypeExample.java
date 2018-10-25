package com.lzdn.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CpyActivityTypeExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public CpyActivityTypeExample() {
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

        public Criteria andActivityTypeIsNull() {
            addCriterion("activity_type is null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNotNull() {
            addCriterion("activity_type is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeEqualTo(String value) {
            addCriterion("activity_type =", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotEqualTo(String value) {
            addCriterion("activity_type <>", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThan(String value) {
            addCriterion("activity_type >", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("activity_type >=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThan(String value) {
            addCriterion("activity_type <", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThanOrEqualTo(String value) {
            addCriterion("activity_type <=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLike(String value) {
            addCriterion("activity_type like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotLike(String value) {
            addCriterion("activity_type not like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIn(List<String> values) {
            addCriterion("activity_type in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotIn(List<String> values) {
            addCriterion("activity_type not in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeBetween(String value1, String value2) {
            addCriterion("activity_type between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotBetween(String value1, String value2) {
            addCriterion("activity_type not between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkIsNull() {
            addCriterion("activity_remark is null");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkIsNotNull() {
            addCriterion("activity_remark is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkEqualTo(String value) {
            addCriterion("activity_remark =", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotEqualTo(String value) {
            addCriterion("activity_remark <>", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkGreaterThan(String value) {
            addCriterion("activity_remark >", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("activity_remark >=", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkLessThan(String value) {
            addCriterion("activity_remark <", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkLessThanOrEqualTo(String value) {
            addCriterion("activity_remark <=", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkLike(String value) {
            addCriterion("activity_remark like", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotLike(String value) {
            addCriterion("activity_remark not like", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkIn(List<String> values) {
            addCriterion("activity_remark in", values, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotIn(List<String> values) {
            addCriterion("activity_remark not in", values, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkBetween(String value1, String value2) {
            addCriterion("activity_remark between", value1, value2, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotBetween(String value1, String value2) {
            addCriterion("activity_remark not between", value1, value2, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsIsNull() {
            addCriterion("relationship_fields is null");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsIsNotNull() {
            addCriterion("relationship_fields is not null");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsEqualTo(String value) {
            addCriterion("relationship_fields =", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsNotEqualTo(String value) {
            addCriterion("relationship_fields <>", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsGreaterThan(String value) {
            addCriterion("relationship_fields >", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsGreaterThanOrEqualTo(String value) {
            addCriterion("relationship_fields >=", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsLessThan(String value) {
            addCriterion("relationship_fields <", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsLessThanOrEqualTo(String value) {
            addCriterion("relationship_fields <=", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsLike(String value) {
            addCriterion("relationship_fields like", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsNotLike(String value) {
            addCriterion("relationship_fields not like", value, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsIn(List<String> values) {
            addCriterion("relationship_fields in", values, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsNotIn(List<String> values) {
            addCriterion("relationship_fields not in", values, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsBetween(String value1, String value2) {
            addCriterion("relationship_fields between", value1, value2, "relationshipFields");
            return (Criteria) this;
        }

        public Criteria andRelationshipFieldsNotBetween(String value1, String value2) {
            addCriterion("relationship_fields not between", value1, value2, "relationshipFields");
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