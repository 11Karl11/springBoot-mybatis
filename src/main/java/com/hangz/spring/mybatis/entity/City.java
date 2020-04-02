package com.hangz.spring.mybatis.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class City implements Serializable {

    private static final long serialVersionUID = -4375807946335495127L;

    private Integer id;

    private String cityName;

    private String cityAcronym;

    private Integer provinceId;

    private Date createTime;

    private Date modifyTime;
}