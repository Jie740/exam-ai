package com.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.domain.ExamManage;

/**
* @author ajie
* @description 针对表【exam_manage(考试管理表)】的数据库操作Service
* @createDate 2025-10-16 00:20:56
*/
public interface ExamManageService extends IService<ExamManage> {

    ExamManage findOnlyPaperId();
}
