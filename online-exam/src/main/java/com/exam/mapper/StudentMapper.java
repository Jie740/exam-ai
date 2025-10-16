package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
* @author ajie
* @description 针对表【student(学生信息表)】的数据库操作Mapper
* @createDate 2025-10-16 15:15:09
* @Entity com.exam.domain.Student
*/
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 分页查询所有学生
     * @param page
     * @return List<Student>
     */
    @Select("select * from student")
    IPage<Student> findAll(Page page);

    @Select("select * from student where student_id = #{studentd}")
    Student findById(Integer studentId);

    @Delete("delete from student where student_id = #{studentId}")
    int deleteById(Integer studentId);

    /**
     *更新所有学生信息
     * @param student 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update student set student_name = #{studentName},grade = #{grade},major = #{major},clazz = #{clazz}," +
            "institute = #{institute},tel = #{tel},email = #{email},pwd = #{pwd},card_id = #{cardId},sex = #{sex},role = #{role} " +
            "where student_id = #{studentId}")
    int update(Student student);

    /**
     * 更新密码
     * @param student
     * @return 受影响的记录条数
     */
    @Update("update student set pwd = #{pwd} where student_id = #{studentId}")
    int updatePwd(Student student);


    @Options(useGeneratedKeys = true,keyProperty = "studentId")
    @Insert("insert into student(student_name,grade,major,clazz,institute,tel,email,pwd,card_id,sex,role) values " +
            "(#{studentName},#{grade},#{major},#{clazz},#{institute},#{tel},#{email},#{pwd},#{cardId},#{sex},#{role})")
    int add(Student student);
}




