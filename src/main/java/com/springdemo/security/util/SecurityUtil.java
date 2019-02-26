package com.springdemo.security.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Administrator on 2018/1/23.
 */
public class SecurityUtil {


    public static UserDetails getUser(){
        return  (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

}
