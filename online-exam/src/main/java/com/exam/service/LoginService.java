package com.exam.service;

import com.exam.domain.Adminuser;
import com.exam.domain.Student;
import com.exam.domain.Teacher;

public interface LoginService {

    public Adminuser adminLogin(Long username, String password);

    public Teacher teacherLogin(Long username, String password);

    public Student studentLogin(Long username, String password);
}
