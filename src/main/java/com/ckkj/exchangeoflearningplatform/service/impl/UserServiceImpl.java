package com.ckkj.exchangeoflearningplatform.service.impl;

import com.ckkj.exchangeoflearningplatform.mapper.UserMapper;
import com.ckkj.exchangeoflearningplatform.model.TempUser;
import com.ckkj.exchangeoflearningplatform.model.User;
import com.ckkj.exchangeoflearningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzh
 * create 2019-04-30-22:26
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {

        return null;
    }

    @Override
    public int login(String userName, String password) {
        int count = userMapper.findUserByUserPassword(userName, password);
        return count;
    }

    @Override
    public int register(User user) {
        int count = userMapper.insertUser(user);
        return count;
    }

    @Override
    public String findPasswordByUName(String userName) {
        String Password = userMapper.findPasswordByName(userName);
        return Password;
    }

    @Override
    public int useOrAddIntegral(String userName, int number) {
        return userMapper.updateIntegral(userName,number);
    }

    @Override
    public int findIntegralStuats(String userName) {
        return userMapper.findIntegralStuats(userName);
    }

    @Override
    public void updateIntegralStuats(String userName) {
        userMapper.updateIntegralStuats(userName);
    }

    @Override
    public int getIntegralByName(String userName) {
        return userMapper.getIntegralByName(userName);
    }
}
