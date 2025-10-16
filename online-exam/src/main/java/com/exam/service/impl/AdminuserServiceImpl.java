package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.Adminuser;
import com.exam.mapper.AdminuserMapper;
import com.exam.service.AdminuserService;
import org.springframework.stereotype.Service;

/**
* @author ajie
* @description 针对表【adminuser(管理员信息表)】的数据库操作Service实现
* @createDate 2025-10-16 00:20:46
*/
@Service
public class AdminuserServiceImpl extends ServiceImpl<AdminuserMapper, Adminuser>
    implements AdminuserService{

    @Override
    public Adminuser login(Integer username, String password) {
        return this.lambdaQuery().eq(Adminuser::getAdminId, username).eq(Adminuser::getPwd, password).one();
    }
}




