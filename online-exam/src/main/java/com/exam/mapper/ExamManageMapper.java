package com.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.ExamManage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author ajie
* @description 针对表【exam_manage(考试管理表)】的数据库操作Mapper
* @createDate 2025-10-16 15:13:00
* @Entity com.exam.domain.ExamManage
*/
public interface ExamManageMapper extends BaseMapper<ExamManage> {
    @Select("select * from exam_manage")
    List<ExamManage> findAll();

    @Select("select * from exam_manage")
    IPage<ExamManage> findAllPage(Page page);

    @Select("select * from exam_manage where exam_code = #{examCode}")
    ExamManage findById(Integer examCode);

    @Delete("delete from exam_manage where exam_code = #{examCode}")
    int delete(Integer examCode);

    @Update("update exam_manage set description = #{description},source = #{source},paper_id = #{paperId}," +
            "exam_date = #{examDate},total_time = #{totalTime},grade = #{grade},term = #{term}," +
            "major = #{major},institute = #{institute},total_score = #{totalScore}," +
            "type = #{type},tips = #{tips} where exam_code = #{examCode}")
    int update(ExamManage exammanage);

    @Options(useGeneratedKeys = true,keyProperty = "exam_code")
    @Insert("insert into exam_manage(description,source,paper_id,exam_date,total_time,grade,term,major,institute,total_score,type,tips)" +
            " values(#{description},#{source},#{paperId},#{examDate},#{totalTime},#{grade},#{term},#{major},#{institute},#{totalScore},#{type},#{tips})")
    int add(ExamManage exammanage);

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     * @return paperId
     */
    @Select("select paper_id from exam_manage order by paper_id desc limit 1")
    ExamManage findOnlyPaperId();
}




