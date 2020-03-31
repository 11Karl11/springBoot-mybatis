package com.hangz.spring.mybatis.utils;

import lombok.Getter;

/**
 * @author karl xie
 * Created on 2020-03-31 19:56
 */
@Getter
public class JsonResult2<T> {

    private Integer code;

    private String message;

    private String status;

    private T data;

    private String hint;

    private enum StatusCode {
        /** 成功. */
        success,
        /** 失败. */
        fail,
        /** 错误. */
        error
    }

    /**
     * Json Result Constructor.
     *
     * @param code 返回码
     * @param status 返回状态值.
     */
    private JsonResult2(ResultCode code, String status) {
        this.code = code.code;
        if (InternationalUtils.isCN()) {
            this.message = code.cn;
        } else {
            this.message = code.en;
        }
        this.status = status;
    }

    /**
     * Json Result Constructor.
     *
     * @param data 数据
     * @param code 返回码
     * @param status 返回状态值.
     */
    private JsonResult2(T data, ResultCode code, String status) {
        this(code, status);
        this.data = data;
    }

    public static <T> JsonResult2<T> ok() {
        return new JsonResult2<>(ResultCode.success, StatusCode.success.name());
    }

    public static <T> JsonResult2<T> ok(T data) {
        return new JsonResult2<>(data, ResultCode.success, StatusCode.success.name());
    }

    /**
     * 业务失败结果附带提示.
     *
     * @param hint 提示字符串.
     * @param resultCode {@link ResultCode}
     * @return json result
     */
    public static <T> JsonResult2<T> fail(String hint, ResultCode resultCode) {
        JsonResult2<T> res = new JsonResult2<>(resultCode, StatusCode.fail.name());
        res.hint = hint;
        return res;
    }

    /**
     * 业务失败结果.
     *
     * @param resultCode {@link ResultCode}
     * @return fail json result
     */
    public static <T> JsonResult2<T> fail(ResultCode resultCode) {
        return new JsonResult2<>(resultCode, StatusCode.fail.name());
    }

    /**
     * 系统异常.
     *
     * @return error json result
     */
    public static <T> JsonResult2<T> error() {
        return new JsonResult2<>(ResultCode.internal_server_error, StatusCode.error.name());
    }

    public static <T> JsonResult2<T> error(T data) {
        return new JsonResult2<>(data, ResultCode.internal_server_error, StatusCode.error.name());
    }
}
