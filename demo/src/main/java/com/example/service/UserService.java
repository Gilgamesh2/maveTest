package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    int addUser(User user);
    User findById(int no);
    List<User> findAll(int i);
}
