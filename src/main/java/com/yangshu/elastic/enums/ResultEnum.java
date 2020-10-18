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
    PARAM_ERROR(50001, "输入参数不正确"),
    VERIFY_CODE_HAS_EXPIRED(50002,"验证码已过期"),
    VERIFY_CODE_IS_ERROR(50003,"验证码输入错误"),
    USER_UPDATE_FACE_ERROR(50004,"上传用户头像错误"),
    PASSWORD_IS_WRONG(50005,"用户原密码输入错误"),
    PHONE_IS_REGISTED(50006,"手机号已被注册"),
    VIDEO_IS_NOT_EXIST(50007,"视频不存在"),
    ALIYUN_VIDEO_VOD_ERROR(50008,"阿里云视频点播错误"),
    PHONE_IS_EMPTY(50009,"手机号为空"),
    SEARCH_CONTENT_IS_NULL(50010,"输入的搜索内容为空"),
    REPORT_CONTENT_IS_INCOMPLETE(50011,"请输入必填的举报内容"),
    COMMENT_FAIL(50012,"评论失败"),
    UPDATE_VIDEO_COVER_ERROR(50013,"上传视频头像失败"),
    COMMENT_IS_EMPTY(50014,"当前视频还没有评论信息"),
    USERNAME_IS_EXIST(50015,"用户名已存在"),



    // 业务提示消息
    SENDING_VERIFY_CODE(10,"正在发送验证码"),
    UPLOAD_VIDEO_SUCCESS(11,"视频正在上传，请稍后"),
    USER_LOGIN_SUCCESS(12,"用户登录成功"),
    USER_LOGOUT_SUCCESS(13,"用户注销成功"),
    REPORT_SUCCESS(14,"举报成功"),
    FOLLOW_SUCCESS(15,"关注成功"),
    CANCEL_FOLLOW_SUCCESS(16,"取消关注成功"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
