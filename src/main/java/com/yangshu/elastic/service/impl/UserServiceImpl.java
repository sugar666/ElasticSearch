package com.yangshu.elastic.service.impl;

import com.yangshu.elastic.entity.User;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.mapper.UserMapper;
import com.yangshu.elastic.service.UserService;
import com.yangshu.elastic.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author yangshu on 2020/10/19 11:03
 * Description：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过userId查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User createUser(User user) throws BusinessException {
        String salt = PasswordUtil.randomSalt();
        user.setSalt(salt);
        user.setPassword(PasswordUtil.encryptPassword(user.getPassword(),salt));

        // 因为手机号不能重复，可能会导致插入失败，需要try，catch
        // 相比于在 insert前查询一下数据库，判断是否存在用户，减少了对数据库的使用
        // 使用handler进行前端异常的抛出
        try{
            userMapper.insertSelective(user);
        }catch(DuplicateKeyException ex) {
            throw new BusinessException(ResultEnum.REGISTER_DUP_FAIL.getCode(),ResultEnum.REGISTER_DUP_FAIL.getMessage());
        }
        User res = findUserByUserId(user.getId());
        res.setSalt("");
        res.setPassword("");
        return res;
    }

    /**
     * 用户登录
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public User login(String phone, String password) throws BusinessException {

        Example example = new Example(User.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("telphone",phone);
        User user = userMapper.selectOneByExample(example);
        if(user == null) {
            throw new BusinessException(ResultEnum.USER_IS_NOT_EXIST);
        }

        if(!PasswordUtil.matches(user,password)) {
            throw new BusinessException(ResultEnum.PASSWORD_IS_ERROR);
        }
        user.setPassword("");
        user.setSalt("");

        return user;
    }

    @Override
    public Integer countAllUser() {
        return userMapper.countAllUser();
    }
}
