package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAskProgress;
import io.imking.biz.reward.domain.RwAskProgressExample;
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
public interface RwAskProgressMapper {
    @SelectProvider(type=RwAskProgressSqlProvider.class, method="countByExample")
    long countByExample(RwAskProgressExample example);

    @DeleteProvider(type=RwAskProgressSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskProgressExample example);

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
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deadline_time", property="deadlineTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="actual_end_time", property="actualEndTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAskProgress> selectByExample(RwAskProgressExample example);

    @UpdateProvider(type=RwAskProgressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskProgress record, @Param("example") RwAskProgressExample example);

    @UpdateProvider(type=RwAskProgressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskProgress record, @Param("example") RwAskProgressExample example);
}