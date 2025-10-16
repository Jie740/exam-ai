package com.exam.service;

import com.exam.domain.Adminuser;
import com.exam.domain.Student;
import com.exam.domain.Teacher;

public interface LoginService {

    public Adminuser adminLogin(Integer username, String password);

    public Teacher teacherLogin(Integer username, String password);

    public Student studentLogin(Integer username, String password);
}
