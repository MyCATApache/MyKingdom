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

import io.imking.reward.domain.RwAskTagRelationship;
import io.imking.reward.domain.RwAskTagRelationshipExample;

@Mapper
public interface RwAskTagRelationshipMapper {
    @SelectProvider(type=RwAskTagRelationshipSqlProvider.class, method="countByExample")
    long countByExample(RwAskTagRelationshipExample example);

    @DeleteProvider(type=RwAskTagRelationshipSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskTagRelationshipExample example);

    @Delete({
        "delete from rw_ask_tag_relationship",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_ask_tag_relationship (id, rw_ask_id, ",
        "tag_id)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{tagId,jdbcType=INTEGER})"
    })
    int insert(RwAskTagRelationship record);

    @InsertProvider(type=RwAskTagRelationshipSqlProvider.class, method="insertSelective")
    int insertSelective(RwAskTagRelationship record);

    @SelectProvider(type=RwAskTagRelationshipSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER)
    })
    List<RwAskTagRelationship> selectByExample(RwAskTagRelationshipExample example);

    @Select({
        "select",
        "id, rw_ask_id, tag_id",
        "from rw_ask_tag_relationship",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER)
    })
    RwAskTagRelationship selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwAskTagRelationshipSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskTagRelationship record, @Param("example") RwAskTagRelationshipExample example);

    @UpdateProvider(type=RwAskTagRelationshipSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskTagRelationship record, @Param("example") RwAskTagRelationshipExample example);

    @UpdateProvider(type=RwAskTagRelationshipSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAskTagRelationship record);

    @Update({
        "update rw_ask_tag_relationship",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "tag_id = #{tagId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAskTagRelationship record);
}