package com.yangshu.elastic.exception;

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


    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BusinessException(Integer code,String message) {
        super();
        this.code = code;
        this.message = message;

    }
}
