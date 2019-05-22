package com.efunds.pms.riskmanage.model;

import java.util.ArrayList;
import java.util.List;

public class PmsRemindConfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsRemindConfExample() {
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

        public Criteria andSRemindIdIsNull() {
            addCriterion("S_REMIND_ID is null");
            return (Criteria) this;
        }

        public Criteria andSRemindIdIsNotNull() {
            addCriterion("S_REMIND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSRemindIdEqualTo(String value) {
            addCriterion("S_REMIND_ID =", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdNotEqualTo(String value) {
            addCriterion("S_REMIND_ID <>", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdGreaterThan(String value) {
            addCriterion("S_REMIND_ID >", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMIND_ID >=", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdLessThan(String value) {
            addCriterion("S_REMIND_ID <", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdLessThanOrEqualTo(String value) {
            addCriterion("S_REMIND_ID <=", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdLike(String value) {
            addCriterion("S_REMIND_ID like", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdNotLike(String value) {
            addCriterion("S_REMIND_ID not like", value, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdIn(List<String> values) {
            addCriterion("S_REMIND_ID in", values, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdNotIn(List<String> values) {
            addCriterion("S_REMIND_ID not in", values, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdBetween(String value1, String value2) {
            addCriterion("S_REMIND_ID between", value1, value2, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSRemindIdNotBetween(String value1, String value2) {
            addCriterion("S_REMIND_ID not between", value1, value2, "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdIsNull() {
            addCriterion("S_MENU_FULL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdIsNotNull() {
            addCriterion("S_MENU_FULL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdEqualTo(String value) {
            addCriterion("S_MENU_FULL_ID =", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdNotEqualTo(String value) {
            addCriterion("S_MENU_FULL_ID <>", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdGreaterThan(String value) {
            addCriterion("S_MENU_FULL_ID >", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdGreaterThanOrEqualTo(String value) {
            addCriterion("S_MENU_FULL_ID >=", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdLessThan(String value) {
            addCriterion("S_MENU_FULL_ID <", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdLessThanOrEqualTo(String value) {
            addCriterion("S_MENU_FULL_ID <=", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdLike(String value) {
            addCriterion("S_MENU_FULL_ID like", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdNotLike(String value) {
            addCriterion("S_MENU_FULL_ID not like", value, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdIn(List<String> values) {
            addCriterion("S_MENU_FULL_ID in", values, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdNotIn(List<String> values) {
            addCriterion("S_MENU_FULL_ID not in", values, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdBetween(String value1, String value2) {
            addCriterion("S_MENU_FULL_ID between", value1, value2, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdNotBetween(String value1, String value2) {
            addCriterion("S_MENU_FULL_ID not between", value1, value2, "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleIsNull() {
            addCriterion("S_REMIND_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleIsNotNull() {
            addCriterion("S_REMIND_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleEqualTo(String value) {
            addCriterion("S_REMIND_TITLE =", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleNotEqualTo(String value) {
            addCriterion("S_REMIND_TITLE <>", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleGreaterThan(String value) {
            addCriterion("S_REMIND_TITLE >", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TITLE >=", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleLessThan(String value) {
            addCriterion("S_REMIND_TITLE <", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleLessThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TITLE <=", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleLike(String value) {
            addCriterion("S_REMIND_TITLE like", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleNotLike(String value) {
            addCriterion("S_REMIND_TITLE not like", value, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleIn(List<String> values) {
            addCriterion("S_REMIND_TITLE in", values, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleNotIn(List<String> values) {
            addCriterion("S_REMIND_TITLE not in", values, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleBetween(String value1, String value2) {
            addCriterion("S_REMIND_TITLE between", value1, value2, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleNotBetween(String value1, String value2) {
            addCriterion("S_REMIND_TITLE not between", value1, value2, "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemarkIsNull() {
            addCriterion("S_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andSRemarkIsNotNull() {
            addCriterion("S_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andSRemarkEqualTo(String value) {
            addCriterion("S_REMARK =", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotEqualTo(String value) {
            addCriterion("S_REMARK <>", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkGreaterThan(String value) {
            addCriterion("S_REMARK >", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMARK >=", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLessThan(String value) {
            addCriterion("S_REMARK <", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLessThanOrEqualTo(String value) {
            addCriterion("S_REMARK <=", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLike(String value) {
            addCriterion("S_REMARK like", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotLike(String value) {
            addCriterion("S_REMARK not like", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkIn(List<String> values) {
            addCriterion("S_REMARK in", values, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotIn(List<String> values) {
            addCriterion("S_REMARK not in", values, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkBetween(String value1, String value2) {
            addCriterion("S_REMARK between", value1, value2, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotBetween(String value1, String value2) {
            addCriterion("S_REMARK not between", value1, value2, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemindControlIsNull() {
            addCriterion("S_REMIND_CONTROL is null");
            return (Criteria) this;
        }

        public Criteria andSRemindControlIsNotNull() {
            addCriterion("S_REMIND_CONTROL is not null");
            return (Criteria) this;
        }

        public Criteria andSRemindControlEqualTo(String value) {
            addCriterion("S_REMIND_CONTROL =", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlNotEqualTo(String value) {
            addCriterion("S_REMIND_CONTROL <>", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlGreaterThan(String value) {
            addCriterion("S_REMIND_CONTROL >", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMIND_CONTROL >=", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlLessThan(String value) {
            addCriterion("S_REMIND_CONTROL <", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlLessThanOrEqualTo(String value) {
            addCriterion("S_REMIND_CONTROL <=", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlLike(String value) {
            addCriterion("S_REMIND_CONTROL like", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlNotLike(String value) {
            addCriterion("S_REMIND_CONTROL not like", value, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlIn(List<String> values) {
            addCriterion("S_REMIND_CONTROL in", values, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlNotIn(List<String> values) {
            addCriterion("S_REMIND_CONTROL not in", values, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlBetween(String value1, String value2) {
            addCriterion("S_REMIND_CONTROL between", value1, value2, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindControlNotBetween(String value1, String value2) {
            addCriterion("S_REMIND_CONTROL not between", value1, value2, "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsIsNull() {
            addCriterion("S_REMIND_TMPL_SMS is null");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsIsNotNull() {
            addCriterion("S_REMIND_TMPL_SMS is not null");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SMS =", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsNotEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SMS <>", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsGreaterThan(String value) {
            addCriterion("S_REMIND_TMPL_SMS >", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SMS >=", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsLessThan(String value) {
            addCriterion("S_REMIND_TMPL_SMS <", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsLessThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SMS <=", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsLike(String value) {
            addCriterion("S_REMIND_TMPL_SMS like", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsNotLike(String value) {
            addCriterion("S_REMIND_TMPL_SMS not like", value, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsIn(List<String> values) {
            addCriterion("S_REMIND_TMPL_SMS in", values, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsNotIn(List<String> values) {
            addCriterion("S_REMIND_TMPL_SMS not in", values, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsBetween(String value1, String value2) {
            addCriterion("S_REMIND_TMPL_SMS between", value1, value2, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsNotBetween(String value1, String value2) {
            addCriterion("S_REMIND_TMPL_SMS not between", value1, value2, "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailIsNull() {
            addCriterion("S_REMIND_TMPL_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailIsNotNull() {
            addCriterion("S_REMIND_TMPL_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL =", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailNotEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL <>", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailGreaterThan(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL >", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL >=", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailLessThan(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL <", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailLessThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL <=", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailLike(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL like", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailNotLike(String value) {
            addCriterion("S_REMIND_TMPL_EMAIL not like", value, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailIn(List<String> values) {
            addCriterion("S_REMIND_TMPL_EMAIL in", values, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailNotIn(List<String> values) {
            addCriterion("S_REMIND_TMPL_EMAIL not in", values, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailBetween(String value1, String value2) {
            addCriterion("S_REMIND_TMPL_EMAIL between", value1, value2, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailNotBetween(String value1, String value2) {
            addCriterion("S_REMIND_TMPL_EMAIL not between", value1, value2, "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysIsNull() {
            addCriterion("S_REMIND_TMPL_SYS is null");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysIsNotNull() {
            addCriterion("S_REMIND_TMPL_SYS is not null");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SYS =", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysNotEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SYS <>", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysGreaterThan(String value) {
            addCriterion("S_REMIND_TMPL_SYS >", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SYS >=", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysLessThan(String value) {
            addCriterion("S_REMIND_TMPL_SYS <", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysLessThanOrEqualTo(String value) {
            addCriterion("S_REMIND_TMPL_SYS <=", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysLike(String value) {
            addCriterion("S_REMIND_TMPL_SYS like", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysNotLike(String value) {
            addCriterion("S_REMIND_TMPL_SYS not like", value, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysIn(List<String> values) {
            addCriterion("S_REMIND_TMPL_SYS in", values, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysNotIn(List<String> values) {
            addCriterion("S_REMIND_TMPL_SYS not in", values, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysBetween(String value1, String value2) {
            addCriterion("S_REMIND_TMPL_SYS between", value1, value2, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysNotBetween(String value1, String value2) {
            addCriterion("S_REMIND_TMPL_SYS not between", value1, value2, "sRemindTmplSys");
            return (Criteria) this;
        }

        public Criteria andSRemindIdLikeInsensitive(String value) {
            addCriterion("upper(S_REMIND_ID) like", value.toUpperCase(), "sRemindId");
            return (Criteria) this;
        }

        public Criteria andSMenuFullIdLikeInsensitive(String value) {
            addCriterion("upper(S_MENU_FULL_ID) like", value.toUpperCase(), "sMenuFullId");
            return (Criteria) this;
        }

        public Criteria andSRemindTitleLikeInsensitive(String value) {
            addCriterion("upper(S_REMIND_TITLE) like", value.toUpperCase(), "sRemindTitle");
            return (Criteria) this;
        }

        public Criteria andSRemarkLikeInsensitive(String value) {
            addCriterion("upper(S_REMARK) like", value.toUpperCase(), "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemindControlLikeInsensitive(String value) {
            addCriterion("upper(S_REMIND_CONTROL) like", value.toUpperCase(), "sRemindControl");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSmsLikeInsensitive(String value) {
            addCriterion("upper(S_REMIND_TMPL_SMS) like", value.toUpperCase(), "sRemindTmplSms");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplEmailLikeInsensitive(String value) {
            addCriterion("upper(S_REMIND_TMPL_EMAIL) like", value.toUpperCase(), "sRemindTmplEmail");
            return (Criteria) this;
        }

        public Criteria andSRemindTmplSysLikeInsensitive(String value) {
            addCriterion("upper(S_REMIND_TMPL_SYS) like", value.toUpperCase(), "sRemindTmplSys");
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