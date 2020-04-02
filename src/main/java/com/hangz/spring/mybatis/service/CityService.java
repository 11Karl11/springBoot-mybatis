package com.hangz.spring.mybatis.service;

import com.hangz.spring.mybatis.config.RedisConfig;
import com.hangz.spring.mybatis.entity.City;
import com.hangz.spring.mybatis.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢郑伟
 * Created on 2020-03-31 14:33
 */
@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE, key = "'pms:brand:'+#id", unless = "#result==null")
    public City insert(City city){
        int i = cityMapper.insertSelective(city);
        city.setId(i);
        return city;
    }

    @CacheEvict(value = RedisConfig.REDIS_KEY_DATABASE, key = "'pms:brand:'+#id")
    public void delete(Integer id) {
        cityMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value = RedisConfig.REDIS_KEY_DATABASE, key = "'pms:brand:'+#id")
    public void update(Long id,City city) {
        cityMapper.updateByPrimaryKey(city);
    }

    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE, key = "'pms:brand:'+#id", unless = "#result==null")
    public City get(Integer id) {
        City city = cityMapper.selectByPrimaryKey(id);
        return city;
    }

    public List<City> getAll() {
        return cityMapper.getAll();
    }
}