package com.exam.mapper;

import com.exam.domain.Adminuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author ajie
* @description 针对表【adminuser(管理员信息表)】的数据库操作Mapper
* @createDate 2025-10-16 15:12:36
* @Entity com.exam.domain.Adminuser
*/
public interface AdminuserMapper extends BaseMapper<Adminuser> {
    @Select("select admin_name,sex,tel,email,card_id,role from adminuser")
    public List<Adminuser> findAll();

    @Select("select admin_name,sex,tel,email,card_id,role from adminuser where admin_id = #{adminId}")
    public Adminuser findById(Integer adminId);

    @Delete("delete from adminuser where admin_id = #{adminId}")
    public int deleteById(int adminId);

    @Update("update admin set admin_name = #{adminName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},card_id = #{cardId},role = #{role} where admin_id = #{adminId}")
    public int update(Adminuser admin);

    @Options(useGeneratedKeys = true,keyProperty = "adminId")
    @Insert("insert into admin(admin_name,sex,tel,email,pwd,card_id,role) " +
            "values(#{adminName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role})")
    public int add(Adminuser admin);
}




