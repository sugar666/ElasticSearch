package com.yangshu.elastic.service;

import com.yangshu.elastic.entity.Category;
import com.yangshu.elastic.entity.Seller;
import com.yangshu.elastic.exception.BusinessException;

import java.util.List;

/**
 * @author yangshu on 2020/10/19 20:14
 * Description：
 */
public interface CategoryService {


    Category createCategory(Category category) throws BusinessException;


    Category findSellerById(Integer id);


    List<Category> selectAllCategory();


    Integer countAllCategory();

}
