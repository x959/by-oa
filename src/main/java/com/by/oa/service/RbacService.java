package com.by.oa.service;

import com.by.oa.entity.Node;
import com.by.oa.mapper.RbacMapper;

import java.util.List;

public class RbacService {
    private RbacMapper rbacMapper = new RbacMapper();
    public List<Node> selectNodeByUserId(Long userId){
        return rbacMapper.selectNodeByUserId(userId);
    }
}
