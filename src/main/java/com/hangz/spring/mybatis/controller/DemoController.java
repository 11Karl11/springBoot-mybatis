package com.hangz.spring.mybatis.controller;

import com.hangz.spring.mybatis.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author karl xie
 * Created on 2020-10-31 16:02
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("test1")
    public void test(){
        menuService.test9();
    }
}