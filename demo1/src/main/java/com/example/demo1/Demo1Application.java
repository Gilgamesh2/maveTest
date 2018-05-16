package com.example.demo1;

import org.apache.activemq.command.ActiveMQQueue;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class Demo1Application {
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("queue");
	}
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	@Bean
    public JobDetail sampleJob(){
        return JobBuilder.newJob(JobTest.class).withIdentity("sampleJob")
                .usingJobData("name", "World").storeDurably().build();
    }
    @Bean
    public Trigger sampleTrigger(){
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule(" * * * * * ? ");

        return TriggerBuilder.newTrigger().forJob(sampleJob()).withIdentity("sampleTrigger")
                .withSchedule(scheduleBuilder).build();

    }
}
