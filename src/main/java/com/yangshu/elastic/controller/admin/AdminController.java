package com.yangshu.elastic.controller.admin;

import com.yangshu.elastic.annotation.AdminPermission;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author yangshu on 2020/10/19 17:10
 * Description：
 */

@Controller("/admin/admin")
@RequestMapping("/admin/admin")
public class AdminController {


    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    private static final String EMAIL = "admin";


    private static final String ENCRPTY_PASSWORD = "admin";

    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");

        modelAndView.addObject("userCount", userService.countAllUser());
        modelAndView.addObject("CONTROLLER_NAME", "admin");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/loginpage")
    public ModelAndView loginpage() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new BusinessException(ResultEnum.BIND_EXCEPTION_ERROR);
        }
        if (email.equals(EMAIL) && password.equals(ENCRPTY_PASSWORD)) {
            //登录成功
            httpServletRequest.getSession().setAttribute(CURRENT_ADMIN_SESSION, email);
            return "redirect:/admin/admin/index";
        } else {
            throw new BusinessException(ResultEnum.PASSWORD_IS_ERROR);
        }

    }

}
