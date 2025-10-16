package com.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.FillQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author ajie
* @description 针对表【fill_question(填空题题库)】的数据库操作Mapper
* @createDate 2025-10-16 15:13:18
* @Entity com.exam.domain.FillQuestion
*/
public interface FillQuestionMapper extends BaseMapper<FillQuestion> {
    @Select("select * from fill_question where question_id in (select question_id from paper_manage where question_type = 2 and paper_id = #{paperId})")
    List<FillQuestion> findByIdAndType(Integer paperId);

    @Select("select * from fill_question")
    IPage<FillQuestion> findAll(Page page);

    /**
     * 查询最后一条questionId
     * @return FillQuestion
     */
    @Select("select question_id from fill_question order by question_id desc limit 1")
    FillQuestion findOnlyQuestionId();

    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into fill_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject,},#{question},#{answer},#{analysis},#{level},#{section})")
    int add(FillQuestion fillQuestion);

    @Select("select question_id from fill_question where subject = #{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(String subject, Integer pageNo);

    /**
     * 批量插入填空题，返回自增ID列表
     * @param fillQuestions 填空题列表
     * @return 插入成功的条数
     */
    @Insert("<script>" +
            "INSERT INTO fill_question (" +
            "subject, question, answer, analysis, score, level, section" +
            ") VALUES " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.subject}, #{item.question}, #{item.answer}, " +
            "#{item.analysis}, #{item.score}, #{item.level}, #{item.section})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "questionId", keyColumn = "question_id")
    int batchInsert(@Param("list") List<FillQuestion> fillQuestions);
}




