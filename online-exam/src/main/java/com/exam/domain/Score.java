package com.exam.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 成绩管理表
 * @TableName score
 */
@TableName(value ="score")
@Data
public class Score {
    /**
     * 分数编号
     */
    @TableId(type = IdType.AUTO)
    private Integer scoreId;

    /**
     * 考试编号
     */
    private Integer examCode;

    /**
     * 学号
     */
    private Integer studentId;

    /**
     * 课程名称
     */
    private String subject;

    /**
     * 平时成绩
     */
    private Integer ptScore;

    /**
     * 期末成绩
     */
    private Integer etScore;

    /**
     * 总成绩
     */
    private Integer score;

    /**
     * 答题日期
     */
    private String answerDate;

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
        Score other = (Score) that;
        return (this.getScoreId() == null ? other.getScoreId() == null : this.getScoreId().equals(other.getScoreId()))
            && (this.getExamCode() == null ? other.getExamCode() == null : this.getExamCode().equals(other.getExamCode()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getPtScore() == null ? other.getPtScore() == null : this.getPtScore().equals(other.getPtScore()))
            && (this.getEtScore() == null ? other.getEtScore() == null : this.getEtScore().equals(other.getEtScore()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getAnswerDate() == null ? other.getAnswerDate() == null : this.getAnswerDate().equals(other.getAnswerDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScoreId() == null) ? 0 : getScoreId().hashCode());
        result = prime * result + ((getExamCode() == null) ? 0 : getExamCode().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getPtScore() == null) ? 0 : getPtScore().hashCode());
        result = prime * result + ((getEtScore() == null) ? 0 : getEtScore().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getAnswerDate() == null) ? 0 : getAnswerDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", scoreId=").append(scoreId);
        sb.append(", examCode=").append(examCode);
        sb.append(", studentId=").append(studentId);
        sb.append(", subject=").append(subject);
        sb.append(", ptScore=").append(ptScore);
        sb.append(", etScore=").append(etScore);
        sb.append(", score=").append(score);
        sb.append(", answerDate=").append(answerDate);
        sb.append("]");
        return sb.toString();
    }
}