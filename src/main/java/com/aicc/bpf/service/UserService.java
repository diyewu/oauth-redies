package com.aicc.bpf.service;


import com.aicc.bpf.entity.AuthUser;
import com.aicc.bpf.entity.LoginUserDTO;
import com.aicc.bpf.vo.ResponseVO;

import java.util.List;

/**
 * @description 用户业务接口
 */
public interface UserService {

    /**
     * @description 添加用户
     */
    void addUser(AuthUser authUser) throws Exception;

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(String id) throws Exception;

    /**
     * @description 修改用户信息
     * @param userDTO
     */
    void updateUser(AuthUser authUser);

    /**
     * @description 获取所有用户列表VO
     * @return
     */
    ResponseVO<List<AuthUser>> findAllUserVO();

    /**
     * @description 用户登录
     * @return
     */
    ResponseVO login(LoginUserDTO loginUserDTO);

}
