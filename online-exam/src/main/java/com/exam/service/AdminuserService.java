package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.domain.Adminuser;

/**
* @author ajie
* @description 针对表【adminuser(管理员信息表)】的数据库操作Service
* @createDate 2025-10-16 00:20:46
*/
public interface AdminuserService extends IService<Adminuser> {

    Adminuser login(Integer username, String password);
}
