package com.exam.controller;

import com.exam.domain.JudgeQuestion;
import com.exam.service.JudgeQuestionService;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeQuestionController {

    @Autowired
    private JudgeQuestionService judgeQuestionService;
    @GetMapping("/judgeQuestion/getAll")
    public Result findAll() {
        return Result.ok(judgeQuestionService.list());
    }

    @PostMapping("/judgeQuestion")
    public Result add(@RequestBody JudgeQuestion judgeQuestion) {
        boolean res = judgeQuestionService.save(judgeQuestion);
        if (res) {
            return Result.ok(judgeQuestion);
        }
        return Result.ok("添加失败");
    }

    @GetMapping("/judgeQuestionId")
    public Result findOnlyQuestionId() {
        JudgeQuestion res = judgeQuestionService.findOnlyQuestionId();
        return  Result.ok(res);
    }
}
