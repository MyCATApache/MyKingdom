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

import io.imking.reward.domain.CrowdFundingInfo;
import io.imking.reward.domain.CrowdFundingInfoExample;

@Mapper
public interface CrowdFundingInfoMapper {
    @SelectProvider(type=CrowdFundingInfoSqlProvider.class, method="countByExample")
    long countByExample(CrowdFundingInfoExample example);

    @DeleteProvider(type=CrowdFundingInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(CrowdFundingInfoExample example);

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
        "#{amount,jdbcType=DECIMAL}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(CrowdFundingInfo record);

    @InsertProvider(type=CrowdFundingInfoSqlProvider.class, method="insertSelective")
    int insertSelective(CrowdFundingInfo record);

    @SelectProvider(type=CrowdFundingInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CrowdFundingInfo> selectByExample(CrowdFundingInfoExample example);

    @Select({
        "select",
        "id, rw_ask_id, amount, create_by, create_time",
        "from crowdfunding_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CrowdFundingInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CrowdFundingInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CrowdFundingInfo record, @Param("example") CrowdFundingInfoExample example);

    @UpdateProvider(type=CrowdFundingInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CrowdFundingInfo record, @Param("example") CrowdFundingInfoExample example);

    @UpdateProvider(type=CrowdFundingInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CrowdFundingInfo record);

    @Update({
        "update crowdfunding_info",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CrowdFundingInfo record);
}