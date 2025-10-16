package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author ajie
* @description 针对表【teacher(教师信息表)】的数据库操作Mapper
* @createDate 2025-10-16 15:15:22
* @Entity com.exam.domain.Teacher
*/
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select("select * from teacher")
    IPage<Teacher> findAllPage(Page page);

    @Select("select * from teacher")
    public List<Teacher> findAll();

    @Select("select * from teacher where teacher_id = #{teacherId}")
    public Teacher findById(Integer teacherId);

    @Delete("delete from teacher where teacher_id = #{teacherId}")
    public int deleteById(Integer teacherId);

    @Update("update teacher set teacher_name = #{teacherName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},card_id = #{cardId}," +
            "role = #{role},institute = #{institute},type = #{type} where teacher_id = #{teacherId}")
    public int update(Teacher teacher);

    @Options(useGeneratedKeys = true,keyProperty = "teacherId")
    @Insert("insert into teacher(teacher_name,sex,tel,email,pwd,card_id,role,type,institute) " +
            "values(#{teacherName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role},#{type},#{institute})")
    public int add(Teacher teacher);
}




