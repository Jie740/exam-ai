package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.JudgeQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author ajie
* @description 针对表【judge_question(判断题题库表)】的数据库操作Mapper
* @createDate 2025-10-16 15:13:32
* @Entity com.exam.domain.JudgeQuestion
*/
public interface JudgeQuestionMapper extends BaseMapper<JudgeQuestion> {
    @Select("select * from judge_question where question_id in (select question_id from paper_manage where question_type = 3 and paper_id = #{paperId})")
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    @Select("select * from judge_question")
    IPage<JudgeQuestion> findAll(Page page);

    /**
     * 查询最后一条记录的questionId
     * @return JudgeQuestion
     */
    @Select("select question_id from judge_question order by question_id desc limit 1")
    JudgeQuestion findOnlyQuestionId();

    @Insert("insert into judge_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject},#{question},#{answer},#{analysis},#{level},#{section})")
    int add(JudgeQuestion judgeQuestion);

    @Select("select question_id from judge_question  where subject=#{subject}  order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(String subject, Integer pageNo);

    /**
     * 批量插入判断题，返回自增ID列表
     * @param judgeQuestions 判断题列表
     * @return 插入成功的条数
     */
    @Insert("<script>" +
            "INSERT INTO judge_question (" +
            "subject, question, answer, analysis, score, level, section" +
            ") VALUES " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.subject}, #{item.question}, #{item.answer}, " +
            "#{item.analysis}, #{item.score}, #{item.level}, #{item.section})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "questionId", keyColumn = "question_id")
    int batchInsert(@Param("list") List<JudgeQuestion> judgeQuestions);
}




