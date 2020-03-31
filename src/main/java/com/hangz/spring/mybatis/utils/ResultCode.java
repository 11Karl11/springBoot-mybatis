package com.hangz.spring.mybatis.utils;

/**
 * @author karl xie
 * Created on 2020-03-31 19:57
 */
public enum ResultCode {
    /**
     * 通用返回编码.
     */
    success(200, "success", "成功"),

    illegal_argument(101, "argument is wrong", "请求参数错误"),

    illegal_tenant(102, "tenant code is wrong", "错误的tenant请求"),

    RECORD_NOT_FOUND(106, "record is not found", "记录不存在"),

    internal_server_error(500, "internal server error", "服务器错误"),

    unknown_reason(105, "Unknown reason", "未知错误"),

    UNAUTHENTICATED(401, "Authentication Fail", "认证失败"),

    UNAUTHORIZED(405, "Authorized Fail", "授权失败"),

    LENGTH_EXCEEDED_LIMIT(103, "Parametric length exceeded limit", "参数长度超出了限制"),

    BREAK_UNIQUENESS(104, "The information already exists, please fill again", "填写内容已存在,请重新填写"),
    /**
     * 文件相关返回编码.
     */
    file_type_not_support(1001, "file type mismatch!", "文件类型不匹配"),

    file_size_too_large(1002, "file size is larger than the required!", "文件大小超过限制"),

    file_name_too_long(1003, "file name is too long", "文件名过长"),

    file_not_exists(1004, "file isn't exists", "文件不存在"),

    file_upload_defeated(1007, "file upload defeated", "文件上传失败"),
    file_analysis_defeated(1008, "file analysis defeated", "文件解析失败"),

    /**
     * rail.
     */
    ROUTE_NONENTITY(1005, "the name already exists", "记录不存在"),

    RECORD_VALUE_ALREADY_EXISTS(1006, "the record value already exists", "记录值不能重复"),

    /**
     * socket.
     */
    DEVICE_NOT_CONNECTED(1100, "device is disconnected", "设备未连接"),

    check_repeat(1200, "field violate unique check", "字段重复"),

    /**
     * configuration.
     */
    MISSING_CONFIGURATION(2001, "Missing Configuration", "缺少配置"),

    CONFIGURATION_WRONG(2005, "The configuration is wrong", "配置有误"),

    CONFIGURATION_DUPLICATE(2002, "Configuration Duplicate", "配置已存在"),

    /**
     * 验证码使用.
     */
    MISSING_LONGITUDE_OR_LATITUDE(2003, "longitude or latitude missIng", "缺少经纬度"),

    BIND_FAIL(2004, "bind fail", "绑定失败"),
    CHARACTER_EXCEEDS_PARAMETER_LIMIT(3001, "Character exceeds parameter limit", "字符超出参数限制"),

    /**
     * 验证码使用. *
     */
    INVALID_VERIFICATION_CODE(9002, "Invalid verification code", "验证码无效"),
    VERIFICATION_CODE_HAS_EXPIRED(9003, "The verification code has expired", "验证码已经过期"),
    VERIFICATION_CODE_IS_NOT_CORRECT(9004, "The verification code is not correct", "验证码不正确"),
    VOTE_MAX(9005, "The number of votes reached the maximum", "已经达到最大投票数了哦"),

    BIM_PARSE_FAILURE(9006, "The bim model parse failure", "bim模型解析失败"),

    BIM_MODE(9006, "The bim model is not exist", "bim模型不存在"),

    BIM_GET_FAILURE(9007, "Failed to invoke file service", "调用文件服务解析BIM失败"),

    CUSTOMER_EXIST(9008, "customer has exist", "客户已经存在");

    String cn;

    String en;

    int code;

    ResultCode(int code, String en, String cn) {
        this.code = code;
        this.cn = cn;
        this.en = en;
    }
}