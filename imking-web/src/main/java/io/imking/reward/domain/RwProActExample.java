package io.imking.reward.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RwProActExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RwProActExample() {
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

        public Criteria andRwAskIndexEqualTo(Integer value) {
            addCriterion("rw_ask_index =", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexNotEqualTo(Integer value) {
            addCriterion("rw_ask_index <>", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexGreaterThan(Integer value) {
            addCriterion("rw_ask_index >", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("rw_ask_index >=", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexLessThan(Integer value) {
            addCriterion("rw_ask_index <", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexLessThanOrEqualTo(Integer value) {
            addCriterion("rw_ask_index <=", value, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexIn(List<Integer> values) {
            addCriterion("rw_ask_index in", values, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexNotIn(List<Integer> values) {
            addCriterion("rw_ask_index not in", values, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexBetween(Integer value1, Integer value2) {
            addCriterion("rw_ask_index between", value1, value2, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andRwAskIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("rw_ask_index not between", value1, value2, "rwAskIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysIsNull() {
            addCriterion("apply_delay_days is null");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysIsNotNull() {
            addCriterion("apply_delay_days is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysEqualTo(Byte value) {
            addCriterion("apply_delay_days =", value, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysNotEqualTo(Byte value) {
            addCriterion("apply_delay_days <>", value, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysGreaterThan(Byte value) {
            addCriterion("apply_delay_days >", value, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysGreaterThanOrEqualTo(Byte value) {
            addCriterion("apply_delay_days >=", value, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysLessThan(Byte value) {
            addCriterion("apply_delay_days <", value, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysLessThanOrEqualTo(Byte value) {
            addCriterion("apply_delay_days <=", value, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysIn(List<Byte> values) {
            addCriterion("apply_delay_days in", values, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysNotIn(List<Byte> values) {
            addCriterion("apply_delay_days not in", values, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysBetween(Byte value1, Byte value2) {
            addCriterion("apply_delay_days between", value1, value2, "applyDelayDays");
            return (Criteria) this;
        }

        public Criteria andApplyDelayDaysNotBetween(Byte value1, Byte value2) {
            addCriterion("apply_delay_days not between", value1, value2, "applyDelayDays");
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