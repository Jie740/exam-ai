package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.api.GenerateForm;
import com.exam.domain.dto.AnswerDto;
import com.exam.domain.vo.AnswerVO;
import com.exam.util.Result;

public interface AnswerService {

    IPage<AnswerVO> findAll(Page<AnswerVO> page);

    Result deleteBySubjectAndType(String subject, String type);

    Result getBySubject(Page page,String subject);

    Result getBySubjectAndType(Page<AnswerVO> answerVOPage, String subject,String type);

    Result getByType(Page page,String type);

    Result getQuestionDetail(String type, Integer questionId);

    Result updateAnswer(AnswerDto answerDto);

    Result deleteAnswer(String type, Integer questionId);

    Result generateQuestions(GenerateForm generateForm, String response);

}
