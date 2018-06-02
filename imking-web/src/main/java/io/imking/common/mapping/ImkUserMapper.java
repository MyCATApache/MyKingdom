package io.imking.common.mapping;


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

import io.imking.common.domain.ImkUser;
import io.imking.common.domain.ImkUserExample;

@Mapper
public interface ImkUserMapper {
    @SelectProvider(type=ImkUserSqlProvider.class, method="countByExample")
    long countByExample(ImkUserExample example);

    @DeleteProvider(type=ImkUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(ImkUserExample example);

    @Delete({
        "delete from imk_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into imk_user (id, account, ",
        "pwd, realname, pinyin, ",
        "nickname, gender, qq, ",
        "email, website, ",
        "avatar, dream, level, ",
        "points, credit_points, ",
        "balance, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{account,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, #{pinyin,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR}, #{gender,jdbcType=CHAR}, #{qq,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{website,jdbcType=VARCHAR}, ",
        "#{avatar,jdbcType=VARCHAR}, #{dream,jdbcType=VARCHAR}, #{level,jdbcType=TINYINT}, ",
        "#{points,jdbcType=INTEGER}, #{creditPoints,jdbcType=INTEGER}, ",
        "#{balance,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(ImkUser record);

    @InsertProvider(type=ImkUserSqlProvider.class, method="insertSelective")
    int insertSelective(ImkUser record);

    @SelectProvider(type=ImkUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="website", property="website", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="dream", property="dream", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="points", property="points", jdbcType=JdbcType.INTEGER),
        @Result(column="credit_points", property="creditPoints", jdbcType=JdbcType.INTEGER),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ImkUser> selectByExample(ImkUserExample example);

    @Select({
        "select",
        "id, account, pwd, realname, pinyin, nickname, gender, qq, email, website, avatar, ",
        "dream, level, points, credit_points, balance, create_time",
        "from imk_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="pinyin", property="pinyin", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="website", property="website", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="dream", property="dream", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="points", property="points", jdbcType=JdbcType.INTEGER),
        @Result(column="credit_points", property="creditPoints", jdbcType=JdbcType.INTEGER),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ImkUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ImkUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ImkUser record, @Param("example") ImkUserExample example);

    @UpdateProvider(type=ImkUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ImkUser record, @Param("example") ImkUserExample example);

    @UpdateProvider(type=ImkUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ImkUser record);

    @Update({
        "update imk_user",
        "set account = #{account,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "pinyin = #{pinyin,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=CHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "website = #{website,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "dream = #{dream,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=TINYINT},",
          "points = #{points,jdbcType=INTEGER},",
          "credit_points = #{creditPoints,jdbcType=INTEGER},",
          "balance = #{balance,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ImkUser record);
}