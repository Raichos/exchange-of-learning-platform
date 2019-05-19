package com.ckkj.exchangeoflearningplatform.service;

import com.ckkj.exchangeoflearningplatform.model.User;

/**
 * @author lzh
 * create 2019-04-30-22:25
 */
public interface UserService {

    User findUserById(Integer id);

    int login(String userName, String password);

    int register(User user);
}
