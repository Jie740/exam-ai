package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.domain.MultiQuestion;

import java.util.List;

/**
* @author ajie
* @description 针对表【multi_question(选择题题库表)】的数据库操作Service
* @createDate 2025-10-16 00:21:26
*/
public interface MultiQuestionService extends IService<MultiQuestion> {

    int deleteBySubject(String subject);

    List<Integer> findBySubject(String subject, Integer changeNumber);

    MultiQuestion findOnlyQuestionId();

    List<MultiQuestion> findByIdAndType(Integer paperId);


    int batchInsert(List<MultiQuestion> multiQuestions);
}
