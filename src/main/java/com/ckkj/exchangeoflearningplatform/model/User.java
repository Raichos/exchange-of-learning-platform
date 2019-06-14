package com.ckkj.exchangeoflearningplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lzh
 * create 2019-04-30-22:22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    private Integer id; //id
    private String userName; //用户名
    private String password; //用户密码
    private String email; //用户邮箱
    private Date loginDate; //登陆日期
    private Date registerDate; //注册日期
    private Integer integral; //积分
    private Integer integralStatus; //积分状态

}


