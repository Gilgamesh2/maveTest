package com.quart.test;

import com.mq.test.Consumer;
import com.mq.test.Provider;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.Date;

public class MyJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

         Provider p1=new Provider();
        Consumer p=new Consumer();
        try {
            p1.main();
            p.main();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
