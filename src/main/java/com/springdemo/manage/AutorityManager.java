package com.springdemo.manage;

import com.springdemo.model.Authority;
import com.springdemo.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Autority服务类
 * Created by Administrator on 2018/1/17.
 */
@Service("autorityManager")
public class AutorityManager {

    @Resource(name = "authorityRepository")
    private AuthorityRepository authorityRepository;


    public void save(Authority authority){
        authorityRepository.save(authority);
    }

    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }
}
