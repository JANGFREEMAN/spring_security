package com.springdemo.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户实体
 * Created by Administrator on 2018/1/17.
 */
@Entity
@XmlRootElement
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String username;

    @Column(columnDefinition=" varchar(255) DEFAULT NULL COMMENT '标签名称'")
    private String password;

    @ManyToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addRole(Role role){
        if(this.roles == null){
            this.roles = new ArrayList<Role>();
        }
        this.roles.add(role);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
