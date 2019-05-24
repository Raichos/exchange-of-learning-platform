package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.Role;
import com.ckkj.exchangeoflearningplatform.model.User;
import com.ckkj.exchangeoflearningplatform.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lzh
 * create 2019-05-23-20:14
 */

@Mapper
public interface UserRoleMapper {

    @Select("SELECT * FROM users where user_name = #{username}")
    User selectByName(String username);

    @Select("SELECT * FROM user_role where id = #{id}")
    List<UserRole> listByUserId(Integer id);

    @Select("SELECT * FROM role where id = #{id}")
    Role selectById(Integer roleId);
}
