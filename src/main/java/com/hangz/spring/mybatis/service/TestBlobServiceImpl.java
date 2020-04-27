package com.hangz.spring.mybatis.service;

import com.google.common.collect.Lists;
import com.hangz.spring.mybatis.entity.Student;
import com.hangz.spring.mybatis.entity.TestBlob;
import com.hangz.spring.mybatis.mapper.TestBlobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author karl xie
 * Created on 2020-04-27 16:37
 */
@Service
public class TestBlobServiceImpl implements TestBlobService {

    @Autowired
    private TestBlobMapper testBlobMapper;


    public static byte[] obj2byte(Object obj) throws Exception {
        byte[] ret = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(obj);
        out.close();
        ret = baos.toByteArray();
        baos.close();
        return ret;
    }


    public static Object byte2obj(byte[] bytes) throws Exception {
        Object ret = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(bais);
        ret = in.readObject();
        in.close();
        return ret;
    }

    @Override
    public void testBlobInsert() {
        List<Student> students = Lists.newArrayList();
        byte[] bytes = null;
        for (int i = 0; i < 100000; i++) {
            students.add(Student.builder().age(i).name("test" + i).build());
        }
        try {
            bytes = obj2byte(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
        testBlobMapper.insert(TestBlob.builder().blobTest(bytes).build());
    }

    @Override
    public List<Student> testBlobGet(Integer id) {
        TestBlob testBlob = testBlobMapper.getById(id);
        List<Student> students=null;
        try {
             students= (List<Student>) byte2obj(testBlob.getBlobTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}