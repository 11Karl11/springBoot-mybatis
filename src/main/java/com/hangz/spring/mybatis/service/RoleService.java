package com.hangz.spring.mybatis.service;

import com.hangz.spring.mybatis.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author karl xie
 * Created on 2020-02-25 19:03
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;


}