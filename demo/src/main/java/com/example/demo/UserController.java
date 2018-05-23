package com.example.demo;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//使用@RestController将该类声明为一个controller
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //使用@RequestBody来接受异步请求

    @ResponseBody
    @RequestMapping(value="/index")
    public String index(){
        return "hello";
    }

    //@RequestMapping来配置请求路径
    //value用来配置路径，produces来设置请求的报文格式，method设置请求的方法
    //@PathVariable设置在入参中，可以用来拼接请求路径，须在@RequestMapping的value中加上{参数名}
    //@RequestParam用来增加请求参数，具体可设置属性看源码

    @ResponseBody
    @RequestMapping(value = "/add",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public  User addUser(User user){

        System.out.println("i am come in ");
        System.out.println(userService);

        System.out.println(user.toString());
        userService.addUser(user);
       return user;



    }
    @RequestMapping(value="/find",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public User findById(int no){
        return userService.findById(no);
    }
    @RequestMapping(value="/findAll",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByAll(int i){
        return userService.findAll(i);
    }


}
