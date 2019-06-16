package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.model.TempUser;
import com.ckkj.exchangeoflearningplatform.service.TempService;
import com.ckkj.exchangeoflearningplatform.service.UserService;
import com.ckkj.exchangeoflearningplatform.status.MyStaute;
import com.ckkj.exchangeoflearningplatform.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/**
 * @author lzh
 * create 2019-04-30-22:02
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    TempService tempService;

    /*@PostMapping("/loginUser")
    public String userLogin(@RequestParam("username") String userName,
                            @RequestParam("password") String password,
                            HttpSession session) {
        System.out.println("进入登陆");
        password = MD5Utils.md5(password);
        int count = userService.login(userName, password);
        if (count > 0) {
            session.setAttribute("loginUser",userName);
            System.out.println("URL="+session.getAttribute("requestUrl"));
            if ("".equals((String)session.getAttribute("requestUrl")) || (session.getAttribute("requestUrl") == null)){
                return "index";
            } else {
                String requestUrl = (String) session.getAttribute("requestUrl");
                session.setAttribute("requestUrl","");
                return requestUrl;
            }
        } else {
            return "loginFalse";
        }
    }*/

    @RequestMapping("/phone")
    public String phone(){
        System.out.println("phone");
        return "/login/phone-login/login-all";
    }

    @RequestMapping("/phoneUser")
    public String phoneUser(){
        return "/login/phone-login/logintype";
    }

    @RequestMapping("/phoneLoginSuccess")
    public String phoneLoginSuccess(){
        return "/login/phone-login/login-success";
    }


    /**
     * 二维码扫描提交
     * @param tempUser
     * @return
     */
    @PostMapping("/phoneLogin")
    @ResponseBody
    public int phoneLogin(TempUser tempUser){

        System.out.println("TempUser="+tempUser);

        //查找用户
        String userPassword = userService.findPasswordByUName(tempUser.getUserName());
        System.out.println("tempUser.getPassword"+tempUser.getPassword()+"userPassword"+userPassword);
        boolean isTrue = new BCryptPasswordEncoder().matches(tempUser.getPassword(), userPassword);

        System.out.println("isTrue="+isTrue);

        if (!isTrue){
            return 0;
        }

        //记录扫描登陆用户
        int count = tempService.createTempUser(tempUser);
        System.out.println("TempUser保存成功");

        return count;
    }

    @PostMapping("/qrlogin")
    @ResponseBody
    public TempUser qrlogin(@RequestParam("rid") String rid){

        String tempName = tempService.findTempNameByRid(rid);

        //System.out.println("userName="+tempName);

        if ("000000".equals(tempName) || "".equals(tempName) || tempName ==null){
            //return MyStaute.FALSE;
            //System.out.println("false");
            return null;
        }

        String tempPassword = tempService.findTempPassword(tempName,rid);

        return new TempUser(-1,tempName,tempPassword,"temp");
    }

    @GetMapping("/users/sign_in")
    public String register(){
        return "login/register";
    }

    @GetMapping("/index")
    public String success(){
        return "/index";
    }

    @GetMapping("/share")
    public String share(){
        return "/resourceShare";
    }
}
