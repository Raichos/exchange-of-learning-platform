package com.ckkj.exchangeoflearningplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lzh
 * create 2019-05-27-22:39
 */
@Controller
public class PageController {

    @GetMapping("/resourceShare")
    public String resourceShare(){
        return "/resourceShare";
    }
}
