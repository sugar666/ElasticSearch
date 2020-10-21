package com.yangshu.elastic.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangshu.elastic.VO.PageVO;
import com.yangshu.elastic.VO.ResultVO;
import com.yangshu.elastic.VO.SellerCreateVO;
import com.yangshu.elastic.annotation.AdminPermission;
import com.yangshu.elastic.entity.Seller;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.service.SellerService;
import com.yangshu.elastic.service.UserService;
import com.yangshu.elastic.utils.ParamsVerifyUtil;
import com.yangshu.elastic.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author yangshu on 2020/10/19 17:10
 * Description：
 */

@Controller
@RequestMapping("/admin/seller")
public class SellerController {


    @Autowired
    private SellerService sellerService;


    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageVO pageVO){
        PageHelper.startPage(pageVO.getPage(),pageVO.getSize());
        List<Seller> sellerList = sellerService.selectAllSeller();
        PageInfo<Seller> sellerModelPageInfo = new PageInfo<>(sellerList);
        ModelAndView modelAndView = new ModelAndView("/admin/seller/index.html");
        modelAndView.addObject("data",sellerModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }


    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/seller/create.html");
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid SellerCreateVO sellerCreateVO, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(ResultEnum.BIND_EXCEPTION_ERROR.getCode(),ResultEnum.BIND_EXCEPTION_ERROR.getMessage(), ParamsVerifyUtil.processErrorString(bindingResult));
        }

        Seller seller = new Seller();
        seller.setName(sellerCreateVO.getName());
        sellerService.createSeller(seller);

        return "redirect:/admin/seller/index";


    }

    @RequestMapping(value="down",method = RequestMethod.POST)
    @AdminPermission
    @ResponseBody
    public ResultVO down(@RequestParam(value="id")Integer id) throws BusinessException {
        Seller seller = sellerService.updateSellerStatus(id,1);
        return ResultVOUtil.success(seller);
    }

    @RequestMapping(value="up",method = RequestMethod.POST)
    @AdminPermission
    @ResponseBody
    public ResultVO up(@RequestParam(value="id")Integer id) throws BusinessException {
        Seller seller = sellerService.updateSellerStatus(id,0);
        return ResultVOUtil.success(seller);
    }


}
