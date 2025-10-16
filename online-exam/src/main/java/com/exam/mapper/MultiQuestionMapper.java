package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.MultiQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author ajie
* @description 针对表【multi_question(选择题题库表)】的数据库操作Mapper
* @createDate 2025-10-16 15:14:04
* @Entity com.exam.domain.MultiQuestion
*/
public interface MultiQuestionMapper extends BaseMapper<MultiQuestion> {
    /**
     * select * from multiquestions where question_id in (
     * 	select question_id from papermanage where question_type = 1 and paper_id = 1001
     * )
     */
    @Select("select * from multi_question where question_id in (select question_id from paper_manage where question_type = 1 and paper_id = #{paperId})")
    List<MultiQuestion> findByIdAndType(Integer PaperId);

    @Select("select * from multi_question")
    IPage<MultiQuestion> findAll(Page page);

    /**
     * 查询最后一条记录的questionId
     * @return MultiQuestion
     */
    @Select("select question_id from multi_question order by question_id desc limit 1")
    MultiQuestion findOnlyQuestionId();

    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into multi_question(subject,question,answer_a,answer_b,answer_c,answer_d,right_answer,analysis,section,level) " +
            "values(#{subject},#{question},#{answerA},#{answerB},#{answerC},#{answerD},#{rightAnswer},#{analysis},#{section},#{level})")
    int add(MultiQuestion multiQuestion);

    @Select("select question_id from multi_question  where subject =#{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(@Param("subject") String subject, @Param("pageNo") Integer pageNo);



    /**
     * 批量插入选择题，返回自增ID列表
     * @param multiQuestions 选择题列表
     * @return 插入成功的条数
     */
    @Insert("<script>" +
            "INSERT INTO multi_question (" +
            "subject, question, answer_a, answer_b, answer_c, answer_d, " +
            "right_answer, analysis, score, section, level" +
            ") VALUES " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.subject}, #{item.question}, #{item.answerA}, #{item.answerB}, " +
            "#{item.answerC}, #{item.answerD}, #{item.rightAnswer}, #{item.analysis}, " +
            "#{item.score}, #{item.section}, #{item.level})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "questionId", keyColumn = "question_id")
    int batchInsert(@Param("list") List<MultiQuestion> multiQuestions);
}





