package com.exam.controller;

import com.exam.domain.MultiQuestion;
import com.exam.service.MultiQuestionService;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MultiQuestionController {

    @Autowired
    private MultiQuestionService multiQuestionService;
    @GetMapping("/multiQuestion/getAll")
    public Result findAll() {
        return Result.ok(multiQuestionService.list());
    }

    @GetMapping("/multiQuestionId")
    public Result findOnlyQuestion() {
        MultiQuestion res = multiQuestionService.findOnlyQuestionId();
        return Result.ok(res);
    }

    @PostMapping("/MultiQuestion")
    public Result add(@RequestBody MultiQuestion multiQuestion) {
        boolean res = multiQuestionService.save(multiQuestion);
        if (res) {

            return Result.ok(multiQuestion);
        }
        return Result.ok("添加失败");
    }

}
