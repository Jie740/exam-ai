package com.exam.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.api.GenerateForm;
import com.exam.domain.FillQuestion;
import com.exam.domain.JudgeQuestion;
import com.exam.domain.MultiQuestion;
import com.exam.domain.PaperManage;
import com.exam.domain.dto.AnswerDto;
import com.exam.domain.vo.AnswerVO;
import com.exam.mapper.AnswerMapper;
import com.exam.service.*;
import com.exam.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    private final MultiQuestionService multiQuestionService;
    private final JudgeQuestionService judgeQuestionService;
    private final FillQuestionService fillQuestionService;
    private final PaperManageService paperManageService;



    @Override
    @Transactional
    public Result generateQuestions(GenerateForm generateForm, String response) {
        switch (generateForm.getType()){
            case "选择题":
                List<MultiQuestion> multiQuestions = JSONUtil.toList(response, MultiQuestion.class);
                //批量插入选择题
                multiQuestionService.batchInsert(multiQuestions);
                //回填questionId，写入paper表
                List<Integer> multiQuestionIds= multiQuestions.stream()
                        .map(MultiQuestion::getQuestionId)
                        .toList();
                List<PaperManage> multiQuestionPaper = multiQuestionIds.stream()
                        .map(questionId -> {
                            PaperManage pq = new PaperManage();
                            pq.setPaperId(Integer.valueOf(generateForm.getPaperId()));       // 试卷ID
                            pq.setQuestionId(questionId); // 题目ID
                            pq.setQuestionType(1);               // 固定类型=1（选择题）
                            return pq;
                        })
                        .collect(Collectors.toList());
                paperManageService.saveBatch(multiQuestionPaper);
                return Result.ok(multiQuestions);
            case "判断题":
                List<JudgeQuestion> judgeQuestions = JSONUtil.toList(response, JudgeQuestion.class);
                judgeQuestionService.batchInsert(judgeQuestions);
                //回填questionId，写入paper表
                List<Integer> judgeQuestionIds= judgeQuestions.stream()
                        .map(JudgeQuestion::getQuestionId)
                        .toList();
                List<PaperManage> judgeQuestionPaper = judgeQuestionIds.stream()
                                .map(questionId -> {
                                    PaperManage pq = new PaperManage();
                                    pq.setPaperId(Integer.valueOf(generateForm.getPaperId()));
                                    pq.setQuestionId(questionId);
                                    pq.setQuestionType(3);
                                    return pq;
                                })
                                .collect(Collectors.toList());
                paperManageService.saveBatch(judgeQuestionPaper);
                return Result.ok(judgeQuestions);
            case "填空题":
                List<FillQuestion> fillQuestions = JSONUtil.toList(response, FillQuestion.class);
                fillQuestionService.batchInsert(fillQuestions);
                //回填questionId，写入paper表
                List<Integer> fillQuestionIds= fillQuestions.stream()
                        .map(FillQuestion::getQuestionId)
                        .toList();
                List<PaperManage> fillQuestionPaper = fillQuestionIds.stream()
                        .map(questionId -> {
                            PaperManage pq = new PaperManage();
                            pq.setPaperId(Integer.valueOf(generateForm.getPaperId()));
                            pq.setQuestionId(questionId);
                            pq.setQuestionType(2);
                            return pq;
                        })
                        .collect(Collectors.toList());
                paperManageService.saveBatch(fillQuestionPaper);
                return Result.ok(fillQuestions);
            default:
                return Result.error("生成失败");
        }
    }



    @Override
    public IPage<AnswerVO> findAll(Page<AnswerVO> page) {
        return answerMapper.findAll(page);
    }

    @Override
    public Result deleteBySubjectAndType(String subject, String type) {
        switch (type){
            case "选择题":
                int res = multiQuestionService.deleteBySubject(subject);
                return Result.ok(res);
            case "判断题":
                int res1 = judgeQuestionService.deleteBySubject(subject);
                return Result.ok(res1);
            case "填空题":
                int res2 = fillQuestionService.deleteBySubject(subject);
                return Result.ok(res2);
        }
        return Result.error("删除失败");
    }

    @Override
    public Result getBySubject(Page page,String subject) {
        return Result.ok(answerMapper.findAllBySubject(page,subject));
    }

    @Override
    public Result getByType(Page answerPage,String type) {
        switch (type){
            case "选择题":
                return Result.ok(answerMapper.findMultiQuestion(answerPage));
            case "判断题":
                return Result.ok(answerMapper.findJudgeQuestion(answerPage));
            case "填空题":
                return Result.ok(answerMapper.findFillQuestion(answerPage));
            default:
                return Result.error("题型错误");
        }
    }

    @Override
    public Result getQuestionDetail(String type, Integer questionId) {
        switch ( type){
            case "选择题":
                return Result.ok(multiQuestionService.lambdaQuery().eq(MultiQuestion::getQuestionId, questionId).one());
            case "判断题":
                return Result.ok(judgeQuestionService.lambdaQuery().eq(JudgeQuestion::getQuestionId, questionId).one());
            case "填空题":
                return Result.ok(fillQuestionService.lambdaQuery().eq(FillQuestion::getQuestionId, questionId).one());
            default:
                return Result.error("题型错误");
        }
    }

    @Override
    public Result updateAnswer(AnswerDto answerDto) {
        switch (answerDto.getType()){
            case "选择题":
                MultiQuestion multiQuestion = BeanUtil.copyProperties(answerDto, MultiQuestion.class);
                return Result.ok(multiQuestionService.updateById(multiQuestion));
            case "填空题":
                FillQuestion fillQuestion = BeanUtil.copyProperties(answerDto, FillQuestion.class);
                return Result.ok(fillQuestionService.updateById(fillQuestion));
            case "判断题":
                JudgeQuestion judgeQuestion = BeanUtil.copyProperties(answerDto, JudgeQuestion.class);
                return Result.ok(judgeQuestionService.updateById(judgeQuestion));
            default:
                return Result.error("题型错误");
        }
    }

    @Override
    public Result deleteAnswer(String type, Integer questionId) {
        switch (type){
            case "选择题":
                return Result.ok(multiQuestionService.removeById(questionId));
            case "填空题":
                return Result.ok(fillQuestionService.removeById(questionId));
            case "判断题":
                return Result.ok(judgeQuestionService.removeById(questionId));
            default:
                return Result.error("删除失败");
        }
    }



    @Override
    public Result getBySubjectAndType(Page answerVOPage, String subject, String type) {
        switch (type) {
            case "选择题":
                // 执行查询
                IPage<MultiQuestion> questionPage = multiQuestionService.lambdaQuery()
                        .eq(MultiQuestion::getSubject, subject)
                        .page(answerVOPage);
                // 遍历结果并添加type字段
                List<MultiQuestion> records = questionPage.getRecords().stream()
                        .map(question -> {
                            question.setType("选择题");
                            return question;
                        })
                        .collect(Collectors.toList());
                // 重新设置处理后的记录列表
                questionPage.setRecords(records);
                return Result.ok(questionPage);

            case "判断题":
                IPage<JudgeQuestion> judgeQuestionIPage = judgeQuestionService.lambdaQuery()
                        .eq(JudgeQuestion::getSubject, subject)
                        .page(answerVOPage);
                List<JudgeQuestion> judgeQuestions = judgeQuestionIPage.getRecords()
                        .stream()
                        .map(question -> {
                            question.setType("判断题");
                            return question;
                        })
                        .collect(Collectors.toList());
                judgeQuestionIPage.setRecords(judgeQuestions);
                return Result.ok(judgeQuestionIPage);

            case "填空题":
                // 为填空题添加type字段，与前两种题型处理方式一致
                IPage<FillQuestion> fillQuestionIPage = fillQuestionService.lambdaQuery()
                        .eq(FillQuestion::getSubject, subject)
                        .page(answerVOPage);
                List<FillQuestion> fillQuestions = fillQuestionIPage.getRecords()
                        .stream()
                        .map(question -> {
                            question.setType("填空题");
                            return question;
                        })
                        .collect(Collectors.toList());
                fillQuestionIPage.setRecords(fillQuestions);
                return Result.ok(fillQuestionIPage);

            default:
                return Result.error("题型错误");
        }
    }

}
