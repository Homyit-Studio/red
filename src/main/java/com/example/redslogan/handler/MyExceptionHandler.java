package com.example.redslogan.handler;

import com.example.redslogan.entity.Result;
import com.example.redslogan.exception.SystemException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public Result exceptionHandler(SystemException e) {
        return new Result(e.getNum(), e.getMsg(), null, false);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        System.out.println("全局异常捕获------>" + e);
        e.printStackTrace();
        return new Result(500, "未知错误", "全局捕获的异常错误原因:" + e.getMessage(), false);
    }

}
