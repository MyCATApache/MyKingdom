package io.imking.auth.mapping;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by xqy on 18/2/27.
 */
public interface TUserMapper {

    @Select({
            "select * from t_user where account = #{account}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
            @Result(column="authorities", property="authorities", jdbcType=JdbcType.VARCHAR)
    })
    User loadUserByUsername(String account);

    @Insert({"<script>",
            "insert into t_user (id,",
            "pwd,realname,pinyin,gender,qq,email,points,create_time)",
            "values (#{id,jdbcType=BIGINT},",
            "#{pwd,jdbcType=VARCHAR}, ",
            "#{realname,jdbcType=VARCHAR}, ",
            "#{pinyin,jdbcType=VARCHAR}, ",
            "#{gender,jdbcType=BIT}, ",
            "#{qq,jdbcType=VARCHAR}, ",
            "#{email,jdbcType=VARCHAR}, ",
            "#{points,jdbcType=VARCHAR}, ",
            "#{create_time,jdbcType=TIMESTAMP})",
            "</script>"
    })
    int insert(User user);

    @Update({"<script>",
            "update t_user",
            "<set>",
            "<if test=\"realname != null\">realname=#{realname},</if>",
            "<if test=\"nickname != null\">nickname=#{nickname},</if>",
            "<if test=\"qq != null\">qq=#{qq},</if>",
            "<if test=\"email != null\">email=#{email},</if>",
            "<if test=\"website != null\">website=#{website},</if>",
            "<if test=\"dream != null\">dream=#{dream},</if>",
            "<if test=\"points != null\">points=#{points},</if>",
            "<if test=\"credit_points != null\">credit_points=#{credit_points},</if>",
            "<if test=\"balance != null\">balance=#{balance},</if>",
            "<if test=\"avatar != null\">nickname=#{avatar},</if>",
            "</set>",
            " where id=#{id}",
            "</script>"
    })
    int update(User user);
}
