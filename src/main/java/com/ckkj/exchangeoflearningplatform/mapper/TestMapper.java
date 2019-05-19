package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.Tests;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lzh
 * create 2019-04-30-17:49
 */

@Mapper
public interface TestMapper {

    @Select("select * from tests where id = #{id}")
    Tests findTest(Integer id);
}
