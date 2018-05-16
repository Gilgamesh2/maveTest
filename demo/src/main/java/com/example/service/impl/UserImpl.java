package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public int addUser(User user) {
        System.out.println(userMapper);
        return userMapper.insertUser(user);
    }
}
