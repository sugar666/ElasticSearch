package com.yangshu.elastic.controller;

import com.yangshu.elastic.VO.ResultVO;
import com.yangshu.elastic.entity.Category;
import com.yangshu.elastic.service.CategoryService;
import com.yangshu.elastic.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/category")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/list")
    public ResultVO list(){
        List<Category> categoryModelList = categoryService.selectAllCategory();
        return ResultVOUtil.success(categoryModelList);
    }

}
