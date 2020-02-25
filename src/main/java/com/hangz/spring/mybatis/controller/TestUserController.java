package com.hangz.spring.mybatis.controller;

import com.hangz.spring.mybatis.entity.TestUser;
import com.hangz.spring.mybatis.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢郑伟
 * Created on 2020-01-21 09:23
 */
@RestController
@RequestMapping("/testUser")
public class TestUserController {


    @Autowired
    private TestUserService testUserService;



    @RequestMapping("/getById")
    public TestUser getById(Integer id){

        return testUserService.getById(id);
    }

    //测试简单的resultMap
    @RequestMapping("/test1")
    public TestUser test1(Integer id){

        return testUserService.test1(id);
    }

    //测试关联
    @RequestMapping("/test1")
    public TestUser test2(Integer id){
        return testUserService.test2(id);
    }



}