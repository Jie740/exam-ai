package com.exam.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 教师信息表
 * @TableName teacher
 */
@TableName(value ="teacher")
@Data
public class Teacher {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long teacherId;

    /**
     * 姓名
     */
    private String teacherName;

    /**
     * 学院
     */
    private String institute;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 身份证号
     */
    private String cardId;

    /**
     * 职称
     */
    private String type;

    /**
     * 角色（0管理员，1教师，2学生）
     */
    private String role;

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
        Teacher other = (Teacher) that;
        return (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()))
            && (this.getInstitute() == null ? other.getInstitute() == null : this.getInstitute().equals(other.getInstitute()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        result = prime * result + ((getInstitute() == null) ? 0 : getInstitute().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherId=").append(teacherId);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", institute=").append(institute);
        sb.append(", sex=").append(sex);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", pwd=").append(pwd);
        sb.append(", cardId=").append(cardId);
        sb.append(", type=").append(type);
        sb.append(", role=").append(role);
        sb.append("]");
        return sb.toString();
    }
}