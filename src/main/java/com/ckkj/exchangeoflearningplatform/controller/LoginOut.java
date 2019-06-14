package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.model.TempUser;
import com.ckkj.exchangeoflearningplatform.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
    public String loginout(HttpServletRequest request){
        System.out.println("用户登出");
        //tempService.deleteUser(new TempUser(1,"000000","",""));

        Principal principal = request.getUserPrincipal();
        String name = principal.getName();
        tempService.deleteUserInTemp(name);

        return "logout";
    }
}
