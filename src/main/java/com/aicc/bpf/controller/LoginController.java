package com.aicc.bpf.controller;

import com.aicc.bpf.domain.Result.ResponseResult;
import com.aicc.bpf.entity.LoginUserDTO;
import com.aicc.bpf.service.UserService;
import com.aicc.bpf.utils.ResultUtils;
import com.aicc.bpf.vo.LoginUserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authlogin/")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * @description 用户登录
     * @param loginUserDTO
     * @return
     */
    @PostMapping("login")
    public ResponseResult login(LoginUserDTO loginUserDTO) throws JsonProcessingException {
        LoginUserVO login = userService.login(loginUserDTO);
        return ResultUtils.success(login);
    }
}
