package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.domain.Student;

/**
* @author ajie
* @description 针对表【student(学生信息表)】的数据库操作Service
* @createDate 2025-10-16 00:21:36
*/
public interface StudentService extends IService<Student> {

    Student login(Long  username, String password);
}
