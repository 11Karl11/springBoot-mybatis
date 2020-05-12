package com.hangz.spring.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import static com.hangz.spring.mybatis.demo.TestPng2Gif.generatePreview;
import static com.hangz.spring.mybatis.demo.TestPng2Gif.getFiles;

/**
 * @author karl xie
 * Created on 2020-05-11 16:53
 */
@RestController
@RequestMapping("/gif")
public class TestGifController {

    @RequestMapping("test")
    public void test1() throws IOException {
        File[] files = getFiles("C:\\Users\\akang\\Desktop\\png");
        File file = generatePreview(files);


        FileInputStream fis = new FileInputStream(file);
        //将文件复制到指定路径下
        FileOutputStream fos=new FileOutputStream("C:\\Users\\akang\\Desktop\\gif\\1.gif");
        byte[] lsy=new byte[fis.available()];//定义字节数组用来当作缓冲区
        fis.read(lsy);//将文件以字节流形式读入缓冲区字节数组
        fos.write(lsy);//从缓冲区字节数组中以字节流形式取出
        fos.close();//关闭读取流
        fis.close();//关闭写入流
        File file1=new File("C:\\Users\\akang\\Desktop\\gif\\1.gif");//创建文件对象
        if(file1.exists()){//if语句的条件，调用exists方法判断文件是否存在
            System.out.println("文件成功复制到指定路径下");//若文件存在，则输出文件存在
        }
        else{//否则
            System.out.println("文件复制失败");//输出文件不存在
        }
    }

}