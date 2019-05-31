package com.ckkj.exchangeoflearningplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lzh
 * create 2019-05-30-20:59
 */
@Controller
public class ErrorController {

    @GetMapping("/404")
    public String error404(){
        return "error/404";
    }

    @GetMapping("/500")
    public String error500(){
        return "error/500";
    }
}
