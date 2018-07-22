package com.jd.m.cms.bjshare.domain.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityDataStatisticalAdditionalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityDataStatisticalAdditionalExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdIsNull() {
            addCriterion("statistical_id is null");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdIsNotNull() {
            addCriterion("statistical_id is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdEqualTo(Integer value) {
            addCriterion("statistical_id =", value, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdNotEqualTo(Integer value) {
            addCriterion("statistical_id <>", value, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdGreaterThan(Integer value) {
            addCriterion("statistical_id >", value, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistical_id >=", value, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdLessThan(Integer value) {
            addCriterion("statistical_id <", value, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdLessThanOrEqualTo(Integer value) {
            addCriterion("statistical_id <=", value, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdIn(List<Integer> values) {
            addCriterion("statistical_id in", values, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdNotIn(List<Integer> values) {
            addCriterion("statistical_id not in", values, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdBetween(Integer value1, Integer value2) {
            addCriterion("statistical_id between", value1, value2, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andStatisticalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("statistical_id not between", value1, value2, "statisticalId");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvIsNull() {
            addCriterion("share_success_uv is null");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvIsNotNull() {
            addCriterion("share_success_uv is not null");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvEqualTo(Integer value) {
            addCriterion("share_success_uv =", value, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvNotEqualTo(Integer value) {
            addCriterion("share_success_uv <>", value, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvGreaterThan(Integer value) {
            addCriterion("share_success_uv >", value, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_success_uv >=", value, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvLessThan(Integer value) {
            addCriterion("share_success_uv <", value, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvLessThanOrEqualTo(Integer value) {
            addCriterion("share_success_uv <=", value, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvIn(List<Integer> values) {
            addCriterion("share_success_uv in", values, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvNotIn(List<Integer> values) {
            addCriterion("share_success_uv not in", values, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvBetween(Integer value1, Integer value2) {
            addCriterion("share_success_uv between", value1, value2, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareSuccessUvNotBetween(Integer value1, Integer value2) {
            addCriterion("share_success_uv not between", value1, value2, "shareSuccessUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumIsNull() {
            addCriterion("share_open_num is null");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumIsNotNull() {
            addCriterion("share_open_num is not null");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumEqualTo(Integer value) {
            addCriterion("share_open_num =", value, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumNotEqualTo(Integer value) {
            addCriterion("share_open_num <>", value, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumGreaterThan(Integer value) {
            addCriterion("share_open_num >", value, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_open_num >=", value, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumLessThan(Integer value) {
            addCriterion("share_open_num <", value, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumLessThanOrEqualTo(Integer value) {
            addCriterion("share_open_num <=", value, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumIn(List<Integer> values) {
            addCriterion("share_open_num in", values, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumNotIn(List<Integer> values) {
            addCriterion("share_open_num not in", values, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumBetween(Integer value1, Integer value2) {
            addCriterion("share_open_num between", value1, value2, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenNumNotBetween(Integer value1, Integer value2) {
            addCriterion("share_open_num not between", value1, value2, "shareOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumIsNull() {
            addCriterion("shared_open_num is null");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumIsNotNull() {
            addCriterion("shared_open_num is not null");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumEqualTo(Integer value) {
            addCriterion("shared_open_num =", value, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumNotEqualTo(Integer value) {
            addCriterion("shared_open_num <>", value, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumGreaterThan(Integer value) {
            addCriterion("shared_open_num >", value, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("shared_open_num >=", value, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumLessThan(Integer value) {
            addCriterion("shared_open_num <", value, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumLessThanOrEqualTo(Integer value) {
            addCriterion("shared_open_num <=", value, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumIn(List<Integer> values) {
            addCriterion("shared_open_num in", values, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumNotIn(List<Integer> values) {
            addCriterion("shared_open_num not in", values, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumBetween(Integer value1, Integer value2) {
            addCriterion("shared_open_num between", value1, value2, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andSharedOpenNumNotBetween(Integer value1, Integer value2) {
            addCriterion("shared_open_num not between", value1, value2, "sharedOpenNum");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvIsNull() {
            addCriterion("share_open_uv is null");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvIsNotNull() {
            addCriterion("share_open_uv is not null");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvEqualTo(Integer value) {
            addCriterion("share_open_uv =", value, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvNotEqualTo(Integer value) {
            addCriterion("share_open_uv <>", value, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvGreaterThan(Integer value) {
            addCriterion("share_open_uv >", value, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_open_uv >=", value, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvLessThan(Integer value) {
            addCriterion("share_open_uv <", value, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvLessThanOrEqualTo(Integer value) {
            addCriterion("share_open_uv <=", value, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvIn(List<Integer> values) {
            addCriterion("share_open_uv in", values, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvNotIn(List<Integer> values) {
            addCriterion("share_open_uv not in", values, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvBetween(Integer value1, Integer value2) {
            addCriterion("share_open_uv between", value1, value2, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andShareOpenUvNotBetween(Integer value1, Integer value2) {
            addCriterion("share_open_uv not between", value1, value2, "shareOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvIsNull() {
            addCriterion("shared_open_uv is null");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvIsNotNull() {
            addCriterion("shared_open_uv is not null");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvEqualTo(Integer value) {
            addCriterion("shared_open_uv =", value, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvNotEqualTo(Integer value) {
            addCriterion("shared_open_uv <>", value, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvGreaterThan(Integer value) {
            addCriterion("shared_open_uv >", value, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvGreaterThanOrEqualTo(Integer value) {
            addCriterion("shared_open_uv >=", value, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvLessThan(Integer value) {
            addCriterion("shared_open_uv <", value, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvLessThanOrEqualTo(Integer value) {
            addCriterion("shared_open_uv <=", value, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvIn(List<Integer> values) {
            addCriterion("shared_open_uv in", values, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvNotIn(List<Integer> values) {
            addCriterion("shared_open_uv not in", values, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvBetween(Integer value1, Integer value2) {
            addCriterion("shared_open_uv between", value1, value2, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andSharedOpenUvNotBetween(Integer value1, Integer value2) {
            addCriterion("shared_open_uv not between", value1, value2, "sharedOpenUv");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("reserve1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("reserve1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("reserve1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("reserve1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("reserve1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("reserve1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("reserve1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("reserve1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("reserve1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("reserve1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("reserve1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("reserve1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("reserve1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("reserve1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("reserve2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("reserve2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("reserve2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("reserve2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("reserve2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("reserve2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("reserve2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("reserve2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("reserve2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("reserve2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("reserve2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("reserve2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("reserve2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("reserve2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("reserve3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("reserve3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("reserve3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("reserve3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("reserve3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("reserve3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("reserve3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("reserve3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("reserve3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("reserve3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("reserve3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("reserve3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("reserve3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("reserve3 not between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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