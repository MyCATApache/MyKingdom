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

import io.imking.reward.domain.ImkUserPointDetail;
import io.imking.reward.domain.ImkUserPointDetailExample;

@Mapper
public interface ImkUserPointDetailMapper {
    @SelectProvider(type=ImkUserPointDetailSqlProvider.class, method="countByExample")
    long countByExample(ImkUserPointDetailExample example);

    @DeleteProvider(type=ImkUserPointDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(ImkUserPointDetailExample example);

    @Delete({
        "delete from imk_user_point_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into imk_user_point_detail (id, user_id, ",
        "amount, balance, ",
        "create_time, remark)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=INTEGER}, #{balance,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(ImkUserPointDetail record);

    @InsertProvider(type=ImkUserPointDetailSqlProvider.class, method="insertSelective")
    int insertSelective(ImkUserPointDetail record);

    @SelectProvider(type=ImkUserPointDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="balance", property="balance", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<ImkUserPointDetail> selectByExample(ImkUserPointDetailExample example);

    @Select({
        "select",
        "id, user_id, amount, balance, create_time, remark",
        "from imk_user_point_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="balance", property="balance", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    ImkUserPointDetail selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ImkUserPointDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ImkUserPointDetail record, @Param("example") ImkUserPointDetailExample example);

    @UpdateProvider(type=ImkUserPointDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ImkUserPointDetail record, @Param("example") ImkUserPointDetailExample example);

    @UpdateProvider(type=ImkUserPointDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ImkUserPointDetail record);

    @Update({
        "update imk_user_point_detail",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=INTEGER},",
          "balance = #{balance,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ImkUserPointDetail record);
}