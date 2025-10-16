package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.vo.AnswerVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AnswerMapper {
    @Select("select question_id,question, subject, score, section,level, \"选择题\" as type from multi_question " +
            "union select question_id,question, subject, score, section,level, \"判断题\" as type  from judge_question " +
            "union select question_id,question, subject, score, section,level, \"填空题\" as type from fill_question")
    IPage<AnswerVO> findAll(Page page);

    @Select("select question_id,question, subject, score, section,level, \"选择题\" as type from multi_question where subject=#{subject} " +
            "union select question_id,question, subject, score, section,level, \"判断题\" as type  from judge_question where subject=#{subject} " +
            "union select question_id,question, subject, score, section,level, \"填空题\" as type from fill_question where subject=#{subject} ")
    IPage<AnswerVO> findAllBySubject(Page page, @Param("subject") String subject);

    @Select("select question_id,question, subject, score, section,level, \"选择题\" as type from multi_question")
    IPage<AnswerVO> findMultiQuestion(Page page);
    @Select("select question_id,question, subject, score, section,level, \"判断题\" as type  from judge_question")
    IPage<AnswerVO> findJudgeQuestion(Page page);
    @Select("select question_id,question, subject, score, section,level, \"填空题\" as type from fill_question")
    IPage<AnswerVO> findFillQuestion(Page page);
}
