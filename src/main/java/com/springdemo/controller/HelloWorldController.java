package com.springdemo.controller;

/**
 * Created by Administrator on 2018/1/17.
 */
import com.alibaba.fastjson.JSONObject;
import com.springdemo.exception.SystemException;
import com.springdemo.manage.AutorityManager;
import com.springdemo.manage.RoleManager;
import com.springdemo.manage.UserManager;
import com.springdemo.model.Authority;
import com.springdemo.model.Role;
import com.springdemo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloWorldController extends BaseController{


    @Resource(name = "userManager")
    private UserManager userManager;

    @Resource(name = "roleManager")
    private RoleManager roleManager;

    @Resource(name = "autorityManager")
    private AutorityManager autorityManager;

    @RequestMapping("/admin")
    public String adminPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "admin";
    }

    @RequestMapping("/normal")
    public String normalPage(){
        return "normal";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String indexPage(){
        return "index";
    }

    /**
     * 登录页
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 无权限页面
     * @return
     */
    @RequestMapping("/noaccess")
    public String noAccess(){
        return "noaccess";
    }



    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/users")
    public String users(){
        return "/users/users";
    }

    /**
     * 新增修改用户
     * @return
     */
    @RequestMapping("/addOrUpdateUser")
    public String addOrUpdateUser(){
        return "/users/users";
    }


}
