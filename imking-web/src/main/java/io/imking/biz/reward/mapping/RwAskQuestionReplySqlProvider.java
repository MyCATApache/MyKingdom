package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAskQuestionReply;
import io.imking.biz.reward.domain.RwAskQuestionReplyExample.Criteria;
import io.imking.biz.reward.domain.RwAskQuestionReplyExample.Criterion;
import io.imking.biz.reward.domain.RwAskQuestionReplyExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RwAskQuestionReplySqlProvider {

    public String countByExample(RwAskQuestionReplyExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("rw_ask_question_reply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RwAskQuestionReplyExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("rw_ask_question_reply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RwAskQuestionReply record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rw_ask_question_reply");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskQuestionId() != null) {
            sql.VALUES("rw_ask_question_id", "#{rwAskQuestionId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyContent() != null) {
            sql.VALUES("reply_content", "#{replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RwAskQuestionReplyExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("rw_ask_question_id");
        sql.SELECT("reply_content");
        sql.SELECT("create_by");
        sql.SELECT("create_time");
        sql.FROM("rw_ask_question_reply");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }
    
    /**
     * 关联红包任务
     * @param example
     * @return String
     * @author 天道
     */
    public String selectRelationByExample(RwAskQuestionReplyExample example) {
        SQL sql = new SQL();
        sql.SELECT("rw_ask.id");
        sql.SELECT("rw_ask.rw_ask_index");
        sql.SELECT("rw_ask.current_answer_user_id");
        sql.SELECT("rw_ask.type");
        sql.SELECT("rw_ask.title");
        sql.SELECT("rw_ask.content");
        sql.SELECT("rw_ask.attach_group");
        sql.SELECT("rw_ask.is_top");
        sql.SELECT("rw_ask.top_amount");
        sql.SELECT("rw_ask.top_expiration_date");
        sql.SELECT("rw_ask.task_amount");
        sql.SELECT("rw_ask.crowdfunding_amount");
        sql.SELECT("rw_ask.status");
        sql.SELECT("rw_ask.status_change_time");
        sql.SELECT("rw_ask.create_by");
        sql.SELECT("rw_ask.create_time");
        sql.SELECT("rw_ask.update_time");
        sql.FROM("rw_ask_question_reply");
        sql.INNER_JOIN("rw_ask_question"); 
        sql.WHERE("rw_ask_question_reply.rw_ask_question_id=rw_ask_question.id");
        sql.INNER_JOIN("rw_ask");        
        sql.WHERE("rw_ask_question.rw_ask_id=rw_ask.id");
        sql.GROUP_BY("rw_ask.id");
        return sql.toString();
    }
    
    public String updateByExampleSelective(Map<String, Object> parameter) {
        RwAskQuestionReply record = (RwAskQuestionReply) parameter.get("record");
        RwAskQuestionReplyExample example = (RwAskQuestionReplyExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("rw_ask_question_reply");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getRwAskQuestionId() != null) {
            sql.SET("rw_ask_question_id = #{record.rwAskQuestionId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyContent() != null) {
            sql.SET("reply_content = #{record.replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("rw_ask_question_reply");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("rw_ask_question_id = #{record.rwAskQuestionId,jdbcType=INTEGER}");
        sql.SET("reply_content = #{record.replyContent,jdbcType=VARCHAR}");
        sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        RwAskQuestionReplyExample example = (RwAskQuestionReplyExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RwAskQuestionReply record) {
        SQL sql = new SQL();
        sql.UPDATE("rw_ask_question_reply");
        
        if (record.getRwAskQuestionId() != null) {
            sql.SET("rw_ask_question_id = #{rwAskQuestionId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyContent() != null) {
            sql.SET("reply_content = #{replyContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RwAskQuestionReplyExample example, boolean includeExamplePhrase) {
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