package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.Teacher;
import com.exam.mapper.TeacherMapper;
import com.exam.service.TeacherService;
import org.springframework.stereotype.Service;

/**
* @author ajie
* @description 针对表【teacher(教师信息表)】的数据库操作Service实现
* @createDate 2025-10-16 00:21:38
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

    @Override
    public Teacher login(Long username, String password) {
        return this.lambdaQuery().eq(Teacher::getTeacherId, username).eq(Teacher::getPwd, password).one();
    }
}




