package com.aicc.bpf.config.AjaxSecurity;

import com.aicc.bpf.domain.Result.ResponseResult;
import com.aicc.bpf.domain.Result.ResultCodeEnum;
import com.aicc.bpf.utils.ResultUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 登录失败
 */
@Configuration
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseResult<Object> result = ResultUtils.fail(ResultCodeEnum.LOGIN_FAIL);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
