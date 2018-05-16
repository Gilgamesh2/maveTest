package com.test.springmvc.test;

import com.test.springmvc.bean.User;

public class Test {
    public static void main(String [] args){
        User user=new User();
        user.setName("newApi");
        user.setAge(1);
        user.setNo(2);
        System.out.println(user.toString());
    }
}
