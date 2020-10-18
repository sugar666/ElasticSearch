package com.yangshu.elastic.mapper;

import com.yangshu.elastic.entity.Category;
import com.yangshu.elastic.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends MyMapper<Category> {
}