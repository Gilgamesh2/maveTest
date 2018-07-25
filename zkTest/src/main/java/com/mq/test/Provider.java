package com.mq.test;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;

public class Provider {
    private static final String USER = ActiveMQConnectionFactory.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
    private static final String URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

    public  void main() throws JMSException {

        //创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
        //利用工厂创建连接
        Connection connection = factory.createConnection();
        connection.start();
        //创建会话,并设置配置参数（是否启用事务、签收模式等）
        // connection.createSession(boolean b,int i)
        // 当b为true时，默认i=SessionSession.SESSION_TRANSACTED
        // b为false时，i可以为
        //Session.AUTO_ACKNOWLEDGE 自动确认
        // Session.CLIENT_ACKNOWLEDGE 等待客户端确认 消费者必须调javax.jms.Message的acknowledge方法。jms服务器才会删除消息。
        //  Session.DUPS_OK_ACKNOWLEDGE 允许副本的确认模式

        Session session = connection.createSession(true,Session.SESSION_TRANSACTED);
        //通过session创建对列
        Destination destination = session.createQueue("queue");
        //通过session创建生产者/消费者
        MessageProducer producer = session.createProducer(destination);
        //设置持久化/非持久化，非持久化MQ关闭后，消息会丢失，持久化则不会
        // PERSISTENT :持久性消息
        // NON_PERSISTENT :非持久性消息
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //使用Session创建发送的消息
        TextMessage message = session.createTextMessage();
        message.setText("hello World!");
        producer.send(destination, message);
        session.commit();
        //释放连接
        if (connection != null) {
            connection.close();
        }


    }

}
