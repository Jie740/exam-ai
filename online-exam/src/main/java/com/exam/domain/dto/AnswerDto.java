package com.exam.domain.dto;

import lombok.Data;


/**
 * 试题答案数据传输对象，整合所有类型试题的字段
 */
@Data
public class AnswerDto {
    /**
     * 试题编号
     */
    private Integer questionId;

    /**
     * 考试科目
     */
    private String subject;

    /**
     * 试题内容（通用字段，适用于所有题型）
     */
    private String question;

    /**
     * 正确答案（适用于判断题、填空题等）
     */
    private String answer;

    /**
     * 题目解析
     */
    private String analysis;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 难度等级
     */
    private String level;

    /**
     * 所属章节
     */
    private String section;

    /**
     * 题型（选择题/判断题/填空题）
     */
    private String type;

    // 以下为选择题特有字段
    /**
     * 选项A
     */
    private String answerA;

    /**
     * 选项B
     */
    private String answerB;

    /**
     * 选项C
     */
    private String answerC;

    /**
     * 选项D
     */
    private String answerD;

    /**
     * 选择题正确答案（专门用于选择题）
     */
    private String rightAnswer;
}
