package com.aicc.bpf.service.impl;

import com.aicc.bpf.dao.AuthUserMapper;
import com.aicc.bpf.entity.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class SecurityUserService implements UserDetailsService {


    @Autowired
    AuthUserMapper authUserMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //TODO 补全用户权限信息
        AuthUser authUser = authUserMapper.selectByUserName(name);
        if(authUser == null){
            return null;
        }
        UserDetails userDetails = User.withUsername(authUser.getUser_name())
                .password(authUser.getPassword()).authorities("p1").build();
        return userDetails;
    }
}
