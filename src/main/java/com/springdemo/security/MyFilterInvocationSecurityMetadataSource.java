package com.springdemo.security;

import com.springdemo.manage.AutorityManager;
import com.springdemo.model.Authority;
import com.springdemo.model.Role;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2018/1/18.
 */
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{

    private Map<String,Collection<ConfigAttribute>> resouce2Authorities = new HashMap<String, Collection<ConfigAttribute>>();

    @Resource(name = "autorityManager")
    private AutorityManager autorityManager;

    /**
     * 加载资源和角色的对应关系
     * @return
     */
    private void loadResourceMap(){
        List<Authority> authorities = autorityManager.findAll();
        for(Authority authority : authorities){
            List<ConfigAttribute> configs = new ArrayList<ConfigAttribute>();
            List<Role> roles = authority.getRoles();
            for(Role role : roles){
                configs.add(new SecurityConfig("ROLE_"+role.getName().toUpperCase()));
            }
            this.resouce2Authorities.put(authority.getUrl(),configs);
        }
    }

    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        loadResourceMap();
        String url = ((FilterInvocation) o).getRequestUrl();
        Iterator<String> ite = resouce2Authorities.keySet().iterator();
        while(ite.hasNext()){
            if(url.equals(ite.next())){
                return resouce2Authorities.get(url);
            }
        }
        return null;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}
