package com.hangz.spring.mybatis.utils;


import java.security.SecureRandom;
import java.util.UUID;

/**
 * 随机数生成工具类.
 *
 * @author JetWang
 * @date 2016年4月26日-下午10:44:13
 */
public class RandomUtil {

    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 获取随机小数 {@link SecureRandom#nextDouble()}.
     *
     * @return random double.
     */
    public static double nextDouble() {
        return RANDOM.nextDouble();
    }

    /**
     * 获取随机数 {@link SecureRandom#nextInt()}.
     *
     * @return random double.
     */
    public static int nextInt() {
        return RANDOM.nextInt();
    }

    /**
     * 获取随机数 {@link SecureRandom#next(int)}.
     *
     * @return random int.
     */
    public static int nextInt(int round) {
        return RANDOM.nextInt(round);
    }

    /**
     * 获得随机字符串.
     *
     * @param passLength 字符串大小
     * @param type       1 数字 2 大写 3 小写 4 大小写复制 5 默认函数
     */
    public static String getCode(int passLength, int type) {
        StringBuilder sb = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        switch (type) {
            case 0:
                buffer = new StringBuilder("0123456789");
                break;
            case 1:
                buffer = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
                break;
            case 2:
                buffer = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 3:
                buffer =
                        new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                break;
            case 4:
                buffer =
                        new StringBuilder("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789=");
                sb.append(buffer.charAt(RANDOM.nextInt(buffer.length() - 10)));
                passLength -= 1;
                break;
            default:
                String uuid = UUID.randomUUID().toString();
                sb.append(uuid.substring(0, 8))
                        .append(uuid.substring(9, 13))
                        .append(uuid.substring(14, 18))
                        .append(uuid.substring(19, 23))
                        .append(uuid.substring(24));
        }

        if (type != 5) {
            int range = buffer.length();
            for (int i = 0; i < passLength; ++i) {
                sb.append(buffer.charAt(RANDOM.nextInt(range)));
            }
        }
        return sb.toString();
    }

    public static String uuid() {
        return UuidUtils.uuid32().toString();
    }
}
