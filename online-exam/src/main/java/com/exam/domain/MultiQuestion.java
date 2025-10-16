package com.exam.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 选择题题库表
 * @TableName multi_question
 */
@TableName(value ="multi_question")
@Data
public class MultiQuestion {
    /**
     * 试题编号
     */
    @TableId(type = IdType.AUTO)
    private Integer questionId;

    /**
     * 考试科目
     */
    private String subject;

    /**
     * 问题题目
     */
    private String question;

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
     * 正确答案
     */
    private String rightAnswer;

    /**
     * 题目解析
     */
    private String analysis;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 所属章节
     */
    private String section;

    /**
     * 难度等级
     */
    private String level;
    @TableField(exist = false)
    private String type;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MultiQuestion other = (MultiQuestion) that;
        return (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getAnswerA() == null ? other.getAnswerA() == null : this.getAnswerA().equals(other.getAnswerA()))
            && (this.getAnswerB() == null ? other.getAnswerB() == null : this.getAnswerB().equals(other.getAnswerB()))
            && (this.getAnswerC() == null ? other.getAnswerC() == null : this.getAnswerC().equals(other.getAnswerC()))
            && (this.getAnswerD() == null ? other.getAnswerD() == null : this.getAnswerD().equals(other.getAnswerD()))
            && (this.getRightAnswer() == null ? other.getRightAnswer() == null : this.getRightAnswer().equals(other.getRightAnswer()))
            && (this.getAnalysis() == null ? other.getAnalysis() == null : this.getAnalysis().equals(other.getAnalysis()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getSection() == null ? other.getSection() == null : this.getSection().equals(other.getSection()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getAnswerA() == null) ? 0 : getAnswerA().hashCode());
        result = prime * result + ((getAnswerB() == null) ? 0 : getAnswerB().hashCode());
        result = prime * result + ((getAnswerC() == null) ? 0 : getAnswerC().hashCode());
        result = prime * result + ((getAnswerD() == null) ? 0 : getAnswerD().hashCode());
        result = prime * result + ((getRightAnswer() == null) ? 0 : getRightAnswer().hashCode());
        result = prime * result + ((getAnalysis() == null) ? 0 : getAnalysis().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getSection() == null) ? 0 : getSection().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", subject=").append(subject);
        sb.append(", question=").append(question);
        sb.append(", answerA=").append(answerA);
        sb.append(", answerB=").append(answerB);
        sb.append(", answerC=").append(answerC);
        sb.append(", answerD=").append(answerD);
        sb.append(", rightAnswer=").append(rightAnswer);
        sb.append(", analysis=").append(analysis);
        sb.append(", score=").append(score);
        sb.append(", section=").append(section);
        sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
    }
}