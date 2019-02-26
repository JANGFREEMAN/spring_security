package com.springdemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/1/22.
 */
@ControllerAdvice
public class BaseController {

    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, Exception ex){
        ex.printStackTrace();
        return null;
    }
}
