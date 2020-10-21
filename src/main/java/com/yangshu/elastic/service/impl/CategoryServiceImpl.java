package com.yangshu.elastic.service.impl;

import com.yangshu.elastic.entity.Category;
import com.yangshu.elastic.entity.User;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.mapper.CategoryMapper;
import com.yangshu.elastic.service.CategoryService;
import com.yangshu.elastic.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author yangshu on 2020/10/21 22:10
 * Description：
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category createCategory(Category category) throws BusinessException {
        try{
            categoryMapper.insertSelective(category);
        }catch (DuplicateKeyException ex) {
            throw new BusinessException(ResultEnum.CATEGORY_DUP_FAIL);
        }

        return findSellerById(category.getId());
    }

    @Override
    public Category findSellerById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> selectAllCategory() {
        return categoryMapper.selectAll();
    }

    @Override
    public Integer countAllCategory() {
        return categoryMapper.countAllCategory();
    }


}
