package com.aust.clanguagemanage.exception;

/**
 * 程序错误信息
 *
 * @author zhangjicheng
 */
public class ErrorNotLoginException extends RuntimeException {
    public ErrorNotLoginException(String message) {
        super(message);
    }
}
