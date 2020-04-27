package com.hangz.spring.mybatis.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestBlob {
    private Integer id;

    private byte[] blobTest;
}