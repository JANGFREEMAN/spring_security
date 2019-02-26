package com.springdemo.manage;

import com.springdemo.model.Role;

import com.springdemo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Role服务类
 * Created by Administrator on 2018/1/17.
 */
@Service("roleManager")
public class RoleManager {


    @Resource(name = "roleRepository")
    private RoleRepository  roleRepository;


    public void save(Role role){
        roleRepository.save(role);
    }
}
