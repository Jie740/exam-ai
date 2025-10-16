package com.exam.controller;

import com.exam.domain.Adminuser;
import com.exam.domain.Login;
import com.exam.domain.Student;
import com.exam.domain.Teacher;
import com.exam.service.impl.LoginServiceImpl;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Login login) {

        Integer username = login.getUsername();
        String password = login.getPassword();
        Adminuser adminRes = loginService.adminLogin(username, password);
        if (adminRes != null) {
            return Result.ok(adminRes);
        }

        Teacher teacherRes = loginService.teacherLogin(username,password);
        if (teacherRes != null) {
            return Result.ok(teacherRes);
        }

        Student studentRes = loginService.studentLogin(username,password);
        if (studentRes != null) {
            return Result.ok(studentRes);
        }

        return Result.ok( "请求失败");
    }
}
