package com.hangz.spring.mybatis.mapper;

import com.hangz.spring.mybatis.entity.TestBlob;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBlobMapper {
    int insert(TestBlob record);

    int insertSelective(TestBlob record);

    TestBlob getById(Integer id);
}