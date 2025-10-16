package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.Score;
import com.exam.service.ScoreService;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/scores")
    public Result findAll() {
        return Result.ok(scoreService.list());
    }
//    分页
    @GetMapping("/score/{page}/{size}/{studentId}")
    public Result findById(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("studentId") Integer studentId) {
        Page<Score> scorePage = new Page<>(page, size);
        IPage<Score> res = scoreService.lambdaQuery().eq(Score::getStudentId, studentId).page(scorePage);
        return Result.ok(res);
    }

//    不分页
    @GetMapping("/score/{studentId}")
        public Result findById(@PathVariable("studentId") Integer studentId) {
        List<Score> res = scoreService.lambdaQuery().eq(Score::getStudentId, studentId).list();
        if (!res.isEmpty()) {
            return Result.ok(res);
        } else {
            return Result.ok("ID不存在");
        }
    }

    @PostMapping("/score")
    public Result add(@RequestBody Score score) {
        boolean res = scoreService.save(score);
        if (res) {
            return Result.ok("成绩添加失败");
        }else {
            return Result.ok(score);
        }
    }

    @GetMapping("/scores/{examCode}")
    public Result findByExamCode(@PathVariable("examCode") Integer examCode) {
        List<Score> scores = scoreService.lambdaQuery().eq(Score::getExamCode, examCode).list();
        return Result.ok(scores);
    }
}
