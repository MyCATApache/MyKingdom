package io.imking.reward.mapping;

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

import io.imking.reward.domain.RwAsk;
import io.imking.reward.domain.RwAskQuestionReply;
import io.imking.reward.domain.RwAskQuestionReplyExample;

@Mapper
public interface RwAskQuestionReplyMapper {
    @SelectProvider(type=RwAskQuestionReplySqlProvider.class, method="countByExample")
    long countByExample(RwAskQuestionReplyExample example);

    @DeleteProvider(type=RwAskQuestionReplySqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskQuestionReplyExample example);

    @Delete({
        "delete from rw_ask_question_reply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_ask_question_reply (id, rw_ask_question_id, ",
        "reply_content, create_by, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskQuestionId,jdbcType=INTEGER}, ",
        "#{replyContent,jdbcType=VARCHAR}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAskQuestionReply record);

    @InsertProvider(type=RwAskQuestionReplySqlProvider.class, method="insertSelective")
    int insertSelective(RwAskQuestionReply record);

    @SelectProvider(type=RwAskQuestionReplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_question_id", property="rwAskQuestionId", jdbcType=JdbcType.INTEGER),
        @Result(column="reply_content", property="replyContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAskQuestionReply> selectByExample(RwAskQuestionReplyExample example);
    
    /**
     * 关联红包任务
     * @param example
     * @return List<RwAsk> 
     * @author 天道
     */
    @SelectProvider(type=RwAskQuestionReplySqlProvider.class, method="selectRelationByExample")
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
    List<RwAsk> selectRelationByExample(RwAskQuestionReplyExample example);

    @Select({
        "select",
        "id, rw_ask_question_id, reply_content, create_by, create_time",
        "from rw_ask_question_reply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_question_id", property="rwAskQuestionId", jdbcType=JdbcType.INTEGER),
        @Result(column="reply_content", property="replyContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwAskQuestionReply selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwAskQuestionReplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskQuestionReply record, @Param("example") RwAskQuestionReplyExample example);

    @UpdateProvider(type=RwAskQuestionReplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskQuestionReply record, @Param("example") RwAskQuestionReplyExample example);

    @UpdateProvider(type=RwAskQuestionReplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAskQuestionReply record);

    @Update({
        "update rw_ask_question_reply",
        "set rw_ask_question_id = #{rwAskQuestionId,jdbcType=INTEGER},",
          "reply_content = #{replyContent,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAskQuestionReply record);
}