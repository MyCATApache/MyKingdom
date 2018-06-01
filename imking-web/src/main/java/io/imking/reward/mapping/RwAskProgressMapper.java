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

import io.imking.reward.domain.RwAskProgress;
import io.imking.reward.domain.RwAskProgressExample;

@Mapper
public interface RwAskProgressMapper {
    @SelectProvider(type=RwAskProgressSqlProvider.class, method="countByExample")
    long countByExample(RwAskProgressExample example);

    @DeleteProvider(type=RwAskProgressSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskProgressExample example);

    @Delete({
        "delete from rw_ask_progress",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_ask_progress (id, rw_ask_id, ",
        "rw_ask_index, status, ",
        "start_time, deadline_time, ",
        "actual_end_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=INTEGER}, #{status,jdbcType=TINYINT}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{deadlineTime,jdbcType=TIMESTAMP}, ",
        "#{actualEndTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAskProgress record);

    @InsertProvider(type=RwAskProgressSqlProvider.class, method="insertSelective")
    int insertSelective(RwAskProgress record);

    @SelectProvider(type=RwAskProgressSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deadline_time", property="deadlineTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="actual_end_time", property="actualEndTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAskProgress> selectByExample(RwAskProgressExample example);

    @Select({
        "select",
        "id, rw_ask_id, rw_ask_index, status, start_time, deadline_time, actual_end_time",
        "from rw_ask_progress",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deadline_time", property="deadlineTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="actual_end_time", property="actualEndTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwAskProgress selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwAskProgressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskProgress record, @Param("example") RwAskProgressExample example);

    @UpdateProvider(type=RwAskProgressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskProgress record, @Param("example") RwAskProgressExample example);

    @UpdateProvider(type=RwAskProgressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAskProgress record);

    @Update({
        "update rw_ask_progress",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "rw_ask_index = #{rwAskIndex,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "deadline_time = #{deadlineTime,jdbcType=TIMESTAMP},",
          "actual_end_time = #{actualEndTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAskProgress record);
}