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
import com.sun.deploy.net.HttpResponse;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController{


    @Resource(name = "userManager")
    private UserManager userManager;

    @Resource(name = "roleManager")
    private RoleManager roleManager;

    @Resource(name = "autorityManager")
    private AutorityManager autorityManager;


    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/list")
    public String users(HttpServletRequest request, HttpServletResponse response){
        List<User> users = userManager.findAll();
        request.setAttribute("users",users);
        return "/users/users";
    }

    /**
     * 新增修改用户
     * @return
     */
    @RequestMapping("/addOrUpdateUser")
    public String addOrUpdateUser(HttpServletRequest request){
        String username = (String)request.getAttribute("username");
        String password = (String)request.getAttribute("password");
        User user = new User();
        user.setUsername(username);
        user.setUsername(password);
        userManager.save(user);
        return "/users/addOrUpdateUser";
    }


}
