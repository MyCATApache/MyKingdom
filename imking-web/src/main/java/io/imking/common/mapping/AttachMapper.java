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

import io.imking.common.domain.Attach;
import io.imking.common.domain.AttachExample;


@Mapper
public interface AttachMapper {
    @SelectProvider(type=AttachSqlProvider.class, method="countByExample")
    long countByExample(AttachExample example);

    @DeleteProvider(type=AttachSqlProvider.class, method="deleteByExample")
    int deleteByExample(AttachExample example);

    @Delete({
        "delete from attach",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into attach (id, attach_group, ",
        "file_name, file_type, ",
        "save_name, save_path, ",
        "file_desc, size, ",
        "extension, create_by, ",
        "create_time, update_by, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{attachGroup,jdbcType=VARCHAR}, ",
        "#{fileName,jdbcType=VARCHAR}, #{fileType,jdbcType=TINYINT}, ",
        "#{saveName,jdbcType=VARCHAR}, #{savePath,jdbcType=VARCHAR}, ",
        "#{fileDesc,jdbcType=VARCHAR}, #{size,jdbcType=INTEGER}, ",
        "#{extension,jdbcType=VARCHAR}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Attach record);

    @InsertProvider(type=AttachSqlProvider.class, method="insertSelective")
    int insertSelective(Attach record);

    @SelectProvider(type=AttachSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_type", property="fileType", jdbcType=JdbcType.TINYINT),
        @Result(column="save_name", property="saveName", jdbcType=JdbcType.VARCHAR),
        @Result(column="save_path", property="savePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_desc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.INTEGER),
        @Result(column="extension", property="extension", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Attach> selectByExample(AttachExample example);

    @Select({
        "select",
        "id, attach_group, file_name, file_type, save_name, save_path, file_desc, size, ",
        "extension, create_by, create_time, update_by, update_time",
        "from attach",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_type", property="fileType", jdbcType=JdbcType.TINYINT),
        @Result(column="save_name", property="saveName", jdbcType=JdbcType.VARCHAR),
        @Result(column="save_path", property="savePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_desc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.INTEGER),
        @Result(column="extension", property="extension", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Attach selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AttachSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Attach record, @Param("example") AttachExample example);

    @UpdateProvider(type=AttachSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Attach record, @Param("example") AttachExample example);

    @UpdateProvider(type=AttachSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Attach record);

    @Update({
        "update attach",
        "set attach_group = #{attachGroup,jdbcType=VARCHAR},",
          "file_name = #{fileName,jdbcType=VARCHAR},",
          "file_type = #{fileType,jdbcType=TINYINT},",
          "save_name = #{saveName,jdbcType=VARCHAR},",
          "save_path = #{savePath,jdbcType=VARCHAR},",
          "file_desc = #{fileDesc,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=INTEGER},",
          "extension = #{extension,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Attach record);
}