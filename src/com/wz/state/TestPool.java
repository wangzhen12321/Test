package com.wz.state;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {

    public static void main(String[] args) {
        //创建服务，创建线程池
        //newFixedThreadPool:创建一个定长线程，可控制最大并发数，超出的线程会在队列中等待 参数为池子大小
        ExecutorService service= Executors.newFixedThreadPool(10);
        /**
         * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收线程，若无可回收，则新建线程
         * ExecutorService service= Executors.newCachedThreadPool();
         *
         * 创建一个定长线程，支持定时周期性任务执行
         * ExecutorService service= Executors.newScheduledThreadPool(10)
         *
         * 创建一个单线程池，他会用唯一的工作线程来执行任务，保证所有人物按指定顺序执行
         * ExecutorService service= Executors.newSingleThreadExecutor();
         */

        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭连接
        service.shutdown();
    }
}
class MyThread implements Runnable{
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());
    }
}
