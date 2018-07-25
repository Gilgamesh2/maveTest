package com.quart.test;
import java.util.concurrent.*;

public class ThreadPoolTest implements Runnable {
    public static void main(String[]args){
        //  Executors.newSingleThreadExecutor(); 单线程的线程池
        // Executors.newCachedThreadPool() ; 可缓存的线程池
        // Executors.newFixedThreadPool(10); 固定大小的线程池
        ExecutorService service=Executors.newSingleThreadExecutor();
            for(int i=0;i<52;i++){
                service.execute(new ThreadPoolTest(String.valueOf(i)));
            }






    }
    private String s;
    ThreadPoolTest(String s){
        this.s=s;
    }
    @Override
    public void run() {

        System.out.println( Thread.currentThread()+s);
    }
}
