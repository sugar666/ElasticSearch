package com.yangshu.elastic.controller;

import com.yangshu.elastic.VO.LoginVO;
import com.yangshu.elastic.VO.RegisterVO;
import com.yangshu.elastic.VO.ResultVO;
import com.yangshu.elastic.entity.User;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.service.UserService;
import com.yangshu.elastic.utils.ParamsVerifyUtil;
import com.yangshu.elastic.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author yangshu on 2020/10/19 11:24
 * Description：
 */

@Api(value = "用户接口",tags = {"用户接口"})
@RestController
@RequestMapping("/user")
public class UserController {


    private static final String CURRENT_USER_SESSION = "currentUserSession";

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册",notes = "/user/register")
    @PostMapping("/register")
    public ResultVO register(@Valid @RequestBody RegisterVO registerVO, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(ResultEnum.BIND_EXCEPTION_ERROR.getCode(),ResultEnum.BIND_EXCEPTION_ERROR.getMessage(), ParamsVerifyUtil.processErrorString(bindingResult));
        }

        User user = new User();
        BeanUtils.copyProperties(registerVO,user);

        User res = userService.createUser(user);

        return ResultVOUtil.success(res);
    }

    @ApiOperation(value = "用户登录",notes = "/user/login")
    @PostMapping("/login")
    public ResultVO login(@Valid @RequestBody LoginVO loginVO, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(ResultEnum.BIND_EXCEPTION_ERROR.getCode(),ResultEnum.BIND_EXCEPTION_ERROR.getMessage(), ParamsVerifyUtil.processErrorString(bindingResult));
        }

        User user = userService.login(loginVO.getTelphone(), loginVO.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION,user);

        return ResultVOUtil.success(user);
    }

    @ApiOperation(value = "用户注销",notes = "/user/logout")
    @GetMapping("/logout")
    public ResultVO logout() {
        httpServletRequest.getSession().invalidate();
        return ResultVOUtil.success();
    }

    @ApiOperation(value = "获取用户信息",notes = "/user/getcurrentuser")
    @GetMapping("/getcurrentuser")
    public ResultVO getcurrentuser() {
        User user = (User) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return ResultVOUtil.success(user);
    }

}
