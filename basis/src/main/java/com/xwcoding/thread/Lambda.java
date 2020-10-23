package com.imxw.thread;

/**
 * @author liuxiaowei
 * @description Lambda表达式
 * @date 2020/8/3 14:46
 */

/**
 * 函数式编程思想
 * 使用前提
 * 		必须有接口 并且接口中只有一个方法
 * 		参数类型或局部变量必须对应
 * 	标准格式
 * 		(参数类型 变量名)->{代码语句}
 * 		():小括号中写的参数的数据类型和变量名，没有参数空着不写，多个参数用,隔开
 * 		->:固定写法 代表指向动作
 *      {}:	方法体 和传统写法一致
 * 	省略规则
 * 		参数类型可以省略
 * 		参数只有一个小括号可以省略
 * 		大括号中只有一条语句时，可以省略大括号 分号及return
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程任务执行！");
            }
        }).start();
        System.out.println("线程任务执行！");

        // 使用Lambda表达式改写
        new Thread(() -> System.out.println("多线程任务执行！->Lambda表达式")).start();
    }
}
