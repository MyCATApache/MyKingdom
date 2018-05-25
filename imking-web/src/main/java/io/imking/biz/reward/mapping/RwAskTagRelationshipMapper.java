package io.imking.biz.reward.mapping;

import io.imking.biz.reward.domain.RwAskTagRelationship;
import io.imking.biz.reward.domain.RwAskTagRelationshipExample;
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
public interface RwAskTagRelationshipMapper {
    @SelectProvider(type=RwAskTagRelationshipSqlProvider.class, method="countByExample")
    long countByExample(RwAskTagRelationshipExample example);

    @DeleteProvider(type=RwAskTagRelationshipSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskTagRelationshipExample example);

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
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER)
    })
    List<RwAskTagRelationship> selectByExample(RwAskTagRelationshipExample example);

    @UpdateProvider(type=RwAskTagRelationshipSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAskTagRelationship record, @Param("example") RwAskTagRelationshipExample example);

    @UpdateProvider(type=RwAskTagRelationshipSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAskTagRelationship record, @Param("example") RwAskTagRelationshipExample example);
}