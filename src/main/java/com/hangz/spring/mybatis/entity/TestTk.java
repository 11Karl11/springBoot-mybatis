package com.hangz.spring.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
public class TestTk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    @Id
    private String tenantCode;

    private String tenant;

    private String location;

    private Integer uplineDuration;

    private Date createTime;

    private Date modifyTime;
}