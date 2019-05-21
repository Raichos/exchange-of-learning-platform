package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.utils.MD5Utils;
import com.ckkj.exchangeoflearningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author lzh
 * create 2019-04-30-22:02
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/loginuser")
    public String userLogin(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            HttpSession session) {
        password = MD5Utils.md5(password);
        int count = userService.login(userName, password);
        if (count > 0) {
            session.setAttribute("loginUser",userName);
            System.out.println("URL="+session.getAttribute("requestUrl"));
            if (((String)session.getAttribute("requestUrl")).equals("") || (session.getAttribute("requestUrl") == null)){
                return "success";
            } else {
                String requestUrl = (String) session.getAttribute("requestUrl");
                session.setAttribute("requestUrl","");
                return requestUrl;
            }
        } else {
            return "loginFalse";
        }
    }

    @GetMapping("/users/sign_in")
    public String register(){
        return "login/register";
    }

}
