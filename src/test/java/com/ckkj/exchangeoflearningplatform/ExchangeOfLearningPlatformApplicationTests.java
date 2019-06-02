package com.ckkj.exchangeoflearningplatform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeOfLearningPlatformApplicationTests {

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

}
