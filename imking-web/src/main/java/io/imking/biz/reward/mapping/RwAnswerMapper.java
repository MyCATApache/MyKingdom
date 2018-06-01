package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAnswer;
import io.imking.biz.reward.domain.RwAnswerExample;
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
public interface RwAnswerMapper {
    @SelectProvider(type=RwAnswerSqlProvider.class, method="countByExample")
    long countByExample(RwAnswerExample example);

    @DeleteProvider(type=RwAnswerSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAnswerExample example);

    @Delete({
        "delete from rw_answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_answer (id, rw_ask_id, ",
        "rw_ask_index, content, ",
        "attach_group, create_by, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=TINYINT}, #{content,jdbcType=VARCHAR}, ",
        "#{attachGroup,jdbcType=VARCHAR}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAnswer record);

    @InsertProvider(type=RwAnswerSqlProvider.class, method="insertSelective")
    int insertSelective(RwAnswer record);

    @SelectProvider(type=RwAnswerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAnswer> selectByExample(RwAnswerExample example);

    @Select({
        "select",
        "id, rw_ask_id, rw_ask_index, content, attach_group, create_by, create_time, ",
        "update_time",
        "from rw_answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwAnswer selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwAnswerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAnswer record, @Param("example") RwAnswerExample example);

    @UpdateProvider(type=RwAnswerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAnswer record, @Param("example") RwAnswerExample example);

    @UpdateProvider(type=RwAnswerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAnswer record);

    @Update({
        "update rw_answer",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "rw_ask_index = #{rwAskIndex,jdbcType=TINYINT},",
          "content = #{content,jdbcType=VARCHAR},",
          "attach_group = #{attachGroup,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAnswer record);
}