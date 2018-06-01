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

import io.imking.reward.domain.RwAskTags;
import io.imking.reward.domain.RwAskTagsExample;

@Mapper
public interface RwAskTagsMapper {
    @SelectProvider(type=RwAskTagsSqlProvider.class, method="countByExample")
    long countByExample(RwAskTagsExample example);

    @DeleteProvider(type=RwAskTagsSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskTagsExample example);

    @Delete({
        "delete from rw_ask_tags",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_ask_tags (id, type, ",
        "tag_name)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, ",
        "#{tagName,jdbcType=VARCHAR})"
    })
    int insert(RwAskTags record);

    @InsertProvider(type=RwAskTagsSqlProvider.class, method="insertSelective")
    int insertSelective(RwAskTags record);

    @SelectProvider(type=RwAskTagsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR)
    })
    List<RwAskTags> selectByExample(RwAskTagsExample example);

    @Select({
        "select",
        "id, type, tag_name",
        "from rw_ask_tags",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR)
    })
    RwAskTags selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwAskTagsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskTags record, @Param("example") RwAskTagsExample example);

    @UpdateProvider(type=RwAskTagsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskTags record, @Param("example") RwAskTagsExample example);

    @UpdateProvider(type=RwAskTagsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAskTags record);

    @Update({
        "update rw_ask_tags",
        "set type = #{type,jdbcType=VARCHAR},",
          "tag_name = #{tagName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAskTags record);
}