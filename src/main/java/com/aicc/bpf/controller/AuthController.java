package com.aicc.bpf.controller;

import com.aicc.bpf.domain.Result.ResponseResult;
import com.aicc.bpf.entity.AuthUser;
import com.aicc.bpf.entity.LoginUserDTO;
import com.aicc.bpf.service.RoleService;
import com.aicc.bpf.service.UserService;
import com.aicc.bpf.utils.AssertUtils;
import com.aicc.bpf.utils.ResultUtils;
import com.aicc.bpf.vo.LoginUserVO;
import com.aicc.bpf.vo.ResponseVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description 用户权限管理
 */
@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisTokenStore redisTokenStore;

    /**
     * @description 添加用户
     * @param userDTO
     * @return
     */
    @PostMapping("user")
    public ResponseVO add(@Valid @RequestBody AuthUser userDTO) throws Exception {
        userService.addUser(userDTO);
        return ResponseVO.success();
    }

    /**
     * @description 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("user/{id}")
    public ResponseVO deleteUser(@PathVariable("id")String id) throws Exception {
        userService.deleteUser(id);
        return ResponseVO.success();
    }

    /**
     * @descripiton 修改用户
     * @param userDTO
     * @return
     */
    @PutMapping("user")
    public ResponseVO updateUser(@Valid @RequestBody AuthUser userDTO){
        userService.updateUser(userDTO);
        return ResponseVO.success();
    }

    /**
     * @description 获取用户列表
     * @return
     */
    @GetMapping("getUser")
    public ResponseResult findUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResultUtils.success(authentication);
    }

    /**
     * @description 用户登录
     * @param loginUserDTO
     * @return
     */
    @PostMapping("user/login")
    public ResponseResult login(LoginUserDTO loginUserDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginUserVO login = userService.login(loginUserDTO);
        return ResultUtils.success(login);
    }


    /**
     * @description 用户注销
     * @param authorization
     * @return
     */
    @GetMapping("user/logout")
    public ResponseVO logout(@RequestHeader("Authorization") String authorization){
        redisTokenStore.removeAccessToken(AssertUtils.extracteToken(authorization));
        return ResponseVO.success();
    }

    /**
     * @description 获取所有角色列表
     * @return
     */
    @GetMapping("role")
    public ResponseVO findAllRole(){
        return roleService.findAllRoleVO();
    }


}
