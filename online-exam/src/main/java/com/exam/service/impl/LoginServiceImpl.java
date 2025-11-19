package com.exam.service.impl;

import com.exam.domain.Adminuser;
import com.exam.domain.Student;
import com.exam.domain.Teacher;
import com.exam.service.AdminuserService;
import com.exam.service.LoginService;
import com.exam.service.StudentService;
import com.exam.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final AdminuserService adminService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    @Override
    public Adminuser adminLogin(Long username, String password) {
        return adminService.login(username,password);
    }

    @Override
    public Teacher teacherLogin(Long  username, String password) {
        return teacherService.login(username,password);
    }

    @Override
    public Student studentLogin(Long  username, String password) {
        return studentService.login(username,password);
    }
}
