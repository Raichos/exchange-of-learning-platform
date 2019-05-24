package com.ckkj.exchangeoflearningplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ckkj.exchangeoflearningplatform.mapper")
@SpringBootApplication
public class ExchangeOfLearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeOfLearningPlatformApplication.class, args);
    }
}
