package com.hangz.spring.mybatis.service.spi;

import lombok.extern.slf4j.Slf4j;

/**
 * @author karl xie
 * Created on 2020-02-27 18:45
 */
@Slf4j
public class SpiServiceImpl implements SpiService {

    @Override
    public void println() {
      log.info("-----------------");
    }
}