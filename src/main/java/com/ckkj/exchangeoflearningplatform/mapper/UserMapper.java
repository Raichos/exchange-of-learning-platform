package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.TempUser;
import com.ckkj.exchangeoflearningplatform.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lzh
 * create 2019-04-30-22:27
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findTest(Integer id);

    @Select("SELECT count(*) FROM users WHERE user_name = #{userName} and password = #{password}")
    int findUserByUserPassword(String userName, String password);

   /* @Select("SELECT user_name,password FROM users WHERE user_name = #{userName} AND password = #{password}")
    TempUser findUserByName(TempUser tempUser);*/

    @Insert("INSERT INTO users (user_name,PASSWORD,email,register_date) VALUES (#{userName},#{password},#{email},#{registerDate});")
    int insertUser(User user);

    @Select("SELECT password FROM users WHERE user_name = #{userName}")
    String findPasswordByName(String userName);

}