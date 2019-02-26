package com.springdemo.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.springdemo.security.util.SecurityUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Administrator on 2018/1/18.
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
//        UserDetails user = SecurityUtil.getUser();
//        user.getUsername();
//        Map<String,String> result = new HashMap<String, String>();
//        result.put("code","fail");
//        result.put("msg",user.getUsername()+"权限不足");
//        response.getWriter().print(JSONObject.toJSONString(result));
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/noaccess").forward(request,response);
    }
}
