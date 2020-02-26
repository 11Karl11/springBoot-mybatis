package com.hangz.spring.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;

    private String name;

    private String url;

    private Integer parentId;

    private List<Menu> childMenu;
}