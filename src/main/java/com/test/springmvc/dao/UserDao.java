package com.test.springmvc.dao;

import com.test.springmvc.bean.User;

public interface UserDao {
    void addUser(User user);
   void deleteUser(Integer no);

}
