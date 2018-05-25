package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwRewardDetail;
import io.imking.biz.reward.domain.RwRewardDetailExample;
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
public interface RwRewardDetailMapper {
    @SelectProvider(type=RwRewardDetailSqlProvider.class, method="countByExample")
    long countByExample(RwRewardDetailExample example);

    @DeleteProvider(type=RwRewardDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwRewardDetailExample example);

    @Insert({
        "insert into rw_reward_detail (id, rw_ask_id, ",
        "rw_ask_index, reward_user_id, ",
        "amount, is_all, comment, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=INTEGER}, #{rewardUserId,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=DECIMAL}, #{isAll,jdbcType=BIT}, #{comment,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwRewardDetail record);

    @InsertProvider(type=RwRewardDetailSqlProvider.class, method="insertSelective")
    int insertSelective(RwRewardDetail record);

    @SelectProvider(type=RwRewardDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="reward_user_id", property="rewardUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="is_all", property="isAll", jdbcType=JdbcType.BIT),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwRewardDetail> selectByExample(RwRewardDetailExample example);

    @UpdateProvider(type=RwRewardDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwRewardDetail record, @Param("example") RwRewardDetailExample example);

    @UpdateProvider(type=RwRewardDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwRewardDetail record, @Param("example") RwRewardDetailExample example);
}