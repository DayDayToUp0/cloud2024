package com.cxt.cloud.exception;

import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.resp.ReturnCodeEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalException
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/28 - 16:23
 * @Version 1.0
 */
@Log4j2
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData error(Exception e){
        log.error("系统异常:{}",e.getMessage());

        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), ReturnCodeEnum.RC500.getMessage());
    }
}
