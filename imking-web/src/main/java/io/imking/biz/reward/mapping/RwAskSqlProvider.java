package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskExample.Criteria;
import io.imking.biz.reward.domain.RwAskExample.Criterion;
import io.imking.biz.reward.domain.RwAskExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RwAskSqlProvider {

    public String countByExample(RwAskExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("rw_ask");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RwAskExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("rw_ask");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RwAsk record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rw_ask");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskIndex() != null) {
            sql.VALUES("rw_ask_index", "#{rwAskIndex,jdbcType=TINYINT}");
        }
        
        if (record.getCurrentAnswerUserId() != null) {
            sql.VALUES("current_answer_user_id", "#{currentAnswerUserId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachGroup() != null) {
            sql.VALUES("attach_group", "#{attachGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getIsTop() != null) {
            sql.VALUES("is_top", "#{isTop,jdbcType=BIT}");
        }
        
        if (record.getTopAmount() != null) {
            sql.VALUES("top_amount", "#{topAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTopExpirationDate() != null) {
            sql.VALUES("top_expiration_date", "#{topExpirationDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskAmount() != null) {
            sql.VALUES("task_amount", "#{taskAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCrowdfundingAmount() != null) {
            sql.VALUES("crowdfunding_amount", "#{crowdfundingAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getStatusChangeTime() != null) {
            sql.VALUES("status_change_time", "#{statusChangeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RwAskExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("rw_ask_index");
        sql.SELECT("current_answer_user_id");
        sql.SELECT("type");
        sql.SELECT("title");
        sql.SELECT("content");
        sql.SELECT("attach_group");
        sql.SELECT("is_top");
        sql.SELECT("top_amount");
        sql.SELECT("top_expiration_date");
        sql.SELECT("task_amount");
        sql.SELECT("crowdfunding_amount");
        sql.SELECT("status");
        sql.SELECT("status_change_time");
        sql.SELECT("create_by");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("rw_ask");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RwAsk record = (RwAsk) parameter.get("record");
        RwAskExample example = (RwAskExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("rw_ask");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskIndex() != null) {
            sql.SET("rw_ask_index = #{record.rwAskIndex,jdbcType=TINYINT}");
        }
        
        if (record.getCurrentAnswerUserId() != null) {
            sql.SET("current_answer_user_id = #{record.currentAnswerUserId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=TINYINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachGroup() != null) {
            sql.SET("attach_group = #{record.attachGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getIsTop() != null) {
            sql.SET("is_top = #{record.isTop,jdbcType=BIT}");
        }
        
        if (record.getTopAmount() != null) {
            sql.SET("top_amount = #{record.topAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTopExpirationDate() != null) {
            sql.SET("top_expiration_date = #{record.topExpirationDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskAmount() != null) {
            sql.SET("task_amount = #{record.taskAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCrowdfundingAmount() != null) {
            sql.SET("crowdfunding_amount = #{record.crowdfundingAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getStatusChangeTime() != null) {
            sql.SET("status_change_time = #{record.statusChangeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("rw_ask");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("rw_ask_index = #{record.rwAskIndex,jdbcType=TINYINT}");
        sql.SET("current_answer_user_id = #{record.currentAnswerUserId,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=TINYINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("attach_group = #{record.attachGroup,jdbcType=VARCHAR}");
        sql.SET("is_top = #{record.isTop,jdbcType=BIT}");
        sql.SET("top_amount = #{record.topAmount,jdbcType=DECIMAL}");
        sql.SET("top_expiration_date = #{record.topExpirationDate,jdbcType=TIMESTAMP}");
        sql.SET("task_amount = #{record.taskAmount,jdbcType=DECIMAL}");
        sql.SET("crowdfunding_amount = #{record.crowdfundingAmount,jdbcType=DECIMAL}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("status_change_time = #{record.statusChangeTime,jdbcType=TIMESTAMP}");
        sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        RwAskExample example = (RwAskExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RwAsk record) {
        SQL sql = new SQL();
        sql.UPDATE("rw_ask");
        
        if (record.getRwAskIndex() != null) {
            sql.SET("rw_ask_index = #{rwAskIndex,jdbcType=TINYINT}");
        }
        
        if (record.getCurrentAnswerUserId() != null) {
            sql.SET("current_answer_user_id = #{currentAnswerUserId,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getAttachGroup() != null) {
            sql.SET("attach_group = #{attachGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getIsTop() != null) {
            sql.SET("is_top = #{isTop,jdbcType=BIT}");
        }
        
        if (record.getTopAmount() != null) {
            sql.SET("top_amount = #{topAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTopExpirationDate() != null) {
            sql.SET("top_expiration_date = #{topExpirationDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskAmount() != null) {
            sql.SET("task_amount = #{taskAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCrowdfundingAmount() != null) {
            sql.SET("crowdfunding_amount = #{crowdfundingAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getStatusChangeTime() != null) {
            sql.SET("status_change_time = #{statusChangeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RwAskExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}