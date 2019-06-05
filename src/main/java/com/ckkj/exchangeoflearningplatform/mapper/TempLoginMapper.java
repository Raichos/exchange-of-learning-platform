package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.TempUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 二维码临时扫描
 *
 * @author lzh
 * create 2019-06-04-10:22
 */
@Mapper
public interface TempLoginMapper {

    @Select("SELECT count(*) FROM temp_login WHERE user_name = #{userName} AND password = #{password}")
    int findUser(TempUser tempUser);

    @Select("SELECT user_name FROM temp_login WHERE id = 1")
    String findTempName();

    @Select("SELECT password FROM temp_login WHERE user_name = #{tempUser}")
    String findTempPassword(String tempUser);

    @Update("UPDATE temp_login SET user_name=#{userName}, password = #{password}")
    int updateUser(TempUser tempUser);

}
