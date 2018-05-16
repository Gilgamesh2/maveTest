package com.example.demo1;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class JobTest    extends QuartzJobBean{
//{   @Scheduled(cron = " * * * * * ? ")
//    public void say(){
//        System.out.println("hello");
//    }




   private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(name);
    }
}
