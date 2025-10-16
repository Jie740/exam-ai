package com.exam.api;

import lombok.Data;

@Data
public class GenerateAnswer {
    private String paperId;     // 试卷ID
    private String subject;     // 学科
    private Long questionId;    // 题目ID
    private String question;    // 题干
    private String answerA;     // 选项A（选择题专用）
    private String answerB;     // 选项B
    private String answerC;     // 选项C
    private String answerD;     // 选项D
    private String rightAnswer; // 正确答案（选择题专用）
    private String answer;      // 填空题或判断题的答案
    private String analysis;    // 解析
    private Integer score;      // 分值
    private String section;     // 章节
    private String level;       // 难度等级
    private String type;        // 题型（选择题/填空题/判断题）
}