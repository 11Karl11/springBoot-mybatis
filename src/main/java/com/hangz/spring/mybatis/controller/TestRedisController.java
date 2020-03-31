package com.hangz.spring.mybatis.controller;

import com.hangz.spring.mybatis.entity.City;
import com.hangz.spring.mybatis.service.CityService;
import com.hangz.spring.mybatis.utils.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karl xie
 * Created on 2020-03-31 14:30
 */
@RestController
@RequestMapping("/city")
public class TestRedisController {

    @Autowired
    private CityService cityService;

    @RequestMapping("add")
    public City insert(@RequestBody City city){
        return (cityService.insert(city));
    }

    @RequestMapping("delete")
    public void delete(Integer id){
        cityService.delete(id);
    }

    @RequestMapping("update")
    public void update(Long id,@RequestBody City city){
        cityService.update(id,city);
    }

    @RequestMapping("get")
    public City get(Integer id){
        return (cityService.get(id));
    }



    @Autowired
    private RedisService redisService;




}