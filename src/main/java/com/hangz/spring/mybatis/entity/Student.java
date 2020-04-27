package com.hangz.spring.mybatis.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author karl xie
 * Created on 2020-04-27 16:45
 */
@Data
@Builder
public class Student implements Serializable {

    private Integer age;

    private String name;
}