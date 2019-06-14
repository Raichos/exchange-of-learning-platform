package com.ckkj.exchangeoflearningplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/userIndex")
    public String userIndex(){
        return "/userIndex";
    }

    //http://ip:8080/userCenter
    @RequestMapping("/userCenter")
    public String userCenter()
    {
        return "/userCenter";
    }

    @RequestMapping("/wordIndex")
    public String wordIndex()
    {
        return "/wordIndex";
    }
}
