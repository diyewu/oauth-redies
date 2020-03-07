package com.aicc.bpf.vo;

import java.util.List;

/**
 * @description 用户登录后返回参数对象
 */
public class LoginUserVO extends Base {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * accessToken码
     */
    private String accessToken;

    /**
     * accessToken是否过期
     */
    private Boolean expired;

    /**
     * accessToken到期时间
     */
    private String accessTokenExpiration;

    /**
     * accessToken过期时限
     */
    private Integer accessTokenExpiresIn;

    /**
     * 使用范围
     */
//    private List<String> scope;
    private Object scope;

    /**
     * token类型
     */
    private String tokenType;

    /**
     * refreshToken到期时间
     */
    private String refreshTokenExpiration;


    /**
     * refreshToken码
     */
    private String refreshToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public String getAccessTokenExpiration() {
        return accessTokenExpiration;
    }

    public void setAccessTokenExpiration(String accessTokenExpiration) {
        this.accessTokenExpiration = accessTokenExpiration;
    }

    public Integer getAccessTokenExpiresIn() {
        return accessTokenExpiresIn;
    }

    public void setAccessTokenExpiresIn(Integer accessTokenExpiresIn) {
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    public Object getScope() {
        return scope;
    }

    public void setScope(Object scope) {
        this.scope = scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshTokenExpiration() {
        return refreshTokenExpiration;
    }

    public void setRefreshTokenExpiration(String refreshTokenExpiration) {
        this.refreshTokenExpiration = refreshTokenExpiration;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "LoginUserVO{" +
               "id=" + id +
               ", account='" + account + '\'' +
               ", name='" + name + '\'' +
               ", password='" + password + '\'' +
               ", accessToken='" + accessToken + '\'' +
               ", expired=" + expired +
               ", accessTokenExpiration='" + accessTokenExpiration + '\'' +
               ", accessTokenExpiresIn=" + accessTokenExpiresIn +
               ", scope=" + scope +
               ", tokenType='" + tokenType + '\'' +
               ", refreshTokenExpiration='" + refreshTokenExpiration + '\'' +
               ", refreshToken='" + refreshToken + '\'' +
               '}';
    }
}
