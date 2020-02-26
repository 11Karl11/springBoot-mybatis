package com.hangz.spring.mybatis.service;

import com.hangz.spring.mybatis.entity.TestUser;
import com.hangz.spring.mybatis.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢郑伟
 * Created on 2020-01-20 17:55
 */
@Service
public class TestUserService {


    @Autowired
    private TestUserMapper testUserMapper;

    public TestUser getById(Integer id) {
        return testUserMapper.selectByPrimaryKey(id);
    }

    public TestUser test1(Integer id) {
        return testUserMapper.test1(id);
    }

    public TestUser test2(Integer id) {
        return testUserMapper.test2(id);
    }

    public TestUser test3(int id) {
        return testUserMapper.test3(id);
    }

    public TestUser test21(Integer id) {
        return testUserMapper.test21(id);
    }
}