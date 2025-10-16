package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.domain.Score;
import com.exam.mapper.ScoreMapper;
import com.exam.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author ajie
* @description 针对表【score(成绩管理表)】的数据库操作Service实现
* @createDate 2025-10-16 00:21:34
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService{
    @Autowired
    private ScoreMapper scoreMapper;


}




