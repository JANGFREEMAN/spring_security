package com.springdemo.security;

import com.springdemo.model.Authority;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.Iterator;

/**
 * 策略
 * Created by Administrator on 2018/1/18.
 */
public class MyAcessDecisionManager implements AccessDecisionManager{

    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttribute) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("=================可以访问该资源的权限有（"+((FilterInvocation) o).getRequestUrl()+"）================="+configAttribute.toString());
        System.out.println("=================当前用户权限================="+authentication.getAuthorities().toString());
        if(configAttribute == null){
            //空说明不需要权限
            return;
        }
        Iterator<ConfigAttribute> iterator = configAttribute.iterator();
        while(iterator.hasNext()){
            String needRole = iterator.next().getAttribute();
            Collection<? extends  GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
            for(GrantedAuthority grantedAuthority: grantedAuthorities ){
                if(needRole.equals(grantedAuthority.getAuthority()))
                    return;
            }
        }
        throw new AccessDeniedException("没有权限访问");
    }

    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}
