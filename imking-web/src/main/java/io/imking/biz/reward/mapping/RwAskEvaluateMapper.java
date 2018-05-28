package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskEvaluate;
import io.imking.biz.reward.domain.RwAskEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface RwAskEvaluateMapper {
    @SelectProvider(type=RwAskEvaluateSqlProvider.class, method="countByExample")
    long countByExample(RwAskEvaluateExample example);

    @DeleteProvider(type=RwAskEvaluateSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskEvaluateExample example);

    @Insert({
        "insert into rw_ask_evaluate (id, rw_ask_id, ",
        "rw_ask_index, evaluate_user_id, ",
        "user_evaluate_dimension_id, score, ",
        "create_by, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=TINYINT}, #{evaluateUserId,jdbcType=INTEGER}, ",
        "#{userEvaluateDimensionId,jdbcType=INTEGER}, #{score,jdbcType=TINYINT}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAskEvaluate record);

    @InsertProvider(type=RwAskEvaluateSqlProvider.class, method="insertSelective")
    int insertSelective(RwAskEvaluate record);

    @SelectProvider(type=RwAskEvaluateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="evaluate_user_id", property="evaluateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_evaluate_dimension_id", property="userEvaluateDimensionId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAskEvaluate> selectByExample(RwAskEvaluateExample example);
    
    /**
     * 关联红包任务
     * @param example
     * @return List<RwAsk> 
     * @author 天道
     */
    @SelectProvider(type=RwAskEvaluateSqlProvider.class, method="selectRelationByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="current_answer_user_id", property="currentAnswerUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.BIT),
        @Result(column="top_amount", property="topAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="top_expiration_date", property="topExpirationDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_amount", property="taskAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="crowdfunding_amount", property="crowdfundingAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="status_change_time", property="statusChangeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAsk> selectRelationByExample(RwAskEvaluateExample example);
    
    @UpdateProvider(type=RwAskEvaluateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskEvaluate record, @Param("example") RwAskEvaluateExample example);

    @UpdateProvider(type=RwAskEvaluateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskEvaluate record, @Param("example") RwAskEvaluateExample example);
}