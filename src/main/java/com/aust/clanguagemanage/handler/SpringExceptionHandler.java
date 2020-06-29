package com.aust.clanguagemanage.handler;

import com.aust.clanguagemanage.exception.ErrorMessageException;
import com.aust.clanguagemanage.exception.ErrorNotLoginException;
import com.aust.clanguagemanage.exception.ErrorRollbackException;
import com.aust.clanguagemanage.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class SpringExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ReturnVO handle(HttpServletRequest req, Exception e) {
        log.error("====================未知异常==========================Start");
        log.error("异常URL:" + req.getRequestURI());
        log.error("异常Message:", e);
        log.error("====================未知异常==========================End");
        return ReturnVO.getFailedInfo("系统出错");
    }

    @ExceptionHandler(value = {ErrorMessageException.class})
    public ReturnVO exceptionHandler(ErrorMessageException ex) {
        return ReturnVO.getFailedInfo(ex.getMessage());
    }

    @ExceptionHandler(value = {ErrorRollbackException.class})
    public ReturnVO exceptionHandler(ErrorRollbackException ex) {
        return ReturnVO.getFailedInfo(ex.getMessage());
    }

    @ExceptionHandler(value = {ErrorNotLoginException.class})
    public ReturnVO exceptionHandler(ErrorNotLoginException ex) {
        return ReturnVO.getNotLogin();
    }
}
