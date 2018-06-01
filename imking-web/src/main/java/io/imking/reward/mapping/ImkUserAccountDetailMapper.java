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

import io.imking.reward.domain.ImkUserAccountDetail;
import io.imking.reward.domain.ImkUserAccountDetailExample;

@Mapper
public interface ImkUserAccountDetailMapper {
    @SelectProvider(type=ImkUserAccountDetailSqlProvider.class, method="countByExample")
    long countByExample(ImkUserAccountDetailExample example);

    @DeleteProvider(type=ImkUserAccountDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(ImkUserAccountDetailExample example);

    @Delete({
        "delete from imk_user_account_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into imk_user_account_detail (id, user_id, ",
        "amount, balance, ",
        "pay_method, pay_justify, ",
        "create_time, verify_time, ",
        "remark, manager_id, ",
        "status, task_id)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=DECIMAL}, #{balance,jdbcType=DECIMAL}, ",
        "#{payMethod,jdbcType=TINYINT}, #{payJustify,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{verifyTime,jdbcType=TIMESTAMP}, ",
        "#{remark,jdbcType=VARCHAR}, #{managerId,jdbcType=BIGINT}, ",
        "#{status,jdbcType=TINYINT}, #{taskId,jdbcType=BIGINT})"
    })
    int insert(ImkUserAccountDetail record);

    @InsertProvider(type=ImkUserAccountDetailSqlProvider.class, method="insertSelective")
    int insertSelective(ImkUserAccountDetail record);

    @SelectProvider(type=ImkUserAccountDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_method", property="payMethod", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_justify", property="payJustify", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_time", property="verifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT)
    })
    List<ImkUserAccountDetail> selectByExample(ImkUserAccountDetailExample example);

    @Select({
        "select",
        "id, user_id, amount, balance, pay_method, pay_justify, create_time, verify_time, ",
        "remark, manager_id, status, task_id",
        "from imk_user_account_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_method", property="payMethod", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_justify", property="payJustify", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_time", property="verifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT)
    })
    ImkUserAccountDetail selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ImkUserAccountDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ImkUserAccountDetail record, @Param("example") ImkUserAccountDetailExample example);

    @UpdateProvider(type=ImkUserAccountDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ImkUserAccountDetail record, @Param("example") ImkUserAccountDetailExample example);

    @UpdateProvider(type=ImkUserAccountDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ImkUserAccountDetail record);

    @Update({
        "update imk_user_account_detail",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "balance = #{balance,jdbcType=DECIMAL},",
          "pay_method = #{payMethod,jdbcType=TINYINT},",
          "pay_justify = #{payJustify,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "verify_time = #{verifyTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "manager_id = #{managerId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT},",
          "task_id = #{taskId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ImkUserAccountDetail record);
}