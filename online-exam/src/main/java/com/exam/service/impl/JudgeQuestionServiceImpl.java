package com.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.JudgeQuestion;
import com.exam.mapper.JudgeQuestionMapper;
import com.exam.service.JudgeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ajie
* @description 针对表【judge_question(判断题题库表)】的数据库操作Service实现
* @createDate 2025-10-16 00:21:04
*/
@Service
public class JudgeQuestionServiceImpl extends ServiceImpl<JudgeQuestionMapper, JudgeQuestion>
    implements JudgeQuestionService{

    @Autowired
    private JudgeQuestionMapper judgeQuestionMapper;

    @Override
    public int deleteBySubject(String subject) {
        return this.remove(new LambdaQueryWrapper<JudgeQuestion>().eq(JudgeQuestion::getSubject, subject))==true?1:0;
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer judgeNumber) {
        return judgeQuestionMapper.findBySubject(subject, judgeNumber);
    }

    @Override
    public JudgeQuestion findOnlyQuestionId() {
        return judgeQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public int batchInsert(List<JudgeQuestion> judgeQuestions) {
        return judgeQuestionMapper.batchInsert(judgeQuestions);
    }
}




