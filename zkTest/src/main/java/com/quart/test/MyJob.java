package com.quart.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("执行：" + new Date() + "," + jobExecutionContext.getJobDetail().getJobDataMap().get("name"));

    }
}
