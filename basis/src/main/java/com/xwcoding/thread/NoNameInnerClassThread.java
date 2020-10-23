package com.imxw.thread;

/**
 * @author liuxiaowei
 * @description 匿名内部类方式实现线程的创建
 * @date 2020/7/29 16:56
 */
public class NoNameInnerClassThread {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        };
        new Thread(runnable, "MyFoolish").start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Passerby" + i);
        }
    }
}
