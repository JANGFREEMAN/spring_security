package com.springdemo.security;

import com.springdemo.manage.UserManager;
import com.springdemo.model.Role;
import com.springdemo.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理
 * Created by Administrator on 2018/1/18.
 */
public class MyUserDetailService implements UserDetailsService{

    @Resource
    private UserManager userManager;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userManager.findByUsername(name);
        if(user == null){
            throw new UsernameNotFoundException("找不到该用户");
        }
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName().toUpperCase()));
        }
        return new org.springframework.security.core.userdetails.User(name,user.getPassword(),authorities);
    }
}
