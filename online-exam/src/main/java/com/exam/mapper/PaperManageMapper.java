package com.exam.mapper;

import com.exam.domain.PaperManage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author ajie
* @description 针对表【paper_manage(试卷管理表)】的数据库操作Mapper
* @createDate 2025-10-16 15:14:18
* @Entity com.exam.domain.PaperManage
*/
public interface PaperManageMapper extends BaseMapper<PaperManage> {
    @Select("select paper_id, question_type,question_id from paper_manage")
    List<PaperManage> findAll();

    @Select("select paper_id, question_type,question_id from paper_manage where paper_id = #{paperId}")
    List<PaperManage> findById(Integer paperId);

    @Insert("insert into paper_manage(paper_id,question_type,question_id) values " +
            "(#{paperId},#{questionType},#{questionId})")
    int add(PaperManage paperManage);
}




