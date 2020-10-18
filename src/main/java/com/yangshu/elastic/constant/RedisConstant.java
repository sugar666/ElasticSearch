package com.yangshu.elastic.constant;

/**
 *
 * @author yangshu on 2020/9/30 19:07
 * Description：
 */
public interface RedisConstant {

    /**
     * redis中token的格式
     */
    public String TOKEN_PERFIX = "token_%s";

    /**
     * redis中userId的格式
     */
    public String USERID_PERFIX = "userId_%s";

    /**
     * redis中用户手机验证码的保存的格式
     * 用户注册
     */
    public String VERIFYCODE_REGISTER_PREFIX = "verifyCode_register_%s";

    /**
     * redis中用户手机验证码的保存的格式
     * 用户登录
     */
    public String VERIFYCODE_LOGIN_PREFIX = "verifyCode_login_%s";

    /**
     * 用户登录的过期时间
     * redis过期时间：7天
     * */
    public Integer EXPIRE_USER_LOGIN = 7;

    /**
     * 用户验证码的过期时间：5分钟
     */
    public Integer EXPIRE_VERIFY_CODE = 300;



}
