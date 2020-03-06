package com.aicc.bpf.dao;

import com.aicc.bpf.entity.AuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AuthUser record);

    AuthUser selectByPrimaryKey(String id);

    List<AuthUser> selectAll();

    int updateByPrimaryKey(AuthUser record);

    AuthUser selectByUserName(@Param("userName") String userName);
}
