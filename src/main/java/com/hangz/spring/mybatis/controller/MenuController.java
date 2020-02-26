package com.hangz.spring.mybatis.controller;

import com.hangz.spring.mybatis.entity.Menu;
import com.hangz.spring.mybatis.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author karl xie
 * Created on 2020-02-26 17:35
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("test1")
    public List<Menu> test1(Integer parentId) {

        return menuService.test1(parentId);
    }

}