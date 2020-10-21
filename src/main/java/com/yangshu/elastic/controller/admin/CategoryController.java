package com.yangshu.elastic.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangshu.elastic.VO.CategoryCreateVO;
import com.yangshu.elastic.VO.PageVO;
import com.yangshu.elastic.annotation.AdminPermission;
import com.yangshu.elastic.entity.Category;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.service.CategoryService;
import com.yangshu.elastic.utils.ParamsVerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller("/admin/category")
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //品类列表
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageVO pageVO){
        PageHelper.startPage(pageVO.getPage(),pageVO.getSize());
        List<Category> CategoryList = categoryService.selectAllCategory();
        PageInfo<Category> CategoryPageInfo = new PageInfo<>(CategoryList);
        ModelAndView modelAndView = new ModelAndView("/admin/category/index.html");
        modelAndView.addObject("data",CategoryPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }

    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/category/create.html");
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid CategoryCreateVO categoryCreateReq, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()){
            throw new BusinessException(ResultEnum.BIND_EXCEPTION_ERROR.getCode(),ResultEnum.BIND_EXCEPTION_ERROR.getMessage(), ParamsVerifyUtil.processErrorString(bindingResult));
        }

        Category Category = new Category();
        Category.setName(categoryCreateReq.getName());
        Category.setIconUrl(categoryCreateReq.getIconUrl());
        Category.setSort(categoryCreateReq.getSort());

        categoryService.createCategory(Category);

        return "redirect:/admin/category/index";


    }

}
