package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.MultiQuestion;
import com.exam.mapper.MultiQuestionMapper;
import com.exam.service.MultiQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ajie
* @description 针对表【multi_question(选择题题库表)】的数据库操作Service实现
* @createDate 2025-10-16 00:21:26
*/
@Service
@RequiredArgsConstructor
public class MultiQuestionServiceImpl extends ServiceImpl<MultiQuestionMapper, MultiQuestion>
    implements MultiQuestionService{
    final MultiQuestionMapper multiQuestionMapper;
    @Override
    public int deleteBySubject(String subject) {
        return this.remove(new LambdaQueryWrapper<MultiQuestion>().eq(MultiQuestion::getSubject,subject))==true?1:0;
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer changeNumber) {
        return multiQuestionMapper.findBySubject(subject,changeNumber);
    }

    public MultiQuestion findOnlyQuestionId() {
        return multiQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public List<MultiQuestion> findByIdAndType(Integer paperId) {
        return multiQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public int batchInsert(List<MultiQuestion> multiQuestions) {
        return multiQuestionMapper.batchInsert(multiQuestions);
    }
}




