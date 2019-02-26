package com.springdemo.manage;

import com.springdemo.model.User;
import com.springdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务类
 * Created by Administrator on 2018/1/17.
 */

@Service("userManager")
public class UserManager {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public List<User> findAll() {
       return  userRepository.findAll();
    }
}
