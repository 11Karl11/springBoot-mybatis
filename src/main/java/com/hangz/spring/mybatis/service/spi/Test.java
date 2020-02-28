package com.hangz.spring.mybatis.service.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 测试类
 *
 * @author karl xie
 * Created on 2020-02-27 18:55
 */
public class Test {
    public static void main(String[] args){
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = load.iterator();
        while (iterator.hasNext()){
            SpiService service = iterator.next();
            service.println();
        }
    }

}