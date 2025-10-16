package com.exam.controller;

import com.exam.domain.Adminuser;
import com.exam.service.AdminuserService;
import com.exam.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminuserService adminService;

    @GetMapping("/admins")
    public Result findAll(){
        System.out.println("查询全部");
        return Result.ok(adminService.list());
    }

    @GetMapping("/admin/{adminId}")
    public Result findById(@PathVariable("adminId") Integer adminId){
        System.out.println("根据ID查找");
        return Result.ok(adminService.lambdaQuery().eq(Adminuser::getAdminId, adminId).one());
    }

    @DeleteMapping("/admin/{adminId}")
    public Result deleteById(@PathVariable("adminId") Integer adminId){
        adminService.removeById(adminId);
        return Result.ok();
    }

    @PutMapping("/admin/{adminId}")
    public Result update(@PathVariable("adminId") Integer adminId, Adminuser admin){
        return Result.ok(adminService.lambdaUpdate().eq(Adminuser::getAdminId, admin).update());
    }

    @PostMapping("/admin")
    public Result add(Adminuser admin){
        return Result.ok(adminService.save(admin));
    }
}
