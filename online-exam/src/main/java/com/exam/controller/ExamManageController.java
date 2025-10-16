package com.exam.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.domain.ExamManage;
import com.exam.service.ExamManageService;
import com.exam.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExamManageController {

    @Autowired
    private ExamManageService examManageService;

    @GetMapping("/exams")
    public Result findAll(){
        System.out.println("不分页查询所有试卷");
        return Result.ok(examManageService.list());
    }

    @GetMapping("/exams/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page
            , @PathVariable("size") Integer size,
                          @RequestParam(value = "examName",required = false) String examName){
        System.out.println("分页查询所有试卷");
        Page<ExamManage> examManage = new Page<>(page,size);
        if (examName != null){
            return Result.ok(examManageService.lambdaQuery().like(ExamManage::getSource, examName).page(examManage));
        }
        return Result.ok(examManageService.page(examManage));
    }

    @GetMapping("/exam/{examCode}")
    public Result findById(@PathVariable("examCode") Integer examCode){
        System.out.println("根据ID查找");
        ExamManage res = examManageService.lambdaQuery().eq(ExamManage::getExamCode, examCode).one();
        if(res == null) {
            return Result.ok("考试编号不存在");
        }
        return Result.ok(res);
    }

    @DeleteMapping("/exam/{examCode}")
    public Result deleteById(@PathVariable("examCode") Integer examCode){
        examManageService.removeById(examCode);
        return Result.ok(examCode);
    }

    @PutMapping("/exam")
    public Result update(@RequestBody ExamManage exammanage){
        System.out.println("Date"+exammanage.getExamDate());
        //获取日期前缀
        String t = exammanage.getExamDate().split("T")[0];
        exammanage.setExamDate(t);

        System.out.println(exammanage);
        // 检查关键字段是否存在
        if (exammanage.getExamCode() == null) {
            return Result.error("考试编号不能为空");
        }

        boolean res = examManageService.updateById(exammanage);
        System.out.print("更新操作执行---");
        return Result.ok(exammanage);
    }


    @PostMapping("/exam")
    public Result add(@RequestBody ExamManage exammanage){
        int res = examManageService.save(exammanage)==true?1:0;
        if (res ==1) {
            return Result.ok(exammanage);
        } else {
            return  Result.ok("添加失败");
        }
    }

    @GetMapping("/examManagePaperId")
    public Result findOnlyPaperId() {
        ExamManage res = examManageService.findOnlyPaperId();
        if (res != null) {
            return Result.ok(res);
        }
        return Result.ok("请求失败");
    }

}
