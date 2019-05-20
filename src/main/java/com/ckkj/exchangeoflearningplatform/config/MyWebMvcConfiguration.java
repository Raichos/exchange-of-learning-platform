package com.ckkj.exchangeoflearningplatform.config;

import com.ckkj.exchangeoflearningplatform.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lzh
 * create 2019-05-05-19:41
 */

@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有的请求
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register","/static/**","/loginUser","/emailcode");
    }
}
