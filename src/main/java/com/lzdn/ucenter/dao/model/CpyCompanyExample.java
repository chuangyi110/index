package com.lzdn.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CpyCompanyExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public CpyCompanyExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarIsNull() {
            addCriterion("company_avatar is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarIsNotNull() {
            addCriterion("company_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarEqualTo(String value) {
            addCriterion("company_avatar =", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarNotEqualTo(String value) {
            addCriterion("company_avatar <>", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarGreaterThan(String value) {
            addCriterion("company_avatar >", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("company_avatar >=", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarLessThan(String value) {
            addCriterion("company_avatar <", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarLessThanOrEqualTo(String value) {
            addCriterion("company_avatar <=", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarLike(String value) {
            addCriterion("company_avatar like", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarNotLike(String value) {
            addCriterion("company_avatar not like", value, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarIn(List<String> values) {
            addCriterion("company_avatar in", values, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarNotIn(List<String> values) {
            addCriterion("company_avatar not in", values, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarBetween(String value1, String value2) {
            addCriterion("company_avatar between", value1, value2, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyAvatarNotBetween(String value1, String value2) {
            addCriterion("company_avatar not between", value1, value2, "companyAvatar");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseIsNull() {
            addCriterion("company_license is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseIsNotNull() {
            addCriterion("company_license is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseEqualTo(String value) {
            addCriterion("company_license =", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseNotEqualTo(String value) {
            addCriterion("company_license <>", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseGreaterThan(String value) {
            addCriterion("company_license >", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("company_license >=", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseLessThan(String value) {
            addCriterion("company_license <", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseLessThanOrEqualTo(String value) {
            addCriterion("company_license <=", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseLike(String value) {
            addCriterion("company_license like", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseNotLike(String value) {
            addCriterion("company_license not like", value, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseIn(List<String> values) {
            addCriterion("company_license in", values, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseNotIn(List<String> values) {
            addCriterion("company_license not in", values, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseBetween(String value1, String value2) {
            addCriterion("company_license between", value1, value2, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyLicenseNotBetween(String value1, String value2) {
            addCriterion("company_license not between", value1, value2, "companyLicense");
            return (Criteria) this;
        }

        public Criteria andContryIsNull() {
            addCriterion("contry is null");
            return (Criteria) this;
        }

        public Criteria andContryIsNotNull() {
            addCriterion("contry is not null");
            return (Criteria) this;
        }

        public Criteria andContryEqualTo(Integer value) {
            addCriterion("contry =", value, "contry");
            return (Criteria) this;
        }

        public Criteria andContryNotEqualTo(Integer value) {
            addCriterion("contry <>", value, "contry");
            return (Criteria) this;
        }

        public Criteria andContryGreaterThan(Integer value) {
            addCriterion("contry >", value, "contry");
            return (Criteria) this;
        }

        public Criteria andContryGreaterThanOrEqualTo(Integer value) {
            addCriterion("contry >=", value, "contry");
            return (Criteria) this;
        }

        public Criteria andContryLessThan(Integer value) {
            addCriterion("contry <", value, "contry");
            return (Criteria) this;
        }

        public Criteria andContryLessThanOrEqualTo(Integer value) {
            addCriterion("contry <=", value, "contry");
            return (Criteria) this;
        }

        public Criteria andContryIn(List<Integer> values) {
            addCriterion("contry in", values, "contry");
            return (Criteria) this;
        }

        public Criteria andContryNotIn(List<Integer> values) {
            addCriterion("contry not in", values, "contry");
            return (Criteria) this;
        }

        public Criteria andContryBetween(Integer value1, Integer value2) {
            addCriterion("contry between", value1, value2, "contry");
            return (Criteria) this;
        }

        public Criteria andContryNotBetween(Integer value1, Integer value2) {
            addCriterion("contry not between", value1, value2, "contry");
            return (Criteria) this;
        }

        public Criteria andProvincesIdIsNull() {
            addCriterion("provinces_id is null");
            return (Criteria) this;
        }

        public Criteria andProvincesIdIsNotNull() {
            addCriterion("provinces_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvincesIdEqualTo(Integer value) {
            addCriterion("provinces_id =", value, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdNotEqualTo(Integer value) {
            addCriterion("provinces_id <>", value, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdGreaterThan(Integer value) {
            addCriterion("provinces_id >", value, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("provinces_id >=", value, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdLessThan(Integer value) {
            addCriterion("provinces_id <", value, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdLessThanOrEqualTo(Integer value) {
            addCriterion("provinces_id <=", value, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdIn(List<Integer> values) {
            addCriterion("provinces_id in", values, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdNotIn(List<Integer> values) {
            addCriterion("provinces_id not in", values, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdBetween(Integer value1, Integer value2) {
            addCriterion("provinces_id between", value1, value2, "provincesId");
            return (Criteria) this;
        }

        public Criteria andProvincesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("provinces_id not between", value1, value2, "provincesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdIsNull() {
            addCriterion("cities_id is null");
            return (Criteria) this;
        }

        public Criteria andCitiesIdIsNotNull() {
            addCriterion("cities_id is not null");
            return (Criteria) this;
        }

        public Criteria andCitiesIdEqualTo(Integer value) {
            addCriterion("cities_id =", value, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdNotEqualTo(Integer value) {
            addCriterion("cities_id <>", value, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdGreaterThan(Integer value) {
            addCriterion("cities_id >", value, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cities_id >=", value, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdLessThan(Integer value) {
            addCriterion("cities_id <", value, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdLessThanOrEqualTo(Integer value) {
            addCriterion("cities_id <=", value, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdIn(List<Integer> values) {
            addCriterion("cities_id in", values, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdNotIn(List<Integer> values) {
            addCriterion("cities_id not in", values, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdBetween(Integer value1, Integer value2) {
            addCriterion("cities_id between", value1, value2, "citiesId");
            return (Criteria) this;
        }

        public Criteria andCitiesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cities_id not between", value1, value2, "citiesId");
            return (Criteria) this;
        }

        public Criteria andAreasIdIsNull() {
            addCriterion("areas_id is null");
            return (Criteria) this;
        }

        public Criteria andAreasIdIsNotNull() {
            addCriterion("areas_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreasIdEqualTo(Integer value) {
            addCriterion("areas_id =", value, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdNotEqualTo(Integer value) {
            addCriterion("areas_id <>", value, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdGreaterThan(Integer value) {
            addCriterion("areas_id >", value, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("areas_id >=", value, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdLessThan(Integer value) {
            addCriterion("areas_id <", value, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdLessThanOrEqualTo(Integer value) {
            addCriterion("areas_id <=", value, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdIn(List<Integer> values) {
            addCriterion("areas_id in", values, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdNotIn(List<Integer> values) {
            addCriterion("areas_id not in", values, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdBetween(Integer value1, Integer value2) {
            addCriterion("areas_id between", value1, value2, "areasId");
            return (Criteria) this;
        }

        public Criteria andAreasIdNotBetween(Integer value1, Integer value2) {
            addCriterion("areas_id not between", value1, value2, "areasId");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusIsNull() {
            addCriterion("company_status is null");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusIsNotNull() {
            addCriterion("company_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusEqualTo(Byte value) {
            addCriterion("company_status =", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusNotEqualTo(Byte value) {
            addCriterion("company_status <>", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusGreaterThan(Byte value) {
            addCriterion("company_status >", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("company_status >=", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusLessThan(Byte value) {
            addCriterion("company_status <", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("company_status <=", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusIn(List<Byte> values) {
            addCriterion("company_status in", values, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusNotIn(List<Byte> values) {
            addCriterion("company_status not in", values, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusBetween(Byte value1, Byte value2) {
            addCriterion("company_status between", value1, value2, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("company_status not between", value1, value2, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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