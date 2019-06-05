package com.ckkj.exchangeoflearningplatform.service;

import com.ckkj.exchangeoflearningplatform.model.TempUser;

/**
 * 二维码扫描登陆
 *
 * @author lzh
 * create 2019-06-04-11:18
 */
public interface TempService {

    /**
     * 二维码扫描登陆
     * @param tempUser
     * @return
     */
    int login(TempUser tempUser);

    /**
     * 登陆成功记录
     * @param tempUser
     * @return
     */
    int update(TempUser tempUser);

    /**
     * 查找临时表id=1的用户名
     * @return
     */
    String findTempName();

    /**
     * 查找临时表密码
     * @return
     */
    String findTempPassword(String tempUser);
}
