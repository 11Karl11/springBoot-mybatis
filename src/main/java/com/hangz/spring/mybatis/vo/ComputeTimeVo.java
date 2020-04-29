package com.hangz.spring.mybatis.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author karl xie
 * Created on 2020-04-27 11:10
 */
@Data
@Builder
public class ComputeTimeVo implements Serializable {

    private Date beginTime;

    private Date endTime;

    private Double value;

    private Integer id;

}