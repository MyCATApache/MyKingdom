package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAskQuestionReply;
import io.imking.biz.reward.domain.RwAskQuestionReplyExample;
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
public interface RwAskQuestionReplyMapper {
    @SelectProvider(type=RwAskQuestionReplySqlProvider.class, method="countByExample")
    long countByExample(RwAskQuestionReplyExample example);

    @DeleteProvider(type=RwAskQuestionReplySqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskQuestionReplyExample example);

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
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_question_id", property="rwAskQuestionId", jdbcType=JdbcType.INTEGER),
        @Result(column="reply_content", property="replyContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAskQuestionReply> selectByExample(RwAskQuestionReplyExample example);

    @UpdateProvider(type=RwAskQuestionReplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskQuestionReply record, @Param("example") RwAskQuestionReplyExample example);

    @UpdateProvider(type=RwAskQuestionReplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskQuestionReply record, @Param("example") RwAskQuestionReplyExample example);
}