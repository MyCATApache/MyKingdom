package io.imking.reward.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RwAskProgressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RwAskProgressExample() {
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeIsNull() {
            addCriterion("deadline_time is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeIsNotNull() {
            addCriterion("deadline_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeEqualTo(Date value) {
            addCriterion("deadline_time =", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeNotEqualTo(Date value) {
            addCriterion("deadline_time <>", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeGreaterThan(Date value) {
            addCriterion("deadline_time >", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline_time >=", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeLessThan(Date value) {
            addCriterion("deadline_time <", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeLessThanOrEqualTo(Date value) {
            addCriterion("deadline_time <=", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeIn(List<Date> values) {
            addCriterion("deadline_time in", values, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeNotIn(List<Date> values) {
            addCriterion("deadline_time not in", values, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeBetween(Date value1, Date value2) {
            addCriterion("deadline_time between", value1, value2, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeNotBetween(Date value1, Date value2) {
            addCriterion("deadline_time not between", value1, value2, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNull() {
            addCriterion("actual_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNotNull() {
            addCriterion("actual_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeEqualTo(Date value) {
            addCriterion("actual_end_time =", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotEqualTo(Date value) {
            addCriterion("actual_end_time <>", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThan(Date value) {
            addCriterion("actual_end_time >", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_end_time >=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThan(Date value) {
            addCriterion("actual_end_time <", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_end_time <=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIn(List<Date> values) {
            addCriterion("actual_end_time in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotIn(List<Date> values) {
            addCriterion("actual_end_time not in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeBetween(Date value1, Date value2) {
            addCriterion("actual_end_time between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_end_time not between", value1, value2, "actualEndTime");
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