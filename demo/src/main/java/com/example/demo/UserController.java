package com.example.demo;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value="/index")
    public String index(){
        return "hello";
    }


    @ResponseBody
    @RequestMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        user.setAge(12);
        user.setName("fi");
        System.out.println("i am come in ");
        System.out.println(userService);
        return userService.addUser(user);
    }


}
