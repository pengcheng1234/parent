package com.jd.m.cms.bjshare.domain.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponRecordExample() {
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

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(Long value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(Long value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(Long value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(Long value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(Long value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<Long> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<Long> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(Long value1, Long value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(Long value1, Long value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdIsNull() {
            addCriterion("cps_type_cd is null");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdIsNotNull() {
            addCriterion("cps_type_cd is not null");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdEqualTo(Integer value) {
            addCriterion("cps_type_cd =", value, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdNotEqualTo(Integer value) {
            addCriterion("cps_type_cd <>", value, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdGreaterThan(Integer value) {
            addCriterion("cps_type_cd >", value, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cps_type_cd >=", value, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdLessThan(Integer value) {
            addCriterion("cps_type_cd <", value, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdLessThanOrEqualTo(Integer value) {
            addCriterion("cps_type_cd <=", value, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdIn(List<Integer> values) {
            addCriterion("cps_type_cd in", values, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdNotIn(List<Integer> values) {
            addCriterion("cps_type_cd not in", values, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdBetween(Integer value1, Integer value2) {
            addCriterion("cps_type_cd between", value1, value2, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsTypeCdNotBetween(Integer value1, Integer value2) {
            addCriterion("cps_type_cd not between", value1, value2, "cpsTypeCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdIsNull() {
            addCriterion("cps_cate_cd is null");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdIsNotNull() {
            addCriterion("cps_cate_cd is not null");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdEqualTo(Integer value) {
            addCriterion("cps_cate_cd =", value, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdNotEqualTo(Integer value) {
            addCriterion("cps_cate_cd <>", value, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdGreaterThan(Integer value) {
            addCriterion("cps_cate_cd >", value, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cps_cate_cd >=", value, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdLessThan(Integer value) {
            addCriterion("cps_cate_cd <", value, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdLessThanOrEqualTo(Integer value) {
            addCriterion("cps_cate_cd <=", value, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdIn(List<Integer> values) {
            addCriterion("cps_cate_cd in", values, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdNotIn(List<Integer> values) {
            addCriterion("cps_cate_cd not in", values, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdBetween(Integer value1, Integer value2) {
            addCriterion("cps_cate_cd between", value1, value2, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andCpsCateCdNotBetween(Integer value1, Integer value2) {
            addCriterion("cps_cate_cd not between", value1, value2, "cpsCateCd");
            return (Criteria) this;
        }

        public Criteria andUseTmIsNull() {
            addCriterion("use_tm is null");
            return (Criteria) this;
        }

        public Criteria andUseTmIsNotNull() {
            addCriterion("use_tm is not null");
            return (Criteria) this;
        }

        public Criteria andUseTmEqualTo(Date value) {
            addCriterion("use_tm =", value, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmNotEqualTo(Date value) {
            addCriterion("use_tm <>", value, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmGreaterThan(Date value) {
            addCriterion("use_tm >", value, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmGreaterThanOrEqualTo(Date value) {
            addCriterion("use_tm >=", value, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmLessThan(Date value) {
            addCriterion("use_tm <", value, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmLessThanOrEqualTo(Date value) {
            addCriterion("use_tm <=", value, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmIn(List<Date> values) {
            addCriterion("use_tm in", values, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmNotIn(List<Date> values) {
            addCriterion("use_tm not in", values, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmBetween(Date value1, Date value2) {
            addCriterion("use_tm between", value1, value2, "useTm");
            return (Criteria) this;
        }

        public Criteria andUseTmNotBetween(Date value1, Date value2) {
            addCriterion("use_tm not between", value1, value2, "useTm");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdIsNull() {
            addCriterion("parent_sale_ord_id is null");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdIsNotNull() {
            addCriterion("parent_sale_ord_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdEqualTo(String value) {
            addCriterion("parent_sale_ord_id =", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdNotEqualTo(String value) {
            addCriterion("parent_sale_ord_id <>", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdGreaterThan(String value) {
            addCriterion("parent_sale_ord_id >", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_sale_ord_id >=", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdLessThan(String value) {
            addCriterion("parent_sale_ord_id <", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdLessThanOrEqualTo(String value) {
            addCriterion("parent_sale_ord_id <=", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdLike(String value) {
            addCriterion("parent_sale_ord_id like", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdNotLike(String value) {
            addCriterion("parent_sale_ord_id not like", value, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdIn(List<String> values) {
            addCriterion("parent_sale_ord_id in", values, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdNotIn(List<String> values) {
            addCriterion("parent_sale_ord_id not in", values, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdBetween(String value1, String value2) {
            addCriterion("parent_sale_ord_id between", value1, value2, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andParentSaleOrdIdNotBetween(String value1, String value2) {
            addCriterion("parent_sale_ord_id not between", value1, value2, "parentSaleOrdId");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctIsNull() {
            addCriterion("user_log_acct is null");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctIsNotNull() {
            addCriterion("user_log_acct is not null");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctEqualTo(String value) {
            addCriterion("user_log_acct =", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctNotEqualTo(String value) {
            addCriterion("user_log_acct <>", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctGreaterThan(String value) {
            addCriterion("user_log_acct >", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctGreaterThanOrEqualTo(String value) {
            addCriterion("user_log_acct >=", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctLessThan(String value) {
            addCriterion("user_log_acct <", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctLessThanOrEqualTo(String value) {
            addCriterion("user_log_acct <=", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctLike(String value) {
            addCriterion("user_log_acct like", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctNotLike(String value) {
            addCriterion("user_log_acct not like", value, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctIn(List<String> values) {
            addCriterion("user_log_acct in", values, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctNotIn(List<String> values) {
            addCriterion("user_log_acct not in", values, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctBetween(String value1, String value2) {
            addCriterion("user_log_acct between", value1, value2, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andUserLogAcctNotBetween(String value1, String value2) {
            addCriterion("user_log_acct not between", value1, value2, "userLogAcct");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmIsNull() {
            addCriterion("arrive_acct_tm is null");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmIsNotNull() {
            addCriterion("arrive_acct_tm is not null");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmEqualTo(Date value) {
            addCriterion("arrive_acct_tm =", value, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmNotEqualTo(Date value) {
            addCriterion("arrive_acct_tm <>", value, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmGreaterThan(Date value) {
            addCriterion("arrive_acct_tm >", value, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmGreaterThanOrEqualTo(Date value) {
            addCriterion("arrive_acct_tm >=", value, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmLessThan(Date value) {
            addCriterion("arrive_acct_tm <", value, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmLessThanOrEqualTo(Date value) {
            addCriterion("arrive_acct_tm <=", value, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmIn(List<Date> values) {
            addCriterion("arrive_acct_tm in", values, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmNotIn(List<Date> values) {
            addCriterion("arrive_acct_tm not in", values, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmBetween(Date value1, Date value2) {
            addCriterion("arrive_acct_tm between", value1, value2, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andArriveAcctTmNotBetween(Date value1, Date value2) {
            addCriterion("arrive_acct_tm not between", value1, value2, "arriveAcctTm");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNull() {
            addCriterion("channel_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("channel_name =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("channel_name <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("channel_name >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_name >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("channel_name <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("channel_name <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("channel_name like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("channel_name not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("channel_name in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("channel_name not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("channel_name between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("channel_name not between", value1, value2, "channelName");
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

        public Criteria andPageClickKeyIsNull() {
            addCriterion("page_click_key is null");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyIsNotNull() {
            addCriterion("page_click_key is not null");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyEqualTo(String value) {
            addCriterion("page_click_key =", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyNotEqualTo(String value) {
            addCriterion("page_click_key <>", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyGreaterThan(String value) {
            addCriterion("page_click_key >", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyGreaterThanOrEqualTo(String value) {
            addCriterion("page_click_key >=", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyLessThan(String value) {
            addCriterion("page_click_key <", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyLessThanOrEqualTo(String value) {
            addCriterion("page_click_key <=", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyLike(String value) {
            addCriterion("page_click_key like", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyNotLike(String value) {
            addCriterion("page_click_key not like", value, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyIn(List<String> values) {
            addCriterion("page_click_key in", values, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyNotIn(List<String> values) {
            addCriterion("page_click_key not in", values, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyBetween(String value1, String value2) {
            addCriterion("page_click_key between", value1, value2, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andPageClickKeyNotBetween(String value1, String value2) {
            addCriterion("page_click_key not between", value1, value2, "pageClickKey");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueIsNull() {
            addCriterion("cps_face_value is null");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueIsNotNull() {
            addCriterion("cps_face_value is not null");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueEqualTo(Double value) {
            addCriterion("cps_face_value =", value, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueNotEqualTo(Double value) {
            addCriterion("cps_face_value <>", value, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueGreaterThan(Double value) {
            addCriterion("cps_face_value >", value, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueGreaterThanOrEqualTo(Double value) {
            addCriterion("cps_face_value >=", value, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueLessThan(Double value) {
            addCriterion("cps_face_value <", value, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueLessThanOrEqualTo(Double value) {
            addCriterion("cps_face_value <=", value, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueIn(List<Double> values) {
            addCriterion("cps_face_value in", values, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueNotIn(List<Double> values) {
            addCriterion("cps_face_value not in", values, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueBetween(Double value1, Double value2) {
            addCriterion("cps_face_value between", value1, value2, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andCpsFaceValueNotBetween(Double value1, Double value2) {
            addCriterion("cps_face_value not between", value1, value2, "cpsFaceValue");
            return (Criteria) this;
        }

        public Criteria andConsumeLimIsNull() {
            addCriterion("consume_lim is null");
            return (Criteria) this;
        }

        public Criteria andConsumeLimIsNotNull() {
            addCriterion("consume_lim is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeLimEqualTo(Double value) {
            addCriterion("consume_lim =", value, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimNotEqualTo(Double value) {
            addCriterion("consume_lim <>", value, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimGreaterThan(Double value) {
            addCriterion("consume_lim >", value, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimGreaterThanOrEqualTo(Double value) {
            addCriterion("consume_lim >=", value, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimLessThan(Double value) {
            addCriterion("consume_lim <", value, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimLessThanOrEqualTo(Double value) {
            addCriterion("consume_lim <=", value, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimIn(List<Double> values) {
            addCriterion("consume_lim in", values, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimNotIn(List<Double> values) {
            addCriterion("consume_lim not in", values, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimBetween(Double value1, Double value2) {
            addCriterion("consume_lim between", value1, value2, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andConsumeLimNotBetween(Double value1, Double value2) {
            addCriterion("consume_lim not between", value1, value2, "consumeLim");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdIsNull() {
            addCriterion("sale_ord_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdIsNotNull() {
            addCriterion("sale_ord_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdEqualTo(String value) {
            addCriterion("sale_ord_id =", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdNotEqualTo(String value) {
            addCriterion("sale_ord_id <>", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdGreaterThan(String value) {
            addCriterion("sale_ord_id >", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdGreaterThanOrEqualTo(String value) {
            addCriterion("sale_ord_id >=", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdLessThan(String value) {
            addCriterion("sale_ord_id <", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdLessThanOrEqualTo(String value) {
            addCriterion("sale_ord_id <=", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdLike(String value) {
            addCriterion("sale_ord_id like", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdNotLike(String value) {
            addCriterion("sale_ord_id not like", value, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdIn(List<String> values) {
            addCriterion("sale_ord_id in", values, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdNotIn(List<String> values) {
            addCriterion("sale_ord_id not in", values, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdBetween(String value1, String value2) {
            addCriterion("sale_ord_id between", value1, value2, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andSaleOrdIdNotBetween(String value1, String value2) {
            addCriterion("sale_ord_id not between", value1, value2, "saleOrdId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdIsNull() {
            addCriterion("item_first_cate_cd is null");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdIsNotNull() {
            addCriterion("item_first_cate_cd is not null");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdEqualTo(Integer value) {
            addCriterion("item_first_cate_cd =", value, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdNotEqualTo(Integer value) {
            addCriterion("item_first_cate_cd <>", value, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdGreaterThan(Integer value) {
            addCriterion("item_first_cate_cd >", value, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_first_cate_cd >=", value, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdLessThan(Integer value) {
            addCriterion("item_first_cate_cd <", value, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdLessThanOrEqualTo(Integer value) {
            addCriterion("item_first_cate_cd <=", value, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdIn(List<Integer> values) {
            addCriterion("item_first_cate_cd in", values, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdNotIn(List<Integer> values) {
            addCriterion("item_first_cate_cd not in", values, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdBetween(Integer value1, Integer value2) {
            addCriterion("item_first_cate_cd between", value1, value2, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateCdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_first_cate_cd not between", value1, value2, "itemFirstCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdIsNull() {
            addCriterion("item_second_cate_cd is null");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdIsNotNull() {
            addCriterion("item_second_cate_cd is not null");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdEqualTo(Integer value) {
            addCriterion("item_second_cate_cd =", value, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdNotEqualTo(Integer value) {
            addCriterion("item_second_cate_cd <>", value, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdGreaterThan(Integer value) {
            addCriterion("item_second_cate_cd >", value, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_second_cate_cd >=", value, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdLessThan(Integer value) {
            addCriterion("item_second_cate_cd <", value, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdLessThanOrEqualTo(Integer value) {
            addCriterion("item_second_cate_cd <=", value, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdIn(List<Integer> values) {
            addCriterion("item_second_cate_cd in", values, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdNotIn(List<Integer> values) {
            addCriterion("item_second_cate_cd not in", values, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdBetween(Integer value1, Integer value2) {
            addCriterion("item_second_cate_cd between", value1, value2, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateCdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_second_cate_cd not between", value1, value2, "itemSecondCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdIsNull() {
            addCriterion("item_third_cate_cd is null");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdIsNotNull() {
            addCriterion("item_third_cate_cd is not null");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdEqualTo(Integer value) {
            addCriterion("item_third_cate_cd =", value, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdNotEqualTo(Integer value) {
            addCriterion("item_third_cate_cd <>", value, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdGreaterThan(Integer value) {
            addCriterion("item_third_cate_cd >", value, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_third_cate_cd >=", value, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdLessThan(Integer value) {
            addCriterion("item_third_cate_cd <", value, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdLessThanOrEqualTo(Integer value) {
            addCriterion("item_third_cate_cd <=", value, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdIn(List<Integer> values) {
            addCriterion("item_third_cate_cd in", values, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdNotIn(List<Integer> values) {
            addCriterion("item_third_cate_cd not in", values, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdBetween(Integer value1, Integer value2) {
            addCriterion("item_third_cate_cd between", value1, value2, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateCdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_third_cate_cd not between", value1, value2, "itemThirdCateCd");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountIsNull() {
            addCriterion("before_prefr_amount is null");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountIsNotNull() {
            addCriterion("before_prefr_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountEqualTo(Double value) {
            addCriterion("before_prefr_amount =", value, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountNotEqualTo(Double value) {
            addCriterion("before_prefr_amount <>", value, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountGreaterThan(Double value) {
            addCriterion("before_prefr_amount >", value, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("before_prefr_amount >=", value, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountLessThan(Double value) {
            addCriterion("before_prefr_amount <", value, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountLessThanOrEqualTo(Double value) {
            addCriterion("before_prefr_amount <=", value, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountIn(List<Double> values) {
            addCriterion("before_prefr_amount in", values, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountNotIn(List<Double> values) {
            addCriterion("before_prefr_amount not in", values, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountBetween(Double value1, Double value2) {
            addCriterion("before_prefr_amount between", value1, value2, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andBeforePrefrAmountNotBetween(Double value1, Double value2) {
            addCriterion("before_prefr_amount not between", value1, value2, "beforePrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountIsNull() {
            addCriterion("after_prefr_amount is null");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountIsNotNull() {
            addCriterion("after_prefr_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountEqualTo(Double value) {
            addCriterion("after_prefr_amount =", value, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountNotEqualTo(Double value) {
            addCriterion("after_prefr_amount <>", value, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountGreaterThan(Double value) {
            addCriterion("after_prefr_amount >", value, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("after_prefr_amount >=", value, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountLessThan(Double value) {
            addCriterion("after_prefr_amount <", value, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountLessThanOrEqualTo(Double value) {
            addCriterion("after_prefr_amount <=", value, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountIn(List<Double> values) {
            addCriterion("after_prefr_amount in", values, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountNotIn(List<Double> values) {
            addCriterion("after_prefr_amount not in", values, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountBetween(Double value1, Double value2) {
            addCriterion("after_prefr_amount between", value1, value2, "afterPrefrAmount");
            return (Criteria) this;
        }

        public Criteria andAfterPrefrAmountNotBetween(Double value1, Double value2) {
            addCriterion("after_prefr_amount not between", value1, value2, "afterPrefrAmount");
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

        public Criteria andStatisticalTimeIsNull() {
            addCriterion("statistical_time is null");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeIsNotNull() {
            addCriterion("statistical_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeEqualTo(Date value) {
            addCriterion("statistical_time =", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeNotEqualTo(Date value) {
            addCriterion("statistical_time <>", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeGreaterThan(Date value) {
            addCriterion("statistical_time >", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("statistical_time >=", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeLessThan(Date value) {
            addCriterion("statistical_time <", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeLessThanOrEqualTo(Date value) {
            addCriterion("statistical_time <=", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeIn(List<Date> values) {
            addCriterion("statistical_time in", values, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeNotIn(List<Date> values) {
            addCriterion("statistical_time not in", values, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeBetween(Date value1, Date value2) {
            addCriterion("statistical_time between", value1, value2, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeNotBetween(Date value1, Date value2) {
            addCriterion("statistical_time not between", value1, value2, "statisticalTime");
            return (Criteria) this;
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

        public Criteria andCpsIdIsNull() {
            addCriterion("cps_id is null");
            return (Criteria) this;
        }

        public Criteria andCpsIdIsNotNull() {
            addCriterion("cps_id is not null");
            return (Criteria) this;
        }

        public Criteria andCpsIdEqualTo(String value) {
            addCriterion("cps_id =", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdNotEqualTo(String value) {
            addCriterion("cps_id <>", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdGreaterThan(String value) {
            addCriterion("cps_id >", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdGreaterThanOrEqualTo(String value) {
            addCriterion("cps_id >=", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdLessThan(String value) {
            addCriterion("cps_id <", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdLessThanOrEqualTo(String value) {
            addCriterion("cps_id <=", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdLike(String value) {
            addCriterion("cps_id like", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdNotLike(String value) {
            addCriterion("cps_id not like", value, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdIn(List<String> values) {
            addCriterion("cps_id in", values, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdNotIn(List<String> values) {
            addCriterion("cps_id not in", values, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdBetween(String value1, String value2) {
            addCriterion("cps_id between", value1, value2, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsIdNotBetween(String value1, String value2) {
            addCriterion("cps_id not between", value1, value2, "cpsId");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmIsNull() {
            addCriterion("cps_valid_begin_tm is null");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmIsNotNull() {
            addCriterion("cps_valid_begin_tm is not null");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmEqualTo(Date value) {
            addCriterion("cps_valid_begin_tm =", value, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmNotEqualTo(Date value) {
            addCriterion("cps_valid_begin_tm <>", value, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmGreaterThan(Date value) {
            addCriterion("cps_valid_begin_tm >", value, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmGreaterThanOrEqualTo(Date value) {
            addCriterion("cps_valid_begin_tm >=", value, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmLessThan(Date value) {
            addCriterion("cps_valid_begin_tm <", value, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmLessThanOrEqualTo(Date value) {
            addCriterion("cps_valid_begin_tm <=", value, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmIn(List<Date> values) {
            addCriterion("cps_valid_begin_tm in", values, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmNotIn(List<Date> values) {
            addCriterion("cps_valid_begin_tm not in", values, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmBetween(Date value1, Date value2) {
            addCriterion("cps_valid_begin_tm between", value1, value2, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidBeginTmNotBetween(Date value1, Date value2) {
            addCriterion("cps_valid_begin_tm not between", value1, value2, "cpsValidBeginTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmIsNull() {
            addCriterion("cps_valid_end_tm is null");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmIsNotNull() {
            addCriterion("cps_valid_end_tm is not null");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmEqualTo(Date value) {
            addCriterion("cps_valid_end_tm =", value, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmNotEqualTo(Date value) {
            addCriterion("cps_valid_end_tm <>", value, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmGreaterThan(Date value) {
            addCriterion("cps_valid_end_tm >", value, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmGreaterThanOrEqualTo(Date value) {
            addCriterion("cps_valid_end_tm >=", value, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmLessThan(Date value) {
            addCriterion("cps_valid_end_tm <", value, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmLessThanOrEqualTo(Date value) {
            addCriterion("cps_valid_end_tm <=", value, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmIn(List<Date> values) {
            addCriterion("cps_valid_end_tm in", values, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmNotIn(List<Date> values) {
            addCriterion("cps_valid_end_tm not in", values, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmBetween(Date value1, Date value2) {
            addCriterion("cps_valid_end_tm between", value1, value2, "cpsValidEndTm");
            return (Criteria) this;
        }

        public Criteria andCpsValidEndTmNotBetween(Date value1, Date value2) {
            addCriterion("cps_valid_end_tm not between", value1, value2, "cpsValidEndTm");
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