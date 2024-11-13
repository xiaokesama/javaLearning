package com.xiaoke.threadLocal;

public class ThreadLocalExample {

    // 创建一个 ThreadLocal 变量
    private static ThreadLocal<String> threadLocalVar = ThreadLocal.withInitial(() -> "Initial Value");

    public static void main(String[] args) {
        // 创建线程
        Thread thread1 = new Thread(() -> {
            System.out.println("1 Thread 1: " + threadLocalVar.get()); // 输出: Initial Value
            threadLocalVar.set("2 Thread 1 Value");
            System.out.println("3 Thread 1: " + threadLocalVar.get()); // 输出: Thread 1 Value
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("4 Thread 2: " + threadLocalVar.get()); // 输出: Initial Value
            threadLocalVar.set("5 Thread 2 Value");
            System.out.println(" 6 Thread 2: " + threadLocalVar.get()); // 输出: Thread 2 Value
        });

        thread1.start();
        thread2.start();
    }
}