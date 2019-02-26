package com.springdemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * Created by Administrator on 2018/1/22.
 */
@ControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(value = Exception.class)
    public String handlerException(HttpServletRequest request, Exception e){
        System.out.println("发生异常");
        e.printStackTrace();
        return "";
    }

}
