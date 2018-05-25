package io.imking.biz.reward.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RwAskEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RwAskEvaluateExample() {
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

        public Criteria andRwAskIdIsNull() {
            addCriterion("rw_ask_id is null");
            return (Criteria) this;
        }

        public Criteria andRwAskIdIsNotNull() {
            addCriterion("rw_ask_id is not null");
            return (Criteria) this;
        }

        public Criteria andRwAskIdEqualTo(Integer value) {
            addCriterion("rw_ask_id =", value, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdNotEqualTo(Integer value) {
            addCriterion("rw_ask_id <>", value, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdGreaterThan(Integer value) {
            addCriterion("rw_ask_id >", value, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rw_ask_id >=", value, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdLessThan(Integer value) {
            addCriterion("rw_ask_id <", value, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdLessThanOrEqualTo(Integer value) {
            addCriterion("rw_ask_id <=", value, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdIn(List<Integer> values) {
            addCriterion("rw_ask_id in", values, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdNotIn(List<Integer> values) {
            addCriterion("rw_ask_id not in", values, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdBetween(Integer value1, Integer value2) {
            addCriterion("rw_ask_id between", value1, value2, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rw_ask_id not between", value1, value2, "rwAskId");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexIsNull() {
            addCriterion("rw_ask_index is null");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexIsNotNull() {
            addCriterion("rw_ask_index is not null");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexEqualTo(Byte value) {
            addCriterion("rw_ask_index =", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexNotEqualTo(Byte value) {
            addCriterion("rw_ask_index <>", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexGreaterThan(Byte value) {
            addCriterion("rw_ask_index >", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexGreaterThanOrEqualTo(Byte value) {
            addCriterion("rw_ask_index >=", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexLessThan(Byte value) {
            addCriterion("rw_ask_index <", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexLessThanOrEqualTo(Byte value) {
            addCriterion("rw_ask_index <=", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexIn(List<Byte> values) {
            addCriterion("rw_ask_index in", values, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexNotIn(List<Byte> values) {
            addCriterion("rw_ask_index not in", values, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexBetween(Byte value1, Byte value2) {
            addCriterion("rw_ask_index between", value1, value2, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexNotBetween(Byte value1, Byte value2) {
            addCriterion("rw_ask_index not between", value1, value2, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdIsNull() {
            addCriterion("evaluate_user_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdIsNotNull() {
            addCriterion("evaluate_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdEqualTo(Integer value) {
            addCriterion("evaluate_user_id =", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdNotEqualTo(Integer value) {
            addCriterion("evaluate_user_id <>", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdGreaterThan(Integer value) {
            addCriterion("evaluate_user_id >", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_user_id >=", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdLessThan(Integer value) {
            addCriterion("evaluate_user_id <", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_user_id <=", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdIn(List<Integer> values) {
            addCriterion("evaluate_user_id in", values, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdNotIn(List<Integer> values) {
            addCriterion("evaluate_user_id not in", values, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_user_id between", value1, value2, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_user_id not between", value1, value2, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdIsNull() {
            addCriterion("user_evaluate_dimension_id is null");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdIsNotNull() {
            addCriterion("user_evaluate_dimension_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdEqualTo(Integer value) {
            addCriterion("user_evaluate_dimension_id =", value, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdNotEqualTo(Integer value) {
            addCriterion("user_evaluate_dimension_id <>", value, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdGreaterThan(Integer value) {
            addCriterion("user_evaluate_dimension_id >", value, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_evaluate_dimension_id >=", value, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdLessThan(Integer value) {
            addCriterion("user_evaluate_dimension_id <", value, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_evaluate_dimension_id <=", value, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdIn(List<Integer> values) {
            addCriterion("user_evaluate_dimension_id in", values, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdNotIn(List<Integer> values) {
            addCriterion("user_evaluate_dimension_id not in", values, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdBetween(Integer value1, Integer value2) {
            addCriterion("user_evaluate_dimension_id between", value1, value2, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andUserEvaluateDimensionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_evaluate_dimension_id not between", value1, value2, "userEvaluateDimensionId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Byte value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Byte value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Byte value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Byte value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Byte value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Byte> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Byte> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Byte value1, Byte value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
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