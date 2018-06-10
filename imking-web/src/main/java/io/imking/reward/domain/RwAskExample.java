package io.imking.reward.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RwAskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RwAskExample() {
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

        public Criteria andCurrentAnswerUserIdIsNull() {
            addCriterion("current_answer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdIsNotNull() {
            addCriterion("current_answer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdEqualTo(Integer value) {
            addCriterion("current_answer_user_id =", value, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdNotEqualTo(Integer value) {
            addCriterion("current_answer_user_id <>", value, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdGreaterThan(Integer value) {
            addCriterion("current_answer_user_id >", value, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_answer_user_id >=", value, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdLessThan(Integer value) {
            addCriterion("current_answer_user_id <", value, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("current_answer_user_id <=", value, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdIn(List<Integer> values) {
            addCriterion("current_answer_user_id in", values, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdNotIn(List<Integer> values) {
            addCriterion("current_answer_user_id not in", values, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdBetween(Integer value1, Integer value2) {
            addCriterion("current_answer_user_id between", value1, value2, "currentAnswerUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAnswerUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("current_answer_user_id not between", value1, value2, "currentAnswerUserId");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAttachGroupIsNull() {
            addCriterion("attach_group is null");
            return (Criteria) this;
        }

        public Criteria andAttachGroupIsNotNull() {
            addCriterion("attach_group is not null");
            return (Criteria) this;
        }

        public Criteria andAttachGroupEqualTo(String value) {
            addCriterion("attach_group =", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNotEqualTo(String value) {
            addCriterion("attach_group <>", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupGreaterThan(String value) {
            addCriterion("attach_group >", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupGreaterThanOrEqualTo(String value) {
            addCriterion("attach_group >=", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupLessThan(String value) {
            addCriterion("attach_group <", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupLessThanOrEqualTo(String value) {
            addCriterion("attach_group <=", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupLike(String value) {
            addCriterion("attach_group like", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNotLike(String value) {
            addCriterion("attach_group not like", value, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupIn(List<String> values) {
            addCriterion("attach_group in", values, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNotIn(List<String> values) {
            addCriterion("attach_group not in", values, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupBetween(String value1, String value2) {
            addCriterion("attach_group between", value1, value2, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNotBetween(String value1, String value2) {
            addCriterion("attach_group not between", value1, value2, "attachGroup");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNull() {
            addCriterion("is_top is null");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNotNull() {
            addCriterion("is_top is not null");
            return (Criteria) this;
        }

        public Criteria andIsTopEqualTo(Boolean value) {
            addCriterion("is_top =", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotEqualTo(Boolean value) {
            addCriterion("is_top <>", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThan(Boolean value) {
            addCriterion("is_top >", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_top >=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThan(Boolean value) {
            addCriterion("is_top <", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThanOrEqualTo(Boolean value) {
            addCriterion("is_top <=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopIn(List<Boolean> values) {
            addCriterion("is_top in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotIn(List<Boolean> values) {
            addCriterion("is_top not in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopBetween(Boolean value1, Boolean value2) {
            addCriterion("is_top between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_top not between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andTopAmountIsNull() {
            addCriterion("top_amount is null");
            return (Criteria) this;
        }

        public Criteria andTopAmountIsNotNull() {
            addCriterion("top_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTopAmountEqualTo(Integer value) {
            addCriterion("top_amount =", value, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountNotEqualTo(Integer value) {
            addCriterion("top_amount <>", value, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountGreaterThan(Integer value) {
            addCriterion("top_amount >", value, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("top_amount >=", value, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountLessThan(Integer value) {
            addCriterion("top_amount <", value, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountLessThanOrEqualTo(Integer value) {
            addCriterion("top_amount <=", value, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountIn(List<Integer> values) {
            addCriterion("top_amount in", values, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountNotIn(List<Integer> values) {
            addCriterion("top_amount not in", values, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountBetween(Integer value1, Integer value2) {
            addCriterion("top_amount between", value1, value2, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("top_amount not between", value1, value2, "topAmount");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateIsNull() {
            addCriterion("top_expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateIsNotNull() {
            addCriterion("top_expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateEqualTo(Date value) {
            addCriterion("top_expiration_date =", value, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateNotEqualTo(Date value) {
            addCriterion("top_expiration_date <>", value, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateGreaterThan(Date value) {
            addCriterion("top_expiration_date >", value, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("top_expiration_date >=", value, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateLessThan(Date value) {
            addCriterion("top_expiration_date <", value, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("top_expiration_date <=", value, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateIn(List<Date> values) {
            addCriterion("top_expiration_date in", values, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateNotIn(List<Date> values) {
            addCriterion("top_expiration_date not in", values, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateBetween(Date value1, Date value2) {
            addCriterion("top_expiration_date between", value1, value2, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTopExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("top_expiration_date not between", value1, value2, "topExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTaskAmountIsNull() {
            addCriterion("task_amount is null");
            return (Criteria) this;
        }

        public Criteria andTaskAmountIsNotNull() {
            addCriterion("task_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAmountEqualTo(Integer value) {
            addCriterion("task_amount =", value, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountNotEqualTo(Integer value) {
            addCriterion("task_amount <>", value, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountGreaterThan(Integer value) {
            addCriterion("task_amount >", value, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_amount >=", value, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountLessThan(Integer value) {
            addCriterion("task_amount <", value, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountLessThanOrEqualTo(Integer value) {
            addCriterion("task_amount <=", value, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountIn(List<Integer> values) {
            addCriterion("task_amount in", values, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountNotIn(List<Integer> values) {
            addCriterion("task_amount not in", values, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountBetween(Integer value1, Integer value2) {
            addCriterion("task_amount between", value1, value2, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andTaskAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("task_amount not between", value1, value2, "taskAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountIsNull() {
            addCriterion("crowdfunding_amount is null");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountIsNotNull() {
            addCriterion("crowdfunding_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountEqualTo(Integer value) {
            addCriterion("crowdfunding_amount =", value, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountNotEqualTo(Integer value) {
            addCriterion("crowdfunding_amount <>", value, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountGreaterThan(Integer value) {
            addCriterion("crowdfunding_amount >", value, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("crowdfunding_amount >=", value, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountLessThan(Integer value) {
            addCriterion("crowdfunding_amount <", value, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountLessThanOrEqualTo(Integer value) {
            addCriterion("crowdfunding_amount <=", value, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountIn(List<Integer> values) {
            addCriterion("crowdfunding_amount in", values, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountNotIn(List<Integer> values) {
            addCriterion("crowdfunding_amount not in", values, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountBetween(Integer value1, Integer value2) {
            addCriterion("crowdfunding_amount between", value1, value2, "crowdfundingAmount");
            return (Criteria) this;
        }

        public Criteria andCrowdfundingAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("crowdfunding_amount not between", value1, value2, "crowdfundingAmount");
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

        public Criteria andStatusChangeTimeIsNull() {
            addCriterion("status_change_time is null");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeIsNotNull() {
            addCriterion("status_change_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeEqualTo(Date value) {
            addCriterion("status_change_time =", value, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeNotEqualTo(Date value) {
            addCriterion("status_change_time <>", value, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeGreaterThan(Date value) {
            addCriterion("status_change_time >", value, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("status_change_time >=", value, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeLessThan(Date value) {
            addCriterion("status_change_time <", value, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("status_change_time <=", value, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeIn(List<Date> values) {
            addCriterion("status_change_time in", values, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeNotIn(List<Date> values) {
            addCriterion("status_change_time not in", values, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeBetween(Date value1, Date value2) {
            addCriterion("status_change_time between", value1, value2, "statusChangeTime");
            return (Criteria) this;
        }

        public Criteria andStatusChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("status_change_time not between", value1, value2, "statusChangeTime");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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