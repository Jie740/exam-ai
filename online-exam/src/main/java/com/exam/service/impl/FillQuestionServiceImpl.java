package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.FillQuestion;
import com.exam.mapper.FillQuestionMapper;
import com.exam.service.FillQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ajie
* @description 针对表【fill_question(填空题题库)】的数据库操作Service实现
* @createDate 2025-10-16 00:21:01
*/
@Service
@RequiredArgsConstructor
public class FillQuestionServiceImpl extends ServiceImpl<FillQuestionMapper, FillQuestion>
    implements FillQuestionService{
    private final FillQuestionMapper fillQuestionMapper;

    @Override
    public int deleteBySubject(String subject) {
        return this.remove(new LambdaQueryWrapper<FillQuestion>().eq(FillQuestion::getSubject, subject))==true?1:0;
    }

    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer fillNumber) {
        return fillQuestionMapper.findBySubject(subject, fillNumber);
    }

    @Override
    @Cacheable(cacheNames = "fillQuestion",key = "#paperId")
    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public int batchInsert(List<FillQuestion> fillQuestions) {
        return fillQuestionMapper.batchInsert(fillQuestions);
    }
}




