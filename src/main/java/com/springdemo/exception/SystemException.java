package com.springdemo.exception;

/**
 * Created by Administrator on 2018/1/22.
 */
public class SystemException extends Exception{

    private String code;

    private String msg;

    public SystemException(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
