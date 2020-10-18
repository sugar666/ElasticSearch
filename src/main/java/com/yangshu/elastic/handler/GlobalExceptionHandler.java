package com.yangshu.elastic.handler;

import com.yangshu.elastic.VO.ResultVO;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.exception.UserAuthorizeException;
import com.yangshu.elastic.utils.ResultVOUtil;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Package seed
 *
 * @author yangshu on 2020/10/19 00:04
 * Description：可以在service层进行异常的抛出
 */

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO handlerGlobalException(HttpServletRequest servletRequest, HttpServletResponse httpServletResponse, Exception ex){
        if(ex instanceof BusinessException){
            return ResultVOUtil.error(((BusinessException) ex).getCode(),ex.getMessage());
        }else if(ex instanceof UserAuthorizeException) {
            return ResultVOUtil.error(ResultEnum.USER_IS_NOT_LOGIN.getCode(),ResultEnum.USER_IS_NOT_LOGIN.getMessage());
        }
        else if(ex instanceof NoHandlerFoundException){
            return ResultVOUtil.error(ResultEnum.NO_HANDLER_FOUND.getCode(),ResultEnum.NO_HANDLER_FOUND.getMessage());
        }else if(ex instanceof ServletRequestBindingException){
            return ResultVOUtil.error(ResultEnum.BIND_EXCEPTION_ERROR.getCode(),ResultEnum.BIND_EXCEPTION_ERROR.getMessage());
        } else {
            return ResultVOUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMessage());
        }

    }
}
