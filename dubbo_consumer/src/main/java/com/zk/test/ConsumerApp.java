package com.zk.test;

import com.zk.service.HelloInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApp {
    public static void main(String[] args) throws Exception {

        //读取配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo_consumer.xml"});
        System.out.println(context);
        //获取在zookeeper注册的服务接口
        HelloInterface helloService = (HelloInterface)context.getBean("helloInterface");
        System.out.println(helloService);

        //调用接口

        System.out.println("HelloService = " + helloService.sayHello("ant"));
        //不让控制台消失，按任意键结束
        System.in.read();
    }
}
