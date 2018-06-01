package io.imking.reward.mapping;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

import io.imking.reward.domain.ImkUserAccountDetail;
import io.imking.reward.domain.ImkUserAccountDetailExample;
import io.imking.reward.domain.ImkUserAccountDetailExample.Criteria;
import io.imking.reward.domain.ImkUserAccountDetailExample.Criterion;

public class ImkUserAccountDetailSqlProvider {

    public String countByExample(ImkUserAccountDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("imk_user_account_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ImkUserAccountDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("imk_user_account_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ImkUserAccountDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("imk_user_account_detail");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("amount", "#{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getBalance() != null) {
            sql.VALUES("balance", "#{balance,jdbcType=DECIMAL}");
        }
        
        if (record.getPayMethod() != null) {
            sql.VALUES("pay_method", "#{payMethod,jdbcType=TINYINT}");
        }
        
        if (record.getPayJustify() != null) {
            sql.VALUES("pay_justify", "#{payJustify,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.VALUES("verify_time", "#{verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getManagerId() != null) {
            sql.VALUES("manager_id", "#{managerId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getTaskId() != null) {
            sql.VALUES("task_id", "#{taskId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ImkUserAccountDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("amount");
        sql.SELECT("balance");
        sql.SELECT("pay_method");
        sql.SELECT("pay_justify");
        sql.SELECT("create_time");
        sql.SELECT("verify_time");
        sql.SELECT("remark");
        sql.SELECT("manager_id");
        sql.SELECT("status");
        sql.SELECT("task_id");
        sql.FROM("imk_user_account_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ImkUserAccountDetail record = (ImkUserAccountDetail) parameter.get("record");
        ImkUserAccountDetailExample example = (ImkUserAccountDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("imk_user_account_detail");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{record.amount,jdbcType=DECIMAL}");
        }
        
        if (record.getBalance() != null) {
            sql.SET("balance = #{record.balance,jdbcType=DECIMAL}");
        }
        
        if (record.getPayMethod() != null) {
            sql.SET("pay_method = #{record.payMethod,jdbcType=TINYINT}");
        }
        
        if (record.getPayJustify() != null) {
            sql.SET("pay_justify = #{record.payJustify,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.SET("verify_time = #{record.verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getManagerId() != null) {
            sql.SET("manager_id = #{record.managerId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("imk_user_account_detail");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        sql.SET("amount = #{record.amount,jdbcType=DECIMAL}");
        sql.SET("balance = #{record.balance,jdbcType=DECIMAL}");
        sql.SET("pay_method = #{record.payMethod,jdbcType=TINYINT}");
        sql.SET("pay_justify = #{record.payJustify,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_time = #{record.verifyTime,jdbcType=TIMESTAMP}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("manager_id = #{record.managerId,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("task_id = #{record.taskId,jdbcType=BIGINT}");
        
        ImkUserAccountDetailExample example = (ImkUserAccountDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ImkUserAccountDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("imk_user_account_detail");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getBalance() != null) {
            sql.SET("balance = #{balance,jdbcType=DECIMAL}");
        }
        
        if (record.getPayMethod() != null) {
            sql.SET("pay_method = #{payMethod,jdbcType=TINYINT}");
        }
        
        if (record.getPayJustify() != null) {
            sql.SET("pay_justify = #{payJustify,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.SET("verify_time = #{verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getManagerId() != null) {
            sql.SET("manager_id = #{managerId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{taskId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ImkUserAccountDetailExample example, boolean includeExamplePhrase) {
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