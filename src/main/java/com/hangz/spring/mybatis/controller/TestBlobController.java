package com.hangz.spring.mybatis.controller;

import com.hangz.spring.mybatis.entity.Student;
import com.hangz.spring.mybatis.service.TestBlobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author karl xie
 * Created on 2020-04-27 16:44
 */
@RestController
@RequestMapping("/test/blob")
public class TestBlobController {

    @Autowired
    private TestBlobService testBlobService;

    @RequestMapping("/insert")
    public void testBlobInsert(){
        testBlobService.testBlobInsert();
    }


    @RequestMapping("/get")
    public List<Student> testBlobGet(Integer id){
        return testBlobService.testBlobGet(id);
    }

}