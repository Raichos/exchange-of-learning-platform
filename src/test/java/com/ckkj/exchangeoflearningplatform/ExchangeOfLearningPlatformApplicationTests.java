package com.ckkj.exchangeoflearningplatform;

import com.ckkj.exchangeoflearningplatform.mapper.TempLoginMapper;
import com.ckkj.exchangeoflearningplatform.service.UserService;
import com.ckkj.exchangeoflearningplatform.status.MyStaute;
import com.ckkj.exchangeoflearningplatform.utils.QRCodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeOfLearningPlatformApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    TempLoginMapper tempLoginMapper;

    @Test
    public void contextLoads() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password1 = passwordEncoder.encode("123123");
        String password2 = passwordEncoder.encode("123");

        System.out.println(password1);
        System.out.println(password2);

        boolean iftrue1 = passwordEncoder.matches("123",password1);
        boolean iftrue2 = passwordEncoder.matches("123",password2);

        System.out.println("iftrue1="+iftrue1);
        System.out.println("iftrue2="+iftrue2);
    }

    @Test
    public void test01(){
        System.out.println("password="+new BCryptPasswordEncoder().encode("aaa"));
    }

    @Test
    public void test02(){
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        qrCodeUtil.qRCodeFactor();
    }

    @Test
    public void test03(){
        String userPassword = userService.findPasswordByUName("aaaaaa");
        boolean isTrue = new BCryptPasswordEncoder().matches("123123", userPassword);
        System.out.println("isTrue="+isTrue);

    }

    @Test
    public void test04(){
        String tempName = tempLoginMapper.findTempName();
        System.out.println("tempName="+tempName);
    }

    @Test
    public void test05(){
        System.out.println("MyStatue="+MyStaute.SUCCESS);;
        System.out.println("ClassType="+MyStaute.SUCCESS.getClass().toString());;
        System.out.println("equal="+(MyStaute.SUCCESS).equals(MyStaute.FALSE));
        System.out.println("equal="+(HttpStatus.FORBIDDEN).equals(HttpStatus.NOT_FOUND));
    }

}
