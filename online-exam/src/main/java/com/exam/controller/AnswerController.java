package com.exam.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.ExamManage;
import com.exam.domain.dto.AnswerDto;
import com.exam.domain.vo.AnswerVO;
import com.exam.service.AnswerService;
import com.exam.service.ExamManageService;
import com.exam.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    private final ExamManageService examManageService;



    @GetMapping("/answers/{page}/{size}")
    public Result findAllQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size,
                                  @RequestParam(value = "subject",required = false) String subject,
                                  @RequestParam(value = "type",required = false) String type) {
        Page answerPage = new Page<>(page,size);

        // 无条件查询所有题目
        if(type == null && subject == null) {
            return Result.ok(answerService.findAll(answerPage));
        }

        if (subject != null) {
            if (type == null) {
                // 根据试卷名查询所有题目
                return answerService.getBySubject(answerPage, subject);
            } else {
                // 根据试卷名和题型查询所有题目
                return answerService.getBySubjectAndType(answerPage, subject, type);
            }
        } else {
            // 根据题型查询所有题目
            return answerService.getByType(answerPage,type);
        }
    }


    @DeleteMapping("/answer/{subject}/{type}")
    public Result deleteBySubjectAndType(@PathVariable("subject") String subject, @PathVariable("type") String type){
        return answerService.deleteBySubjectAndType(subject,type);
    }

    @GetMapping("/answer/examName")
    public Result getExamName(){
        List<String> list = examManageService.lambdaQuery().select(ExamManage::getSource).list()
                .stream()
                .map(ExamManage::getSource)
                .toList();
        return Result.ok(list);
    }

    @GetMapping("/answer")
    public Result getAnswer(@RequestParam("type") String type,@RequestParam("questionId") Integer questionId){
        return answerService.getQuestionDetail(type,questionId);
    }

    @PutMapping("/answer")
    public Result updateAnswer(@RequestBody AnswerDto answerDto) {
        return answerService.updateAnswer(answerDto);
    }

    @DeleteMapping("/answer")
    public Result deleteAnswer(@RequestParam("type") String type,@RequestParam("questionId") Integer questionId) {
        return answerService.deleteAnswer(type,questionId);
    }
}
