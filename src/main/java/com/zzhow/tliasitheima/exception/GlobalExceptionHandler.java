package com.zzhow.tliasitheima.exception;

import com.zzhow.tliasitheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * @author ZZHow
 * @date 2024/7/27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public Result noResourceFoundException(NoResourceFoundException e) {
        log.error(e.getMessage(), e);

        return Result.resourceNotFound();
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e) {
        log.error(e.getMessage(), e);

        return Result.error("操作异常");
    }
}
