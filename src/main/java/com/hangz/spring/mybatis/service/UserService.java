package com.hangz.spring.mybatis.service;

import com.hangz.spring.mybatis.entity.User;
import com.hangz.spring.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢郑伟
 * Created on 2020-01-19 16:04
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public User Sel(int id) {
        return userMapper.Sel(id);

    }
    }