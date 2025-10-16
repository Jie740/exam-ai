package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.ExamManage;
import com.exam.mapper.ExamManageMapper;
import com.exam.service.ExamManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author ajie
* @description 针对表【exam_manage(考试管理表)】的数据库操作Service实现
* @createDate 2025-10-16 00:20:56
*/
@Service
@RequiredArgsConstructor
public class ExamManageServiceImpl extends ServiceImpl<ExamManageMapper, ExamManage>
    implements ExamManageService{
    private final ExamManageMapper examManageMapper;

    @Override
    public ExamManage findOnlyPaperId() {
        return examManageMapper.findOnlyPaperId();
    }
}




