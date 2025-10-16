package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.Student;
import com.exam.service.StudentService;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Student> studentPage = new Page<>(page,size);
        IPage<Student> res = studentService.lambdaQuery().page(studentPage);
        return  Result.ok(res);
    }

    @GetMapping("/student/{studentId}")
    public Result findById(@PathVariable("studentId") Integer studentId) {
        Student res = studentService.lambdaQuery().eq(Student::getStudentId,studentId).one();
        if (res != null) {
        return Result.ok(res);
        } else {
            return Result.ok("查询的用户不存在");
        }
    }

    @DeleteMapping("/student/{studentId}")
    public Result deleteById(@PathVariable("studentId") Integer studentId) {
        return Result.ok(studentService.removeById(studentId));
    }

    @PutMapping("/studentPWD")
    public Result updatePwd(@RequestBody Student student) {
        studentService.lambdaUpdate().eq(Student::getStudentId,student.getStudentId()).update();
        return Result.ok(student);
    }
    @PutMapping("/student")
    public Result update(@RequestBody Student student) {
        studentService.lambdaUpdate().eq(Student::getStudentId,student.getStudentId()).update();
        return Result.ok(student);
    }

    @PostMapping("/student")
    public Result add(@RequestBody Student student) {
        boolean res = studentService.save(student);
        if (res) {
            return Result.ok(student);
        }else {
            return Result.ok("添加失败");
        }
    }
}
