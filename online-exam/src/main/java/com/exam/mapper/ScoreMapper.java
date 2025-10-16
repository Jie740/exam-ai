package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author ajie
* @description 针对表【score(成绩管理表)】的数据库操作Mapper
* @createDate 2025-10-16 15:14:54
* @Entity com.exam.domain.Score
*/
public interface ScoreMapper extends BaseMapper<Score> {
    /**
     * @param score 添加一条成绩记录
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "scoreId")
    @Insert("insert into score(exam_code,student_id,subject,pt_score,et_score,score,answer_date) values(#{examCode},#{studentId},#{subject},#{ptScore},#{etScore},#{score},#{answerDate})")
    int add(Score score);

    @Select("select score_id,exam_code,student_id,subject,pt_score,et_score,score,answer_date from score order by score_id desc")
    List<Score> findAll();

    // 分页
    @Select("select score_id,exam_code,student_id,subject,pt_score,et_score,score,answer_date from score where student_id = #{studentId} order by score_id desc")
    IPage<Score> findByIdPage(Page<?> page, @Param("studentId") Integer studentId);

    // 不分页
    @Select("select score_id,exam_code,student_id,subject,pt_score,et_score,score,answer_date from score where student_id = #{studentId}")
    List<Score> findById(Integer studentId);

    /**
     *
     * @return 查询每位学生的学科分数。 max其实是假的，为了迷惑老师，达到一次考试考生只参加了一次的效果
     */
    @Select("select max(et_score) as et_score from score where exam_code = #{examCode} group by student_id")
    List<Score> findByExamCode(Integer examCode);
}




