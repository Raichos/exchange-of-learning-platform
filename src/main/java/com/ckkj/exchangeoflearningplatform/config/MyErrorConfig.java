package com.ckkj.exchangeoflearningplatform.config;

import com.ckkj.exchangeoflearningplatform.status.MyStaute;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author lzh
 * create 2019-05-30-20:53
 */
@Configuration
public class MyErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage page403 = new ErrorPage(HttpStatus.FORBIDDEN,"/403");
        ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404");
        ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
        registry.addErrorPages(page404,page500);
    }
}
