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

import io.imking.reward.domain.RwComment;
import io.imking.reward.domain.RwCommentExample;

@Mapper
public interface RwCommentMapper {
    @SelectProvider(type=RwCommentSqlProvider.class, method="countByExample")
    long countByExample(RwCommentExample example);

    @DeleteProvider(type=RwCommentSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwCommentExample example);

    @Delete({
        "delete from rw_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_comment (id, rw_ask_id, ",
        "rw_ask_index, rw_answer_id, ",
        "type, content, like_num, ",
        "create_by, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=TINYINT}, #{rwAnswerId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=TINYINT}, #{content,jdbcType=VARCHAR}, #{likeNum,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwComment record);

    @InsertProvider(type=RwCommentSqlProvider.class, method="insertSelective")
    int insertSelective(RwComment record);

    @SelectProvider(type=RwCommentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="rw_answer_id", property="rwAnswerId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="like_num", property="likeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwComment> selectByExample(RwCommentExample example);

    @Select({
        "select",
        "id, rw_ask_id, rw_ask_index, rw_answer_id, type, content, like_num, create_by, ",
        "create_time",
        "from rw_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="rw_answer_id", property="rwAnswerId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="like_num", property="likeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwComment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwCommentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwComment record, @Param("example") RwCommentExample example);

    @UpdateProvider(type=RwCommentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwComment record, @Param("example") RwCommentExample example);

    @UpdateProvider(type=RwCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwComment record);

    @Update({
        "update rw_comment",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "rw_ask_index = #{rwAskIndex,jdbcType=TINYINT},",
          "rw_answer_id = #{rwAnswerId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "content = #{content,jdbcType=VARCHAR},",
          "like_num = #{likeNum,jdbcType=INTEGER},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwComment record);
}