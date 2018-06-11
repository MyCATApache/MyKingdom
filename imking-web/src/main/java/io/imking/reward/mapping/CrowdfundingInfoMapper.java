package io.imking.reward.mapping;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import io.imking.reward.domain.CrowdfundingInfo;
import io.imking.reward.domain.CrowdfundingInfoExample;

@Mapper
public interface CrowdfundingInfoMapper {
    @SelectProvider(type=CrowdfundingInfoSqlProvider.class, method="countByExample")
    long countByExample(CrowdfundingInfoExample example);

    @DeleteProvider(type=CrowdfundingInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(CrowdfundingInfoExample example);

    @Delete({
        "delete from crowdfunding_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into crowdfunding_info (id, rw_ask_id, ",
        "amount, create_by, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=INTEGER}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(CrowdfundingInfo record);

    @InsertProvider(type=CrowdfundingInfoSqlProvider.class, method="insertSelective")
    int insertSelective(CrowdfundingInfo record);

    @SelectProvider(type=CrowdfundingInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CrowdfundingInfo> selectByExample(CrowdfundingInfoExample example);

    @Select({
        "select",
        "id, rw_ask_id, amount, create_by, create_time",
        "from crowdfunding_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CrowdfundingInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CrowdfundingInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CrowdfundingInfo record, @Param("example") CrowdfundingInfoExample example);

    @UpdateProvider(type=CrowdfundingInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CrowdfundingInfo record, @Param("example") CrowdfundingInfoExample example);

    @UpdateProvider(type=CrowdfundingInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CrowdfundingInfo record);

    @Update({
        "update crowdfunding_info",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=INTEGER},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CrowdfundingInfo record);
}