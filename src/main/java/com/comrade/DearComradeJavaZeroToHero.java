package com.comrade;

import java.util.concurrent.Executors;


public class DearComradeJavaZeroToHero
{
    public static void main( String[] args ) throws InterruptedException {
        creatingPlatformThread();
        creatingVirtualThread();
        creatingVirtualThreadUsingExecutor();
        Thread.sleep(1000);
    }

    private static void creatingVirtualThreadUsingExecutor() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
            executor.submit(()-> System.out.println(Thread.currentThread()));
        }
    }

    private static void creatingVirtualThread() {
        Thread.ofVirtual().start(()->System.out.println(Thread.currentThread()));
    }

    private static void creatingPlatformThread()  {
        Thread.ofPlatform().start(()->System.out.println(Thread.currentThread()));
    }
}
