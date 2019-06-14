package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 积分充值或使用
     */
    @Update("UPDATE users SET integral = integral+#{number},integral_status = 1 WHERE user_name = #{userName}")
    int updateIntegral(String userName,int number);

    /**
     * 查询积分状态
     * @param userName
     * @return
     */
    @Select("SELECT integral_status FROM users WHERE user_name = #{userName}")
    int findIntegralStuats(String userName);

    /**
     * 充值成功或使用成功状态改变
     * @param userName
     */
    @Update("UPDATE users SET integral_status = 0 WHERE user_name = #{userName}")
    void updateIntegralStuats(String userName);
}