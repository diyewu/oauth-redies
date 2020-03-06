package com.aicc.bpf.entity;



/**
 * @description 登录用户传输参数
 */
public class LoginUserDTO {

    /**
     * 用户名
     */
    private String userName;


    /**
     * 用户密码
     */
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
