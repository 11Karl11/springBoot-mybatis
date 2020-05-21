package com.hangz.spring.mybatis.service;

import com.hangz.spring.mybatis.entity.TestTk;
import com.hangz.spring.mybatis.mapper.TestTkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author karl xie
 * Created on 2020-05-21 09:42
 */
@Service
public class TestTkService {

    @Autowired
    private TestTkMapper testTkMapper;


    public Integer insert(TestTk testTk) {
        testTk.setCreateTime(new Date());
        testTk.setModifyTime(new Date());
        testTkMapper.insert(testTk);
        return testTk.getId();
    }

    public TestTk getById(Integer id, String tenantCode) {
        return testTkMapper.selectByPrimaryKey(TestTk.builder().id(id).tenantCode(tenantCode).build());
    }

    public void update(TestTk testTk) {
        testTk.setModifyTime(new Date());
        testTkMapper.updateByPrimaryKeySelective(testTk);
    }

    public void delete(Integer id, String tenantCode) {
        testTkMapper.deleteByPrimaryKey(TestTk.builder().id(id).tenantCode(tenantCode).build());
    }
}