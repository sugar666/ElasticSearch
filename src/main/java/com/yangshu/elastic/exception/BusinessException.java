package com.yangshu.elastic.exception;

import com.yangshu.elastic.enums.ResultEnum;
import lombok.Data;
import lombok.Getter;

/**
 * Package seed
 *
 * @author yangshu on 2020/10/18 23:58
 * Description：
 */

@Getter
public class BusinessException extends Exception {

    private Integer code;
    private String message;
    private Object data;


    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BusinessException(Integer code,String message,Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BusinessException(Integer code,String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BusinessException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public BusinessException(ResultEnum resultEnum,Object data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
}
