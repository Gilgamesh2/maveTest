package com.zk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class APp {

    public static void main(String []args) throws IOException {
        new ClassPathXmlApplicationContext(new String[]{"dubbo_provider.xml"});
        System.out.println("provider服务已注册");
        //使线程阻塞
        System.in.read();
    }
}
