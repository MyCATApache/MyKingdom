package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.OpMsg;
import io.imking.biz.reward.domain.OpMsgExample;
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
public interface OpMsgMapper {
    @SelectProvider(type=OpMsgSqlProvider.class, method="countByExample")
    long countByExample(OpMsgExample example);

    @DeleteProvider(type=OpMsgSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpMsgExample example);

    @Delete({
        "delete from op_msg",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into op_msg (id, type, ",
        "from_user_id, to_user_id, ",
        "content, is_read, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{fromUserId,jdbcType=INTEGER}, #{toUserId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{isRead,jdbcType=BIT}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpMsg record);

    @InsertProvider(type=OpMsgSqlProvider.class, method="insertSelective")
    int insertSelective(OpMsg record);

    @SelectProvider(type=OpMsgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="from_user_id", property="fromUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpMsg> selectByExample(OpMsgExample example);

    @Select({
        "select",
        "id, type, from_user_id, to_user_id, content, is_read, create_time",
        "from op_msg",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="from_user_id", property="fromUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpMsg selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpMsgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpMsg record, @Param("example") OpMsgExample example);

    @UpdateProvider(type=OpMsgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpMsg record, @Param("example") OpMsgExample example);

    @UpdateProvider(type=OpMsgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpMsg record);

    @Update({
        "update op_msg",
        "set type = #{type,jdbcType=TINYINT},",
          "from_user_id = #{fromUserId,jdbcType=INTEGER},",
          "to_user_id = #{toUserId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "is_read = #{isRead,jdbcType=BIT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpMsg record);
}