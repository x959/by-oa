package com.by.oa.mapper;

import com.by.oa.entity.User;
import com.by.oa.utils.MybatisUtils;

public class UserMapper {
    public User selectByUsername(String username){
        User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername",username));
        return user;
    }
}
