package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAskEvaluate;
import io.imking.biz.reward.domain.RwAskEvaluateExample;
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
public interface RwAskEvaluateMapper {
    @SelectProvider(type=RwAskEvaluateSqlProvider.class, method="countByExample")
    long countByExample(RwAskEvaluateExample example);

    @DeleteProvider(type=RwAskEvaluateSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskEvaluateExample example);

    @Delete({
        "delete from rw_ask_evaluate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_ask_evaluate (id, rw_ask_id, ",
        "rw_ask_index, evaluate_user_id, ",
        "user_evaluate_dimension_id, score, ",
        "create_by, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=TINYINT}, #{evaluateUserId,jdbcType=INTEGER}, ",
        "#{userEvaluateDimensionId,jdbcType=INTEGER}, #{score,jdbcType=TINYINT}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAskEvaluate record);

    @InsertProvider(type=RwAskEvaluateSqlProvider.class, method="insertSelective")
    int insertSelective(RwAskEvaluate record);

    @SelectProvider(type=RwAskEvaluateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="evaluate_user_id", property="evaluateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_evaluate_dimension_id", property="userEvaluateDimensionId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAskEvaluate> selectByExample(RwAskEvaluateExample example);

    @Select({
        "select",
        "id, rw_ask_id, rw_ask_index, evaluate_user_id, user_evaluate_dimension_id, score, ",
        "create_by, create_time",
        "from rw_ask_evaluate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="evaluate_user_id", property="evaluateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_evaluate_dimension_id", property="userEvaluateDimensionId", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwAskEvaluate selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwAskEvaluateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskEvaluate record, @Param("example") RwAskEvaluateExample example);

    @UpdateProvider(type=RwAskEvaluateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskEvaluate record, @Param("example") RwAskEvaluateExample example);

    @UpdateProvider(type=RwAskEvaluateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAskEvaluate record);

    @Update({
        "update rw_ask_evaluate",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "rw_ask_index = #{rwAskIndex,jdbcType=TINYINT},",
          "evaluate_user_id = #{evaluateUserId,jdbcType=INTEGER},",
          "user_evaluate_dimension_id = #{userEvaluateDimensionId,jdbcType=INTEGER},",
          "score = #{score,jdbcType=TINYINT},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAskEvaluate record);
}