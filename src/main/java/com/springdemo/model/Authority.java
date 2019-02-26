package com.springdemo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 资源角色
 * Created by Administrator on 2018/1/17.
 */
@Entity
public class Authority {


    @Id
    @GeneratedValue
    private long id;

    @Column
    private String url;

    @ManyToMany(mappedBy = "authorities",fetch= FetchType.EAGER)
    private List<Role> roles;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
