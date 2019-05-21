package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.model.User;
import com.ckkj.exchangeoflearningplatform.service.UserService;
import com.ckkj.exchangeoflearningplatform.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Random;

/**
 * @author lzh
 * create 2019-05-07-18:01
 */

@Controller
public class RegisterController {


    @Autowired
    UserService userService;
    @Autowired
    JavaMailSenderImpl mailSender;

    private String emailServiceCode;

    @PostMapping("/register")
    @ResponseBody
    public String register(User user, @RequestParam("emailCode") String emailCode, @RequestParam("emailSuffix") String emailSuffix) {

        user.setEmail(user.getEmail() + "@" + emailSuffix);
        user.setRegisterDate(new Date());

        if (!emailCode.equals(emailServiceCode)) {
            System.out.println("验证码不正确");
            emailServiceCode = "";
            return "false";
        }

        user.setPassword(MD5Utils.md5(user.getPassword()));
        int count = userService.register(user);
        if (count > 0){
            return "true";
        } else {
            return "false";
        }
    }

    @GetMapping("/user/login")
    public String userLogin() {
        return "/login/login";
    }

    @GetMapping("/emailcode")
    @ResponseBody
    public String emailCode(@RequestParam("email") String email) {
        System.out.println("email="+email);
        emailServiceCode = String.valueOf(new Random().nextInt(900000) + 100000);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("视拼购短视频注册验证码");
        message.setText("视拼购短视频注册验证码是：" + emailServiceCode);
        message.setTo(email);
        message.setFrom("1963342385@qq.com");
        mailSender.send(message);
        return "success";
    }

    @GetMapping("register")
    public String register(){
        return "/login/register";
    }
}
