package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.domain.FillQuestion;

import java.util.List;

/**
* @author ajie
* @description 针对表【fill_question(填空题题库)】的数据库操作Service
* @createDate 2025-10-16 00:21:01
*/
public interface FillQuestionService extends IService<FillQuestion> {

    int deleteBySubject(String subject);

    FillQuestion findOnlyQuestionId();

    List<Integer> findBySubject(String subject, Integer fillNumber);

    List<FillQuestion> findByIdAndType(Integer paperId);

    int batchInsert(List<FillQuestion> fillQuestions);
}
