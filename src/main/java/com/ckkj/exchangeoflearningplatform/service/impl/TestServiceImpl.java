package com.ckkj.exchangeoflearningplatform.service.impl;

import com.ckkj.exchangeoflearningplatform.mapper.TestMapper;
import com.ckkj.exchangeoflearningplatform.model.Tests;
import com.ckkj.exchangeoflearningplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzh
 * create 2019-04-30-17:49
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public Tests findTest(Integer id) {
        Tests test = testMapper.findTest(id);
        return test;
    }
}
