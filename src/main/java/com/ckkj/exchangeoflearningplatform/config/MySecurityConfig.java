package com.ckkj.exchangeoflearningplatform.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lzh
 * create 2019-05-21-11:50
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/page/test1/**").hasRole("authority1")
                .antMatchers("/page/test2/**").hasRole("authority2");

        http.formLogin().usernameParameter("userName").passwordParameter("password").loginPage("/login");

        http.rememberMe().rememberMeParameter("remeber");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("llllll").password(new BCryptPasswordEncoder().encode("123123")).roles("authority1")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("456")).roles("authority2");

    }
}
