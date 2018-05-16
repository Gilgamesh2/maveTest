package com.zk.service.impl;

import com.zk.service.HelloInterface;
import org.springframework.stereotype.Service;

@Service("helloImpl")
public class HelloImpl implements HelloInterface {
    @Override
    public String sayHello(String name) {
        return "hello:"+name+"!";
    }
}
