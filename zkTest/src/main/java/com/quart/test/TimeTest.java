package com.quart.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {
    public static void main(String[] args) {
        //使用JAVA自带的定时类-Timer
        /*
        必须继承TimerTasks重写run方法--在run方法中写要执行的事
         */
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        //timer.schedule(任务，第一次执行的时间（如果小于当前时间则会立即执行），执行周期（下一次执行的时间）)
        timer.schedule(new MyTask(), calendar.getTime(), 10000);
    }
}

class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println(new SimpleDateFormat("yyyy;MM:dd").format(this.scheduledExecutionTime()));
    }
}
