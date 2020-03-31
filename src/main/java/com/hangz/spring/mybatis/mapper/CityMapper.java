package com.hangz.spring.mybatis.mapper;

import com.hangz.spring.mybatis.entity.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}