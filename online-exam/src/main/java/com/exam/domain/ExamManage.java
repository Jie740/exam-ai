package com.exam.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 考试管理表
 * @TableName exam_manage
 */
@TableName(value ="exam_manage")
@Data
public class ExamManage {
    /**
     * 考试编号
     */
    @TableId(type = IdType.AUTO)
    private Integer examCode;

    /**
     * 该次考试介绍
     */
    private String description;

    /**
     * 课程名称
     */
    private String source;

    /**
     * 试卷编号
     */
    private Integer paperId;

    /**
     * 考试日期
     */
    private String examDate;

    /**
     * 持续时长
     */
    private Integer totalTime;

    /**
     * 年级
     */
    private String grade;

    /**
     * 学期
     */
    private String term;

    /**
     * 专业
     */
    private String major;

    /**
     * 学院
     */
    private String institute;

    /**
     * 总分
     */
    private Integer totalScore;

    /**
     * 考试类型
     */
    private String type;

    /**
     * 考生须知
     */
    private String tips;

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
        ExamManage other = (ExamManage) that;
        return (this.getExamCode() == null ? other.getExamCode() == null : this.getExamCode().equals(other.getExamCode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getPaperId() == null ? other.getPaperId() == null : this.getPaperId().equals(other.getPaperId()))
            && (this.getExamDate() == null ? other.getExamDate() == null : this.getExamDate().equals(other.getExamDate()))
            && (this.getTotalTime() == null ? other.getTotalTime() == null : this.getTotalTime().equals(other.getTotalTime()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getInstitute() == null ? other.getInstitute() == null : this.getInstitute().equals(other.getInstitute()))
            && (this.getTotalScore() == null ? other.getTotalScore() == null : this.getTotalScore().equals(other.getTotalScore()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTips() == null ? other.getTips() == null : this.getTips().equals(other.getTips()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExamCode() == null) ? 0 : getExamCode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getPaperId() == null) ? 0 : getPaperId().hashCode());
        result = prime * result + ((getExamDate() == null) ? 0 : getExamDate().hashCode());
        result = prime * result + ((getTotalTime() == null) ? 0 : getTotalTime().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getInstitute() == null) ? 0 : getInstitute().hashCode());
        result = prime * result + ((getTotalScore() == null) ? 0 : getTotalScore().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTips() == null) ? 0 : getTips().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examCode=").append(examCode);
        sb.append(", description=").append(description);
        sb.append(", source=").append(source);
        sb.append(", paperId=").append(paperId);
        sb.append(", examDate=").append(examDate);
        sb.append(", totalTime=").append(totalTime);
        sb.append(", grade=").append(grade);
        sb.append(", term=").append(term);
        sb.append(", major=").append(major);
        sb.append(", institute=").append(institute);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", type=").append(type);
        sb.append(", tips=").append(tips);
        sb.append("]");
        return sb.toString();
    }
}