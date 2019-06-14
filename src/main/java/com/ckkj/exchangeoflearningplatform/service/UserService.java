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

    /**
     * 积分充值或使用
     * @param userName
     * @param number
     * @return
     */
    int useOrAddIntegral(String userName,int number);

    /**
     * 查询积分状态
     * @param userName
     * @return
     */
    int findIntegralStuats(String userName);

    /**
     * 充值成功或使用成功状态改变
     * @param userName
     */
    void updateIntegralStuats(String userName);
}
