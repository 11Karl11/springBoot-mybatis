package com.hangz.spring.mybatis.entity;

import lombok.Data;

@Data
public class TestUser {
    private Integer id;

    private String username;

    private String password;

    private String address;

    private String email;
}