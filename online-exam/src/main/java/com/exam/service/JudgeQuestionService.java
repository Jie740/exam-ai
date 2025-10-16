package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.domain.JudgeQuestion;

import java.util.List;

/**
* @author ajie
* @description 针对表【judge_question(判断题题库表)】的数据库操作Service
* @createDate 2025-10-16 00:21:04
*/
public interface JudgeQuestionService extends IService<JudgeQuestion> {

    int deleteBySubject(String subject);

    List<Integer> findBySubject(String subject, Integer judgeNumber);

    JudgeQuestion findOnlyQuestionId();

    List<JudgeQuestion> findByIdAndType(Integer paperId);

    int batchInsert(List<JudgeQuestion> judgeQuestions);
}
