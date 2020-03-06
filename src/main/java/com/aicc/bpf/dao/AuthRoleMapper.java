package com.aicc.bpf.dao;

import com.aicc.bpf.entity.AuthRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(AuthRole record);

    AuthRole selectByPrimaryKey(String id);

    List<AuthRole> selectAll();

    int updateByPrimaryKey(AuthRole record);
}
