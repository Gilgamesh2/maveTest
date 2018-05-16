package com.example.demo1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Consumer {
    @JmsListener(destination = "queue")
    public void reciver(String msg){
        System.out.println(msg);

    }

}
