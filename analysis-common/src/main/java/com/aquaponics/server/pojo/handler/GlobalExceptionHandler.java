package com.aquaponics.server.pojo.handler;

import com.aquaponics.server.pojo.exception.BaseException;
import com.aquaponics.server.pojo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qht
 */
@RestControllerAdvice
//@Slf4j
public class GlobalExceptionHandler {
    /**
     *  统一处理业务异常
     */
    @ExceptionHandler
    public ResultVO exceptionHandler(BaseException exception) {
//        log.error("捕捉到异常:{}", exception.getMessage());
        return ResultVO.error(exception.getMessage());
    }
}
