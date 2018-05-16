package com.mq.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    private static final String USER = ActiveMQConnectionFactory.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
    private static final String URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("queue");
        MessageConsumer messageConsumer = session.createConsumer(queue);
        Message message = messageConsumer.receive();
        System.out.println("Consumer.main:" + message);

        connection.close();


    }
}
