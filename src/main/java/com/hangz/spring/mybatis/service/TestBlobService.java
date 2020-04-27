package com.hangz.spring.mybatis.service;

import com.hangz.spring.mybatis.entity.Student;

import java.util.List;

/**
 * @author karl xie
 * Created on 2020-04-27 16:35
 */
public interface TestBlobService {
    void testBlobInsert();


    List<Student> testBlobGet(Integer id);
}