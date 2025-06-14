package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.User;
import org.zhoujunjiang.grade.mapper.UserMapper;
import org.zhoujunjiang.grade.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

@Resource
    private UserMapper userMapper;


    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userMapper.findByUsername(username) != null;
    }
}