package com.aicc.bpf.config.AjaxSecurity;

import com.aicc.bpf.domain.Result.ResponseResult;
import com.aicc.bpf.utils.ResultUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功
 */
@Configuration
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseResult<Object> result = ResultUtils.success("登录成功!");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
