package com.hangz.spring.mybatis.entity;

import lombok.Data;

/**
 * @author 谢郑伟
 * Created on 2020-01-19 16:00
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

}