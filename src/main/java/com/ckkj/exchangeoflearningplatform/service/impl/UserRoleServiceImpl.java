package com.ckkj.exchangeoflearningplatform.service.impl;

import com.ckkj.exchangeoflearningplatform.mapper.UserRoleMapper;
import com.ckkj.exchangeoflearningplatform.model.Role;
import com.ckkj.exchangeoflearningplatform.model.User;
import com.ckkj.exchangeoflearningplatform.model.UserRole;
import com.ckkj.exchangeoflearningplatform.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzh
 * create 2019-05-23-20:24
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public User selectByName(String username) {
        return userRoleMapper.selectByName(username);
    }

    @Override
    public List<UserRole> listByUserId(Integer id) {
        return userRoleMapper.listByUserId(id);
    }

    @Override
    public Role selectById(Integer roleId) {
        return userRoleMapper.selectById(roleId);
    }
}
