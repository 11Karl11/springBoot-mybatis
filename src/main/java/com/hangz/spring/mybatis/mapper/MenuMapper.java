package com.hangz.spring.mybatis.mapper;

import com.hangz.spring.mybatis.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> test1(@Param("parentId") Integer parentId);

}