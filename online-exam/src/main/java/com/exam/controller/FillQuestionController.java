package com.exam.controller;

import com.exam.domain.FillQuestion;
import com.exam.service.FillQuestionService;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FillQuestionController {

    @Autowired
    private FillQuestionService fillQuestionService;

    @GetMapping("/fillQuestion/getAll")
    public Result getAll() {
        return Result.ok(fillQuestionService.list());
    }
    @PostMapping("/fillQuestion")
    public Result add(@RequestBody FillQuestion fillQuestion) {
        boolean res = fillQuestionService.save(fillQuestion);
        if (res) {
            return Result.ok(fillQuestion);
        }
        return Result.ok(fillQuestion);
    }

    @GetMapping("/fillQuestionId")
    public Result findOnlyQuestionId() {
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return Result.ok(res);
}
}
