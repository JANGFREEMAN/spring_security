package com.springdemo.repository;

import com.springdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * User访问层
 * Created by Administrator on 2018/1/17.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,String>{

    User findByUsername(String name);
}
