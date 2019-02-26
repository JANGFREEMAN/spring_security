package com.springdemo.repository;

import com.springdemo.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Resource数据访问层
 * Created by Administrator on 2018/1/17.
 */
@Repository("authorityRepository")
public interface AuthorityRepository extends JpaRepository<Authority,String>{

}
