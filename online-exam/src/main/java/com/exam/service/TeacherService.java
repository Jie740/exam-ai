package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.domain.Teacher;

/**
* @author ajie
* @description 针对表【teacher(教师信息表)】的数据库操作Service
* @createDate 2025-10-16 00:21:38
*/
public interface TeacherService extends IService<Teacher> {

    Teacher login(Integer username, String password);
}
