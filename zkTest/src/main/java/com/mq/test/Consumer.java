package com.mq.test;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    private static final String USER = ActiveMQConnectionFactory.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
    private static final String URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;


 public  void main() throws JMSException {
        //建立连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
        //通过工厂建立连接
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //创建会话并设置是否支持事务 及确认方式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Queue queue = session.createQueue("queue");
        //创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
        //接收消息
     // 接收文本消息
     // TextMessage textMessage=(TextMessage) messageConsumer.receive();
        Message message = messageConsumer.receive(100);

        System.out.println("Consumer.main:" + message);

        //关闭连接
        connection.close();


    }



}