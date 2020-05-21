package com.hangz.spring.mybatis.controller;

import com.hangz.spring.mybatis.entity.TestTk;
import com.hangz.spring.mybatis.entity.TestUser;
import com.hangz.spring.mybatis.service.TestTkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author karl xie
 * Created on 2020-05-21 09:41
 */
@RestController
@RequestMapping("/tk")
public class TKController {

    @Autowired
    private TestTkService testTkService;

    @PostMapping("/insert")
    public Integer insert(@RequestBody TestTk testTk) {
        return testTkService.insert(testTk);
    }

    @GetMapping("/get")
    public TestTk insert(Integer id, String tenantCode) {
        return testTkService.getById(id, tenantCode);
    }


    @PostMapping("/update")
    public void update(@RequestBody TestTk testTk) {
        testTkService.update(testTk);
    }


    @DeleteMapping("/delete")
    public void delete(Integer id, String tenantCode) {
        testTkService.delete(id, tenantCode);
    }


}