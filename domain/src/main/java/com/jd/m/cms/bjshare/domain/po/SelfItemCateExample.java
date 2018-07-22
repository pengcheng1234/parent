package com.jd.m.cms.bjshare.domain.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelfItemCateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelfItemCateExample() {
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

        public Criteria andSalerErpAcctIsNull() {
            addCriterion("saler_erp_acct is null");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctIsNotNull() {
            addCriterion("saler_erp_acct is not null");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctEqualTo(String value) {
            addCriterion("saler_erp_acct =", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctNotEqualTo(String value) {
            addCriterion("saler_erp_acct <>", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctGreaterThan(String value) {
            addCriterion("saler_erp_acct >", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctGreaterThanOrEqualTo(String value) {
            addCriterion("saler_erp_acct >=", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctLessThan(String value) {
            addCriterion("saler_erp_acct <", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctLessThanOrEqualTo(String value) {
            addCriterion("saler_erp_acct <=", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctLike(String value) {
            addCriterion("saler_erp_acct like", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctNotLike(String value) {
            addCriterion("saler_erp_acct not like", value, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctIn(List<String> values) {
            addCriterion("saler_erp_acct in", values, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctNotIn(List<String> values) {
            addCriterion("saler_erp_acct not in", values, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctBetween(String value1, String value2) {
            addCriterion("saler_erp_acct between", value1, value2, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSalerErpAcctNotBetween(String value1, String value2) {
            addCriterion("saler_erp_acct not between", value1, value2, "salerErpAcct");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameIsNull() {
            addCriterion("sale_staf_name is null");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameIsNotNull() {
            addCriterion("sale_staf_name is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameEqualTo(String value) {
            addCriterion("sale_staf_name =", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameNotEqualTo(String value) {
            addCriterion("sale_staf_name <>", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameGreaterThan(String value) {
            addCriterion("sale_staf_name >", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameGreaterThanOrEqualTo(String value) {
            addCriterion("sale_staf_name >=", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameLessThan(String value) {
            addCriterion("sale_staf_name <", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameLessThanOrEqualTo(String value) {
            addCriterion("sale_staf_name <=", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameLike(String value) {
            addCriterion("sale_staf_name like", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameNotLike(String value) {
            addCriterion("sale_staf_name not like", value, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameIn(List<String> values) {
            addCriterion("sale_staf_name in", values, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameNotIn(List<String> values) {
            addCriterion("sale_staf_name not in", values, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameBetween(String value1, String value2) {
            addCriterion("sale_staf_name between", value1, value2, "saleStafName");
            return (Criteria) this;
        }

        public Criteria andSaleStafNameNotBetween(String value1, String value2) {
            addCriterion("sale_staf_name not between", value1, value2, "saleStafName");
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

        public Criteria andItemFirstCateNameIsNull() {
            addCriterion("item_first_cate_name is null");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameIsNotNull() {
            addCriterion("item_first_cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameEqualTo(String value) {
            addCriterion("item_first_cate_name =", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameNotEqualTo(String value) {
            addCriterion("item_first_cate_name <>", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameGreaterThan(String value) {
            addCriterion("item_first_cate_name >", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_first_cate_name >=", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameLessThan(String value) {
            addCriterion("item_first_cate_name <", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameLessThanOrEqualTo(String value) {
            addCriterion("item_first_cate_name <=", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameLike(String value) {
            addCriterion("item_first_cate_name like", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameNotLike(String value) {
            addCriterion("item_first_cate_name not like", value, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameIn(List<String> values) {
            addCriterion("item_first_cate_name in", values, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameNotIn(List<String> values) {
            addCriterion("item_first_cate_name not in", values, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameBetween(String value1, String value2) {
            addCriterion("item_first_cate_name between", value1, value2, "itemFirstCateName");
            return (Criteria) this;
        }

        public Criteria andItemFirstCateNameNotBetween(String value1, String value2) {
            addCriterion("item_first_cate_name not between", value1, value2, "itemFirstCateName");
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

        public Criteria andItemSecondCateNameIsNull() {
            addCriterion("item_second_cate_name is null");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameIsNotNull() {
            addCriterion("item_second_cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameEqualTo(String value) {
            addCriterion("item_second_cate_name =", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameNotEqualTo(String value) {
            addCriterion("item_second_cate_name <>", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameGreaterThan(String value) {
            addCriterion("item_second_cate_name >", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_second_cate_name >=", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameLessThan(String value) {
            addCriterion("item_second_cate_name <", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameLessThanOrEqualTo(String value) {
            addCriterion("item_second_cate_name <=", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameLike(String value) {
            addCriterion("item_second_cate_name like", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameNotLike(String value) {
            addCriterion("item_second_cate_name not like", value, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameIn(List<String> values) {
            addCriterion("item_second_cate_name in", values, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameNotIn(List<String> values) {
            addCriterion("item_second_cate_name not in", values, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameBetween(String value1, String value2) {
            addCriterion("item_second_cate_name between", value1, value2, "itemSecondCateName");
            return (Criteria) this;
        }

        public Criteria andItemSecondCateNameNotBetween(String value1, String value2) {
            addCriterion("item_second_cate_name not between", value1, value2, "itemSecondCateName");
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

        public Criteria andItemThirdCateNameIsNull() {
            addCriterion("item_third_cate_name is null");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameIsNotNull() {
            addCriterion("item_third_cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameEqualTo(String value) {
            addCriterion("item_third_cate_name =", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameNotEqualTo(String value) {
            addCriterion("item_third_cate_name <>", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameGreaterThan(String value) {
            addCriterion("item_third_cate_name >", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_third_cate_name >=", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameLessThan(String value) {
            addCriterion("item_third_cate_name <", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameLessThanOrEqualTo(String value) {
            addCriterion("item_third_cate_name <=", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameLike(String value) {
            addCriterion("item_third_cate_name like", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameNotLike(String value) {
            addCriterion("item_third_cate_name not like", value, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameIn(List<String> values) {
            addCriterion("item_third_cate_name in", values, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameNotIn(List<String> values) {
            addCriterion("item_third_cate_name not in", values, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameBetween(String value1, String value2) {
            addCriterion("item_third_cate_name between", value1, value2, "itemThirdCateName");
            return (Criteria) this;
        }

        public Criteria andItemThirdCateNameNotBetween(String value1, String value2) {
            addCriterion("item_third_cate_name not between", value1, value2, "itemThirdCateName");
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