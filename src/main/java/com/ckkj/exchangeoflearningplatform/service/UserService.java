package com.ckkj.exchangeoflearningplatform.service;

import com.ckkj.exchangeoflearningplatform.model.User;

/**
 * @author lzh
 * create 2019-04-30-22:25
 */
public interface UserService {

    /**
     * 通过Id查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 用户登陆
     * @param userName
     * @param password
     * @return
     */
    int login(String userName, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 通过用户名查找密码
     * @param userName
     * @return
     */
    String findPasswordByUName(String userName);
}
