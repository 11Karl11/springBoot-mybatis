package com.hangz.spring.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class TestUser {
    private String id;

    private String username;

    private String password;

    private String address;

    private String email;

    private Role role;

    private List<Role> roles;


    public TestUser(String id, String username) {
        this.id = id+"--------------";
        this.username = username+"99999999999999";
    }
}