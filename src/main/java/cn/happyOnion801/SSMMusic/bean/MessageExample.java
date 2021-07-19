package cn.happyOnion801.SSMMusic.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMessageidIsNull() {
            addCriterion("messageId is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("messageId is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(Integer value) {
            addCriterion("messageId =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(Integer value) {
            addCriterion("messageId <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(Integer value) {
            addCriterion("messageId >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageId >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(Integer value) {
            addCriterion("messageId <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(Integer value) {
            addCriterion("messageId <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<Integer> values) {
            addCriterion("messageId in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<Integer> values) {
            addCriterion("messageId not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(Integer value1, Integer value2) {
            addCriterion("messageId between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("messageId not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessagecommentIsNull() {
            addCriterion("messageComment is null");
            return (Criteria) this;
        }

        public Criteria andMessagecommentIsNotNull() {
            addCriterion("messageComment is not null");
            return (Criteria) this;
        }

        public Criteria andMessagecommentEqualTo(String value) {
            addCriterion("messageComment =", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentNotEqualTo(String value) {
            addCriterion("messageComment <>", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentGreaterThan(String value) {
            addCriterion("messageComment >", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentGreaterThanOrEqualTo(String value) {
            addCriterion("messageComment >=", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentLessThan(String value) {
            addCriterion("messageComment <", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentLessThanOrEqualTo(String value) {
            addCriterion("messageComment <=", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentLike(String value) {
            addCriterion("messageComment like", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentNotLike(String value) {
            addCriterion("messageComment not like", value, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentIn(List<String> values) {
            addCriterion("messageComment in", values, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentNotIn(List<String> values) {
            addCriterion("messageComment not in", values, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentBetween(String value1, String value2) {
            addCriterion("messageComment between", value1, value2, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagecommentNotBetween(String value1, String value2) {
            addCriterion("messageComment not between", value1, value2, "messagecomment");
            return (Criteria) this;
        }

        public Criteria andMessagetimeIsNull() {
            addCriterion("messageTime is null");
            return (Criteria) this;
        }

        public Criteria andMessagetimeIsNotNull() {
            addCriterion("messageTime is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetimeEqualTo(Date value) {
            addCriterion("messageTime =", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeNotEqualTo(Date value) {
            addCriterion("messageTime <>", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeGreaterThan(Date value) {
            addCriterion("messageTime >", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("messageTime >=", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeLessThan(Date value) {
            addCriterion("messageTime <", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeLessThanOrEqualTo(Date value) {
            addCriterion("messageTime <=", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeIn(List<Date> values) {
            addCriterion("messageTime in", values, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeNotIn(List<Date> values) {
            addCriterion("messageTime not in", values, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeBetween(Date value1, Date value2) {
            addCriterion("messageTime between", value1, value2, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeNotBetween(Date value1, Date value2) {
            addCriterion("messageTime not between", value1, value2, "messagetime");
            return (Criteria) this;
        }

        public Criteria andVideoidIsNull() {
            addCriterion("videoId is null");
            return (Criteria) this;
        }

        public Criteria andVideoidIsNotNull() {
            addCriterion("videoId is not null");
            return (Criteria) this;
        }

        public Criteria andVideoidEqualTo(Integer value) {
            addCriterion("videoId =", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotEqualTo(Integer value) {
            addCriterion("videoId <>", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidGreaterThan(Integer value) {
            addCriterion("videoId >", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("videoId >=", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidLessThan(Integer value) {
            addCriterion("videoId <", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidLessThanOrEqualTo(Integer value) {
            addCriterion("videoId <=", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidIn(List<Integer> values) {
            addCriterion("videoId in", values, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotIn(List<Integer> values) {
            addCriterion("videoId not in", values, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidBetween(Integer value1, Integer value2) {
            addCriterion("videoId between", value1, value2, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotBetween(Integer value1, Integer value2) {
            addCriterion("videoId not between", value1, value2, "videoid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
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