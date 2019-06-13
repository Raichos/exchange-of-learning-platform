package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.model.TempUser;
import com.ckkj.exchangeoflearningplatform.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登出处理
 *
 * @author lzh
 * create 2019-06-05-17:25
 */
@Controller
public class LoginOut {

    @Autowired
    TempService tempService;

    @GetMapping("/phoneLoginOut")
    @ResponseBody
    public String loginout(){
        System.out.println("用户登出");
        //tempService.deleteUser(new TempUser(1,"000000","",""));

        return "logout";
    }
}
