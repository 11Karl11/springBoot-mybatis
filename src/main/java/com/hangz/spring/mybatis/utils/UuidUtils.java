package com.hangz.spring.mybatis.utils;

import java.util.UUID;

/**
 * @author wolfgang zhu
 * @date created in 14:19 2018/8/21
 * @since 1.7
 */
public class UuidUtils {

  public static String uuid() {
    return UUID.randomUUID().toString();
  }

  public static String uuid32() {
    return uuid().replaceAll("-", "");
  }
}
