package com.hangz.spring.mybatis.service;

import com.hangz.spring.mybatis.entity.Menu;
import com.hangz.spring.mybatis.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author karl xie
 * Created on 2020-02-26 17:33
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;


    public List<Menu> test1(Integer parentId) {
        return menuMapper.test1(parentId);
    }
}