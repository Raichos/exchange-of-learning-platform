package com.ckkj.exchangeoflearningplatform.config;


import com.ckkj.exchangeoflearningplatform.security.CustomUserDetailsService;
import com.ckkj.exchangeoflearningplatform.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lzh
 * create 2019-05-21-11:50
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                System.out.println("charSequence.toString()="+charSequence.toString());
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                //String password = MD5Utils.md5(charSequence.toString());
                //System.out.println("aaaaffff:::charSequence="+charSequence+",s="+s);
                //return s.equals(password);
                return new BCryptPasswordEncoder().matches(charSequence.toString(),s);
            }
        });
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers().permitAll()
                .antMatchers("/loginUser").permitAll()
                .anyRequest().authenticated();

        // 设置登陆页
        http.formLogin().loginPage("/login")
                .loginProcessingUrl("/loginUser")
                .defaultSuccessUrl("/index").permitAll()
                .and()
                .logout().permitAll();

        // 关闭CSRF跨域
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**", "/static/**","/lose/**","/register");
    }
}
