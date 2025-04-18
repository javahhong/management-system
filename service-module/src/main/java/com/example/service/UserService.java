package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: untitled
 * @author: hhong
 * @create: 2025-04-17 16:53
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User getUserById(int id){
        return userMapper.selectById(id);
    }
}
