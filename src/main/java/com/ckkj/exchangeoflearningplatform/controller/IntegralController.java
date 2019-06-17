package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 积分控制类
 *
 * @author lzh
 * create 2019-06-17-18:04
 */
@Controller
public class IntegralController {

    @Autowired
    UserService userService;

    /**
     * 获取积分
     * @param userName
     * @return
     */
    @GetMapping("/getIntegral")
    @ResponseBody
    public int getIntegralByName(@RequestParam("userName") String userName){

        return userService.getIntegralByName(userName);
    }
}
