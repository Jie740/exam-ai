//package com.exam.controller;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.exam.util.Result;
//import com.exam.service.impl.MessageServiceImpl;
//import com.exam.util.ResultHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class MessageController {
//
//    @Autowired
//    private MessageService messageService;
//
//    @GetMapping("/messages/{page}/{size}")
//    public Result<Message> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
//        Page<Message> messagePage = new Page<>(page,size);
//        IPage<Message> all = messageService.findAll(messagePage);
//        return Result.ok(200,"查询所有留言",all);
//    }
//
//    @GetMapping("/message/{id}")
//    public Result findById(@PathVariable("id") Integer id) {
//        Message res = messageService.findById(id);
//        return Result.ok(200,"根据Id查询",res);
//    }
//
//    @DeleteMapping("/message/{id}")
//    public int delete(@PathVariable("id") Integer id) {
//        int res = messageService.delete(id);
//        return res;
//    }
//
//    @PostMapping("/message")
//    public Result add(@RequestBody Message message) {
//        int res = messageService.add(message);
//        if (res == 0) {
//            return Result.ok(400,"添加失败",res);
//        } else {
//            return Result.ok(200,"添加成功",res);
//        }
//    }
//}
