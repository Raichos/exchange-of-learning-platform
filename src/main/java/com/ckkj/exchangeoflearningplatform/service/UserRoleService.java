package com.ckkj.exchangeoflearningplatform.service;

import com.ckkj.exchangeoflearningplatform.model.Role;
import com.ckkj.exchangeoflearningplatform.model.User;
import com.ckkj.exchangeoflearningplatform.model.UserRole;

import java.util.List;

/**
 * @author lzh
 * create 2019-05-23-20:24
 */
public interface UserRoleService {

    User selectByName(String username);

    List<UserRole> listByUserId(Integer id);

    Role selectById(Integer roleId);
}
