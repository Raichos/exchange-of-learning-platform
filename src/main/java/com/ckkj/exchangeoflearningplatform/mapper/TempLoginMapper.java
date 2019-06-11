package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.TempUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT user_name FROM temp_login WHERE rid = #{rid}")
    String findTempNameByRid(String rid);

    @Select("SELECT password FROM temp_login WHERE user_name = #{tempUser}")
    String findTempPassword(String tempUser);

    @Insert("INSERT INTO temp_login (user_name,password,rid) VALUES (#{userName},#{password},#{rid})")
    int createTempUser(TempUser tempUser);

}
