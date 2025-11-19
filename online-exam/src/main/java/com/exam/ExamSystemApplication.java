package com.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.exam.mapper")
@EnableCaching
@EnableAsync
public class ExamSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamSystemApplication.class, args);
    }
}
