package com.yangshu.elastic.mapper;

import com.yangshu.elastic.entity.User;
import com.yangshu.elastic.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends MyMapper<User> {

    Integer countAllUser();
}