package com.ckkj.exchangeoflearningplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@MapperScan("com.ckkj.exchangeoflearningplatform.mapper")
@SpringBootApplication
@Configuration
public class ExchangeOfLearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeOfLearningPlatformApplication.class, args);
    }



}
