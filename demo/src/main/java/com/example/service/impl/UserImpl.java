package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserImpl implements UserService {
    //@Autowired 来进行自动注入，Spring容器会自动进行注入
    @Autowired
    private UserMapper userMapper;



    @Override
    public int addUser(User user) {
        System.out.println(userMapper);
        return userMapper.insertUser(user);
    }

    @Override
    public User findById(int no) {
        return userMapper.findById(no);
    }

    @Override
    public List<User> findAll(int i) {
        return userMapper.findAll(i);
    }
}
