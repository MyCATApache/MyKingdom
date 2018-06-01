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

import io.imking.reward.domain.RwApplyDetail;
import io.imking.reward.domain.RwApplyDetailExample;

@Mapper
public interface RwApplyDetailMapper {
    @SelectProvider(type=RwApplyDetailSqlProvider.class, method="countByExample")
    long countByExample(RwApplyDetailExample example);

    @DeleteProvider(type=RwApplyDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwApplyDetailExample example);

    @Delete({
        "delete from rw_apply_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_apply_detail (id, rw_ask_id, ",
        "rw_ask_index, content, ",
        "create_by, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=TINYINT}, #{content,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwApplyDetail record);

    @InsertProvider(type=RwApplyDetailSqlProvider.class, method="insertSelective")
    int insertSelective(RwApplyDetail record);

    @SelectProvider(type=RwApplyDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwApplyDetail> selectByExample(RwApplyDetailExample example);

    @Select({
        "select",
        "id, rw_ask_id, rw_ask_index, content, create_by, create_time, update_time",
        "from rw_apply_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwApplyDetail selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwApplyDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwApplyDetail record, @Param("example") RwApplyDetailExample example);

    @UpdateProvider(type=RwApplyDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwApplyDetail record, @Param("example") RwApplyDetailExample example);

    @UpdateProvider(type=RwApplyDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwApplyDetail record);

    @Update({
        "update rw_apply_detail",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "rw_ask_index = #{rwAskIndex,jdbcType=TINYINT},",
          "content = #{content,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwApplyDetail record);
}