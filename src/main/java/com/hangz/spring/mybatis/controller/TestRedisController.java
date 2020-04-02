package com.hangz.spring.mybatis.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.hangz.spring.mybatis.entity.City;
import com.hangz.spring.mybatis.service.CityService;
import com.hangz.spring.mybatis.utils.JsonResult;
import com.hangz.spring.mybatis.utils.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author karl xie
 * Created on 2020-03-31 14:30
 */
@Api(description = "redis测试")
@RestController
@RequestMapping("/city")
public class TestRedisController {

    @Autowired
    private CityService cityService;

    @Autowired
    private RedisService redisService;

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


    @ApiOperation("测试简单缓存")
    @GetMapping("simple")
    public JsonResult simpleTest(){
        List<City> citys = cityService.getAll();
        String key="redis:simple"+citys.get(0).getId();
        redisService.set(key,citys.get(0));
        City city1=(City) redisService.get(key);
        return JsonResult.ok(city1);
    }

    @ApiOperation("测试Hash结构的缓存")
    @RequestMapping(value = "/hashTest", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult hashTest() {
        List<City> citys = cityService.getAll();
        City city = citys.get(0);
        String key = "redis:hash:" + city.getId();
        HashMap<String, Object> map = new HashMap<>();
        map.put(key,city);
        redisService.hSetAll(key, map);
        Map<Object, Object> cacheValue = redisService.hGetAll(key);
        Object object = cacheValue.get(key);
        return JsonResult.ok(object);
    }



    @ApiOperation("测试Set结构的缓存")
    @RequestMapping(value = "/setTest", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult setTest() {
        List<City> citys = cityService.getAll();
        String key = "redis:set:all";
        redisService.sAdd(key, citys.toArray());
        redisService.sRemove(key, citys.get(0));
        redisService.sRemove(key, citys.get(1));
        Set<Object> cachedBrandList = redisService.sMembers(key);
        return JsonResult.ok(cachedBrandList);
    }


    @ApiOperation("测试List结构的缓存")
    @RequestMapping(value = "/listTest", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listTest() {
        List<City> citys = cityService.getAll();
        String key = "redis:list:all";
        redisService.lPushAll(key, citys.toArray());
        redisService.lRemove(key, 1, citys.get(0));
        List<Object> cityLi = redisService.lRange(key, 0, 2);
        return JsonResult.ok(cityLi);
    }




}