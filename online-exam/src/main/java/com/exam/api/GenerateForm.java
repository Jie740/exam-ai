package com.exam.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerateForm {
    private String paperId; //试卷ID
    private String subject; //学科
    private String type; //题目类型
    private String knowledge; //知识点范围
    private String number; //题目数量
    private String score; //每题分值
}
