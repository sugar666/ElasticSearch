package com.yangshu.elastic.handler;

import com.yangshu.elastic.VO.ResultVO;
import com.yangshu.elastic.exception.UserAuthorizeException;
import com.yangshu.elastic.utils.ResultVOUtil;
import com.yangshu.elastic.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author yangshu on 2020/10/5 16:21
 * Description：异常处理器
 * ControllerAdvice 切面通知
 */
@ControllerAdvice
public class UserAuthorizeExceptionHandler {


    @ExceptionHandler(value = UserAuthorizeException.class)
    @ResponseBody
    public ResultVO handlerAuthorizeException() {
        return ResultVOUtil.error(ResultEnum.USER_IS_NOT_LOGIN.getCode(),ResultEnum.USER_IS_NOT_LOGIN.getMessage());

    }
}
