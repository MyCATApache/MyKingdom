package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAsk;
import io.imking.biz.reward.domain.RwAskExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface RwAskMapper {
    @SelectProvider(type=RwAskSqlProvider.class, method="countByExample")
    long countByExample(RwAskExample example);

    @DeleteProvider(type=RwAskSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskExample example);

    @Insert({
        "insert into rw_ask (id, rw_ask_index, ",
        "current_answer_user_id, type, ",
        "title, content, ",
        "attach_group, is_top, ",
        "top_amount, top_expiration_date, ",
        "task_amount, crowdfunding_amount, ",
        "status, status_change_time, ",
        "create_by, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskIndex,jdbcType=TINYINT}, ",
        "#{currentAnswerUserId,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{attachGroup,jdbcType=VARCHAR}, #{isTop,jdbcType=BIT}, ",
        "#{topAmount,jdbcType=DECIMAL}, #{topExpirationDate,jdbcType=TIMESTAMP}, ",
        "#{taskAmount,jdbcType=DECIMAL}, #{crowdfundingAmount,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=TINYINT}, #{statusChangeTime,jdbcType=TIMESTAMP}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAsk record);
    
    @InsertProvider(type=RwAskSqlProvider.class, method="insertSelective")
    int insertSelective(RwAsk record);

    @SelectProvider(type=RwAskSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="current_answer_user_id", property="currentAnswerUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.BIT),
        @Result(column="top_amount", property="topAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="top_expiration_date", property="topExpirationDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_amount", property="taskAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="crowdfunding_amount", property="crowdfundingAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="status_change_time", property="statusChangeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAsk> selectByExample(RwAskExample example);

    @UpdateProvider(type=RwAskSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAsk record, @Param("example") RwAskExample example);

    @UpdateProvider(type=RwAskSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAsk record, @Param("example") RwAskExample example);

    @Update({
            "update rw_ask",
            "set content = #{content,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int saveContent(RwAsk record);


    @Update({"<script>",
            "update rw_ask",
            "<set>",
            "<if test=\"type != null\">type=#{type},</if>",
            "<if test=\"isTop != null\">is_top=#{isTop},</if>",
            "<if test=\"topAmount != null\">top_amount=#{topAmount},</if>",
            "<if test=\"topExpirationDate != null\">top_expiration_date=#{topExpirationDate},</if>",
            "<if test=\"status != null\">status=#{status},</if>",
            "</set>",
            " where id=#{id}",
            "</script>"
    })
    int updateRwAsk(RwAsk record);
    
    @Select({
    	"SELECT LAST_INSERT_ID()"
    })
    @ResultType(Integer.class)
    int selectLastInsert();
}