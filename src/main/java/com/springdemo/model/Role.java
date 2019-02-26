package com.springdemo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色
 * Created by Administrator on 2018/1/17.
 */
@Entity
public class Role {


    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @ManyToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinTable(name = "ROLE_AUTHORITY", joinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Authority> getResources() {
        return authorities;
    }

    public void setResources(List<Authority> resources) {
        this.authorities = resources;
    }


    public void addAuthority(Authority authority){
        if(this.authorities == null){
            this.authorities = new ArrayList<Authority>();
        }
        this.authorities.add(authority);
    }
}
