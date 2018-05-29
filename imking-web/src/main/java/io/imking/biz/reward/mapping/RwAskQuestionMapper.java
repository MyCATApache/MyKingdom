package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskQuestion;
import io.imking.biz.reward.domain.RwAskQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface RwAskQuestionMapper {
    @SelectProvider(type=RwAskQuestionSqlProvider.class, method="countByExample")
    long countByExample(RwAskQuestionExample example);

    @DeleteProvider(type=RwAskQuestionSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskQuestionExample example);

    @Delete({
        "delete from rw_ask_question",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_ask_question (id, rw_ask_id, ",
        "question_content, create_by, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{questionContent,jdbcType=VARCHAR}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAskQuestion record);

    @InsertProvider(type=RwAskQuestionSqlProvider.class, method="insertSelective")
    int insertSelective(RwAskQuestion record);

    @SelectProvider(type=RwAskQuestionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="question_content", property="questionContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAskQuestion> selectByExample(RwAskQuestionExample example);


    @Select({
        "select",
        "id, rw_ask_id, question_content, create_by, create_time",
        "from rw_ask_question",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="question_content", property="questionContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwAskQuestion selectByPrimaryKey(Integer id);

    
    /**
     * 关联红包任务
     * @param example
     * @return List<RwAsk> 
     * @author 天道
     */
    @SelectProvider(type=RwAskQuestionSqlProvider.class, method="selectRelationByExample")
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
    List<RwAsk> selectRelationByExample(RwAskQuestionExample example);

    @UpdateProvider(type=RwAskQuestionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskQuestion record, @Param("example") RwAskQuestionExample example);

    @UpdateProvider(type=RwAskQuestionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskQuestion record, @Param("example") RwAskQuestionExample example);

    @UpdateProvider(type=RwAskQuestionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAskQuestion record);

    @Update({
        "update rw_ask_question",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "question_content = #{questionContent,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAskQuestion record);
}