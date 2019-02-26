package com.springdemo.repository;

import com.springdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Role数据访问层
 * Created by Administrator on 2018/1/17.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,String>{


}
