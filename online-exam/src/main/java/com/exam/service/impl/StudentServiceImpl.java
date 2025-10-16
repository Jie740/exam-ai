package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.Student;
import com.exam.mapper.StudentMapper;
import com.exam.service.StudentService;
import org.springframework.stereotype.Service;

/**
* @author ajie
* @description 针对表【student(学生信息表)】的数据库操作Service实现
* @createDate 2025-10-16 00:21:36
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Override
    public Student login(Integer username, String password) {
        return this.lambdaQuery().eq(Student::getStudentId, username).eq(Student::getPwd, password).one();
    }
}




