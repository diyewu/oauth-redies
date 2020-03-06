package com.aicc.bpf.config.AjaxSecurity;

import com.aicc.bpf.service.impl.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * 自定义账号密码验证
 */
@Configuration
public class SelfAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    SecurityUserService securityUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();


        UserDetails userInfo = securityUserService.loadUserByUsername(userName);
        if(userInfo == null){
            throw new BadCredentialsException("用户不存在，请重新登陆！");
        }
        boolean checkpw = BCrypt.checkpw(password, userInfo.getPassword());

        if (!checkpw) {
            throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
        }

        return new UsernamePasswordAuthenticationToken(userName, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
