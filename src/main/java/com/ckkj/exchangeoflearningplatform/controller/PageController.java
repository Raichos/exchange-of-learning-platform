package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author lzh
 * create 2019-05-27-22:39
 */
@Controller
public class PageController {
    @Autowired
    UserService userService;

    @GetMapping("/resourceShare")
    public String resourceShare() {
        return "/resourceShare";
    }

    @RequestMapping("/userIndex")
    public String userIndex() {
        return "/userIndex";
    }

    //http://ip:8080/userCenter
    @RequestMapping("/userCenter")
    public String userCenter() {
        return "/userCenter";
    }

    @RequestMapping("/recharge")
    public String rechange() {
        return "/login/phone-recharge/takeorder";
    }

    /**
     * 获取登陆名
     *
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
    public String wordIndex() {
        return "/wordIndex";
    }

    /**
     * 积分充值或使用
     *
     * @return
     */
    @PostMapping("/useOrAddIntegral")
    @ResponseBody
    public String useOrAddIntegral(@RequestParam String userName, @RequestParam int integral) {
        System.out.println("userName = " + userName);
        System.out.println("integral = " + integral);
        userService.useOrAddIntegral(userName,integral);

        return "充值成功";
    }

    /**
     * 获取积分状态
     *
     * @param userName
     * @return
     */
    @GetMapping("/getIntegralStatus")
    @ResponseBody
    public String getIntegralStatus(@RequestParam String userName) {
        System.out.println("userName = " + userName);
        int integralStuats = userService.findIntegralStuats(userName);
        System.out.println("integralStuats = " + integralStuats);

        if (integralStuats == 1){
            userService.updateIntegralStuats(userName);
            return "支付成功";
        } else{

            return "";
        }

    }
}
