package com.ckkj.exchangeoflearningplatform.security;

import com.ckkj.exchangeoflearningplatform.model.Role;
import com.ckkj.exchangeoflearningplatform.model.UserRole;
import com.ckkj.exchangeoflearningplatform.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lzh
 * create 2019-05-22-21:28
 */
@Service(value = "userDetailService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRoleService userRoleService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername");

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        com.ckkj.exchangeoflearningplatform.model.User user = userRoleService.selectByName(s);

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        List<UserRole> userRoles = userRoleService.listByUserId(user.getId());
        for (UserRole userRole : userRoles) {
            Role role = userRoleService.selectById(userRole.getRoleId());
            System.out.println("role.getName()="+role.getName());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        System.out.println("authorities"+authorities);

        // 返回UserDetails实现类
        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}
