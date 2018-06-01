package io.imking.reward.mapping;


import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

import io.imking.reward.domain.RwRewardConfirmDetail;
import io.imking.reward.domain.RwRewardConfirmDetailExample;
import io.imking.reward.domain.RwRewardConfirmDetailExample.Criteria;
import io.imking.reward.domain.RwRewardConfirmDetailExample.Criterion;

public class RwRewardConfirmDetailSqlProvider {

    public String countByExample(RwRewardConfirmDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("rw_reward_confirm_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RwRewardConfirmDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("rw_reward_confirm_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RwRewardConfirmDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rw_reward_confirm_detail");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskId() != null) {
            sql.VALUES("rw_ask_id", "#{rwAskId,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskIndex() != null) {
            sql.VALUES("rw_ask_index", "#{rwAskIndex,jdbcType=INTEGER}");
        }
        
        if (record.getFromUserId() != null) {
            sql.VALUES("from_user_id", "#{fromUserId,jdbcType=INTEGER}");
        }
        
        if (record.getToUserId() != null) {
            sql.VALUES("to_user_id", "#{toUserId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("amount", "#{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getReason() != null) {
            sql.VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RwRewardConfirmDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("rw_ask_id");
        sql.SELECT("rw_ask_index");
        sql.SELECT("from_user_id");
        sql.SELECT("to_user_id");
        sql.SELECT("amount");
        sql.SELECT("reason");
        sql.SELECT("create_time");
        sql.FROM("rw_reward_confirm_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RwRewardConfirmDetail record = (RwRewardConfirmDetail) parameter.get("record");
        RwRewardConfirmDetailExample example = (RwRewardConfirmDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("rw_reward_confirm_detail");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskId() != null) {
            sql.SET("rw_ask_id = #{record.rwAskId,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskIndex() != null) {
            sql.SET("rw_ask_index = #{record.rwAskIndex,jdbcType=INTEGER}");
        }
        
        if (record.getFromUserId() != null) {
            sql.SET("from_user_id = #{record.fromUserId,jdbcType=INTEGER}");
        }
        
        if (record.getToUserId() != null) {
            sql.SET("to_user_id = #{record.toUserId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{record.amount,jdbcType=DECIMAL}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("rw_reward_confirm_detail");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("rw_ask_id = #{record.rwAskId,jdbcType=INTEGER}");
        sql.SET("rw_ask_index = #{record.rwAskIndex,jdbcType=INTEGER}");
        sql.SET("from_user_id = #{record.fromUserId,jdbcType=INTEGER}");
        sql.SET("to_user_id = #{record.toUserId,jdbcType=INTEGER}");
        sql.SET("amount = #{record.amount,jdbcType=DECIMAL}");
        sql.SET("reason = #{record.reason,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        RwRewardConfirmDetailExample example = (RwRewardConfirmDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RwRewardConfirmDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("rw_reward_confirm_detail");
        
        if (record.getRwAskId() != null) {
            sql.SET("rw_ask_id = #{rwAskId,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskIndex() != null) {
            sql.SET("rw_ask_index = #{rwAskIndex,jdbcType=INTEGER}");
        }
        
        if (record.getFromUserId() != null) {
            sql.SET("from_user_id = #{fromUserId,jdbcType=INTEGER}");
        }
        
        if (record.getToUserId() != null) {
            sql.SET("to_user_id = #{toUserId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getReason() != null) {
            sql.SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RwRewardConfirmDetailExample example, boolean includeExamplePhrase) {
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