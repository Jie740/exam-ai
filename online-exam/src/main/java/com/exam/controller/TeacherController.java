package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.Teacher;
import com.exam.service.TeacherService;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/teachers/{page}/{size}")
    public Result findAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(page,size);
        IPage<Teacher> teacherIPage = teacherService.lambdaQuery().page(teacherPage);
        return Result.ok(teacherIPage);
    }

    @GetMapping("/teacher/{teacherId}")
    public Result findById(@PathVariable("teacherId") Integer teacherId){
        return Result.ok(teacherService.lambdaQuery().eq(Teacher::getTeacherId, teacherId).one());
    }

    @DeleteMapping("/teacher/{teacherId}")
    public Result deleteById(@PathVariable("teacherId") Integer teacherId){
        return Result.ok(teacherService.removeById(teacherId));
    }

    @PutMapping("/teacher")
    public Result update(@RequestBody Teacher teacher){
        return Result.ok(teacherService.lambdaUpdate().eq(Teacher::getTeacherId, teacher.getTeacherId()).update());
    }

    @PostMapping("/teacher")
    public Result add(@RequestBody Teacher teacher){
        return Result.ok(teacherService.save(teacher));
    }
}
