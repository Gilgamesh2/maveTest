package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    int addUser(User user);
}
