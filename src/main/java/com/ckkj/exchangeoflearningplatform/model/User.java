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

    private Integer id;
    private String userName;
    private String password;
    private String email;
    private Date loginDate;
    private Date registerDate;

}


