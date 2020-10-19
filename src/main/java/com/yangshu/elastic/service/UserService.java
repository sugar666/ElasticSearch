package com.yangshu.elastic.service;

import com.yangshu.elastic.entity.User;
import com.yangshu.elastic.exception.BusinessException;

/**
 * @author yangshu on 2020/10/19 11:02
 * Description：
 */
public interface UserService {


    /**
     * 通过userId查询用户
     *
     * @param userId
     * @return
     */
    User findUserByUserId(Integer userId);

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    User createUser(User user) throws BusinessException;

    /**
     * 用户登录
     *
     * @param phone
     * @param password
     * @return
     * @throws BusinessException
     */
    User login(String phone, String password) throws BusinessException;


    Integer countAllUser();
}
