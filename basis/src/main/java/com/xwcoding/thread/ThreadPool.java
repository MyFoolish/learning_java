package com.imxw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuxiaowei
 * @description
 * @date 2020/7/31 17:52
 */

/**
 * Java里面线程池的顶级接口是 java.util.concurrent.Executor，但是严格意义上讲 Executor 并不是一个线程池，而只是一个执行线程的工具。
 * 真正的线程池接口是 java.util.concurrent.ExecutorService
 *
 * java.util.concurrent.Executors 线程工厂类里面提供了一些静态工厂，生成一些常用的线程池。官方建议使用Executors工程类来创建线程池对象。
 * Executors类中有个创建线程池的方法如下：
 *      public static ExecutorService newFixedThreadPool(int nThreads) ：返回线程池对象。(创建的是有界线程池,也就是池中的线程个数可以指定最大数量)
 *      public Future<?> submit(Runnable task) :获取线程池中的某一个线程对象，并执行
 */
public class ThreadPool {
    public static void main(String[] args) {

        /**
         * 使用线程池中线程对象的步骤：
         *      1. 创建线程池对象。
         *      ExecutorService  pool = Executors.newFixedThreadPool(线程数量);
         *      2. 创建Runnable接口子类对象。(task)
         *      3. 提交Runnable接口子类对象。(take task)
         *      4. 关闭线程池(一般不做)。
         */

        // 创建线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(2);  //包含2个线程对象

        // 创建Runnable实例对象
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我要一个教练");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("教练来了：" + Thread.currentThread().getName());
                System.out.println("教我游泳，结束后教练回到了游泳池");
            }
        };
        // 自己创建线程对象的方式
//        Thread thread = new Thread(runnable, "自定义线程对象");
//        thread.start();

        // 从线程池中获取线程对象,然后调用MyRunnable中的run()
        executorService.submit(runnable);
        // 再获取个线程对象，调用MyRunnable中的run()
        executorService.submit(runnable);
        executorService.submit(runnable);

        // 注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。
        // 将使用完的线程又归还到了线程池中
        // 关闭线程池
        //service.shutdown();
    }
}
