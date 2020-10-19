package com.yangshu.elastic.utils;

import com.yangshu.elastic.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by yangshu on 2020/9/29 18:12
 * Description：用户密码校验
 */
public class PasswordUtil {
    /**
     * 判断密码是否相等
     * @param user
     * @param newPassword
     * @return
     */
    public static boolean matches(User user, String newPassword) {
        return user.getPassword().equals(encryptPassword(newPassword, user.getSalt()));
    }

    /**
     * 获取加密后的密码
     * @param password
     * @param salt
     * @return
     */
    public static String encryptPassword(String password, String salt) {
        return new Md5Hash(salt + password + salt).toHex();
    }

    /**
     * 生成随机盐
     */
    public static String randomSalt()
    {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        return secureRandom.nextBytes(3).toHex();
    }

}
