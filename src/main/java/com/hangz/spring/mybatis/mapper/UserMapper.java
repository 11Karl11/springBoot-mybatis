package com.hangz.spring.mybatis.mapper;

import com.hangz.spring.mybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 谢郑伟
 * Created on 2020-01-19 16:05
 */
@Repository
public interface UserMapper {


    User Sel(int id);
}