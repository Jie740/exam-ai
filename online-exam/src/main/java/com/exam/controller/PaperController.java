package com.exam.controller;

import com.exam.domain.FillQuestion;
import com.exam.domain.JudgeQuestion;
import com.exam.domain.MultiQuestion;
import com.exam.domain.PaperManage;
import com.exam.service.FillQuestionService;
import com.exam.service.JudgeQuestionService;
import com.exam.service.MultiQuestionService;
import com.exam.service.PaperService;
import com.exam.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PaperController {

    private final PaperService paperService;

    private final JudgeQuestionService judgeQuestionService;

    private final MultiQuestionService multiQuestionService;

    private final FillQuestionService fillQuestionService;
    private final StringRedisTemplate stringRedisTemplate;
    @GetMapping("/papers")
    public Result findAll() {
       return Result.ok(paperService.findAll());
    }

    @GetMapping("/paper/{paperId}")
    public Map<Integer, List<?>> findById(@PathVariable("paperId") Integer paperId) {
        if (paperId == null) {
            throw new IllegalArgumentException("paperId不能为空");
        }
        List<MultiQuestion> multiQuestionRes = multiQuestionService.findByIdAndType(paperId);   //选择题题库 1
        List<FillQuestion> fillQuestionsRes = fillQuestionService.findByIdAndType(paperId);     //填空题题库 2
        List<JudgeQuestion> judgeQuestionRes = judgeQuestionService.findByIdAndType(paperId);   //判断题题库 3
        Map<Integer, List<?>> map = new HashMap<>();
        map.put(1,multiQuestionRes);
        map.put(2,fillQuestionsRes);
        map.put(3,judgeQuestionRes);
        return map;
    }

    @PostMapping("/paperManage")
    public Result add(@RequestBody PaperManage paperManage) {
        int res = paperService.add(paperManage);
        if (res != 0) {
            return Result.ok(paperService);
        }
        return Result.ok(paperManage);
    }
}
