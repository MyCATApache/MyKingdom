package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwProAct;
import io.imking.biz.reward.domain.RwProActExample;
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
public interface RwProActMapper {
    @SelectProvider(type=RwProActSqlProvider.class, method="countByExample")
    long countByExample(RwProActExample example);

    @DeleteProvider(type=RwProActSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwProActExample example);

    @Insert({
        "insert into rw_pro_act (id, rw_ask_id, ",
        "rw_ask_index, type, ",
        "amount, apply_delay_days, ",
        "create_by, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{amount,jdbcType=DECIMAL}, #{applyDelayDays,jdbcType=TINYINT}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwProAct record);

    @InsertProvider(type=RwProActSqlProvider.class, method="insertSelective")
    int insertSelective(RwProAct record);

    @SelectProvider(type=RwProActSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="apply_delay_days", property="applyDelayDays", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwProAct> selectByExample(RwProActExample example);

    @UpdateProvider(type=RwProActSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwProAct record, @Param("example") RwProActExample example);

    @UpdateProvider(type=RwProActSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwProAct record, @Param("example") RwProActExample example);
}