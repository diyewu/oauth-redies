package com.aicc.bpf.service.impl;

import com.aicc.bpf.dao.AuthRoleMapper;
import com.aicc.bpf.entity.AuthRole;
import com.aicc.bpf.service.RoleService;
import com.aicc.bpf.vo.ResponseVO;
import com.aicc.bpf.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private AuthRoleMapper authRoleMapper;

    @Override
    public ResponseVO findAllRoleVO() {
        List<AuthRole> rolePOList = authRoleMapper.selectAll();
        List<RoleVO> roleVOList = new ArrayList<>();
        rolePOList.forEach(rolePO->{
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(rolePO,roleVO);
            roleVOList.add(roleVO);
        });
        return ResponseVO.success(roleVOList);
    }

    @Override
    public AuthRole findById(String id) {
        return authRoleMapper.selectByPrimaryKey(id);
    }
}
