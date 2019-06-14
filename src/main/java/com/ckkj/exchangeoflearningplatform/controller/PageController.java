package com.ckkj.exchangeoflearningplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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

    @RequestMapping("/recharge")
    public String rechange()
    {
        return "/login/phone-recharge/takeorder";
    }

    /**
     * 获取登陆名
     * @param request
     * @return
     */
    @RequestMapping(value = "/getusername", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }

    @RequestMapping("/wordIndex")
    public String wordIndex()
    {
        return "/wordIndex";
    }
}
