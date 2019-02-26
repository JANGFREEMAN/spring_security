package com.springdemo.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/18.
 */
public class MyAuthenicationSuccessHandler implements AuthenticationSuccessHandler{
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("验证成功");
        httpServletRequest.getSession().setAttribute("username",SecurityContextHolder.getContext().getAuthentication().getName());
        httpServletRequest.getRequestDispatcher("/index").forward(httpServletRequest,httpServletResponse);
    }
}
