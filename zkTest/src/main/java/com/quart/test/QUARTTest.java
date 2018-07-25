package com.quart.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QUARTTest {
    public static void main(String[] args) throws SchedulerException {
        //使用JobBuilder来构建JobDetail,并为其设置相关属性
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "myGroup").usingJobData("name", "xiaogui").build();
        //使用TriggerBuilder来构建触发器，并设置相关属性
        //触发器有两种
        // SimpleScheduleBuilder和CronScheduleBuilder（类似于Linux的Crontab，需设置相应表达式）

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "triggerGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * ? * *")).build();
        //使用StdSchedulerFactory、Scheduler来创建调度者
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();


    }

}
