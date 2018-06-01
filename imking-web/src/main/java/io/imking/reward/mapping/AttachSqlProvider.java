package io.imking.reward.mapping;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

import io.imking.reward.domain.Attach;
import io.imking.reward.domain.AttachExample;
import io.imking.reward.domain.AttachExample.Criteria;
import io.imking.reward.domain.AttachExample.Criterion;

public class AttachSqlProvider {

    public String countByExample(AttachExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("attach");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AttachExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("attach");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Attach record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("attach");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAttachGroup() != null) {
            sql.VALUES("attach_group", "#{attachGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getFileName() != null) {
            sql.VALUES("file_name", "#{fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getFileType() != null) {
            sql.VALUES("file_type", "#{fileType,jdbcType=TINYINT}");
        }
        
        if (record.getSaveName() != null) {
            sql.VALUES("save_name", "#{saveName,jdbcType=VARCHAR}");
        }
        
        if (record.getSavePath() != null) {
            sql.VALUES("save_path", "#{savePath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileDesc() != null) {
            sql.VALUES("file_desc", "#{fileDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            sql.VALUES("size", "#{size,jdbcType=INTEGER}");
        }
        
        if (record.getExtension() != null) {
            sql.VALUES("extension", "#{extension,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.VALUES("update_by", "#{updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AttachExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("attach_group");
        sql.SELECT("file_name");
        sql.SELECT("file_type");
        sql.SELECT("save_name");
        sql.SELECT("save_path");
        sql.SELECT("file_desc");
        sql.SELECT("size");
        sql.SELECT("extension");
        sql.SELECT("create_by");
        sql.SELECT("create_time");
        sql.SELECT("update_by");
        sql.SELECT("update_time");
        sql.FROM("attach");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Attach record = (Attach) parameter.get("record");
        AttachExample example = (AttachExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("attach");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAttachGroup() != null) {
            sql.SET("attach_group = #{record.attachGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getFileName() != null) {
            sql.SET("file_name = #{record.fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getFileType() != null) {
            sql.SET("file_type = #{record.fileType,jdbcType=TINYINT}");
        }
        
        if (record.getSaveName() != null) {
            sql.SET("save_name = #{record.saveName,jdbcType=VARCHAR}");
        }
        
        if (record.getSavePath() != null) {
            sql.SET("save_path = #{record.savePath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileDesc() != null) {
            sql.SET("file_desc = #{record.fileDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            sql.SET("size = #{record.size,jdbcType=INTEGER}");
        }
        
        if (record.getExtension() != null) {
            sql.SET("extension = #{record.extension,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{record.updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("attach");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("attach_group = #{record.attachGroup,jdbcType=VARCHAR}");
        sql.SET("file_name = #{record.fileName,jdbcType=VARCHAR}");
        sql.SET("file_type = #{record.fileType,jdbcType=TINYINT}");
        sql.SET("save_name = #{record.saveName,jdbcType=VARCHAR}");
        sql.SET("save_path = #{record.savePath,jdbcType=VARCHAR}");
        sql.SET("file_desc = #{record.fileDesc,jdbcType=VARCHAR}");
        sql.SET("size = #{record.size,jdbcType=INTEGER}");
        sql.SET("extension = #{record.extension,jdbcType=VARCHAR}");
        sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_by = #{record.updateBy,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        AttachExample example = (AttachExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Attach record) {
        SQL sql = new SQL();
        sql.UPDATE("attach");
        
        if (record.getAttachGroup() != null) {
            sql.SET("attach_group = #{attachGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getFileName() != null) {
            sql.SET("file_name = #{fileName,jdbcType=VARCHAR}");
        }
        
        if (record.getFileType() != null) {
            sql.SET("file_type = #{fileType,jdbcType=TINYINT}");
        }
        
        if (record.getSaveName() != null) {
            sql.SET("save_name = #{saveName,jdbcType=VARCHAR}");
        }
        
        if (record.getSavePath() != null) {
            sql.SET("save_path = #{savePath,jdbcType=VARCHAR}");
        }
        
        if (record.getFileDesc() != null) {
            sql.SET("file_desc = #{fileDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            sql.SET("size = #{size,jdbcType=INTEGER}");
        }
        
        if (record.getExtension() != null) {
            sql.SET("extension = #{extension,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AttachExample example, boolean includeExamplePhrase) {
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