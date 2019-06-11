package com.ckkj.exchangeoflearningplatform.service.impl;

import com.ckkj.exchangeoflearningplatform.mapper.TempLoginMapper;
import com.ckkj.exchangeoflearningplatform.model.TempUser;
import com.ckkj.exchangeoflearningplatform.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 临时服务层
 *
 * @author lzh
 * create 2019-06-04-11:21
 */
@Service
public class TempServiceImpl implements TempService {

    @Autowired
    TempLoginMapper tempLoginMapper;

    @Override
    public int login(TempUser tempUser) {
        int count = tempLoginMapper.findUser(tempUser);
        return count;
    }

    @Override
    public int createTempUser(TempUser tempUser) {
        int count = tempLoginMapper.createTempUser(tempUser);
        return count;
    }

    @Override
    public String findTempNameByRid(String rid) {
        String userName = tempLoginMapper.findTempNameByRid(rid);
        return userName;
    }

    @Override
    public String findTempPassword(String tempUser) {
        return tempLoginMapper.findTempPassword(tempUser);
    }
}
