package com.yangshu.elastic.enums;

import lombok.Getter;

/**
 *
 *
 * @author yangshu on 2020/10/3 11:51
 * Description：result状态码
 */

@Getter
public enum ResultEnum {

    SUCCESS(200,"成功"),

    // 公共错误码-系统设置-用户授权管理：用户、授权：40001起
    UNAUTHORIZED(40001,"用户权限错误"),
    USER_IS_NOT_EXIST(40002,"用户不存在"),
    USER_IS_NOT_LOGIN(40003,"用户没登录"),
    AOP_SERVER_ERROR(40004,"aop-用户权限鉴定错误"),
    ALIYUN_CALL_BACK_ERROR(40005,"阿里云视频回调错误"),


    // 公共错误码-系统设置-基础服务：数据字段、地级等：50001起
    NO_HANDLER_FOUND(50001,"找不到执行的路径操作"),
    BIND_EXCEPTION_ERROR(50002,"请求参数错误"),
    UNKNOWN_ERROR(50003,"未知错误"),



    // 业务提示消息 10000起


    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
