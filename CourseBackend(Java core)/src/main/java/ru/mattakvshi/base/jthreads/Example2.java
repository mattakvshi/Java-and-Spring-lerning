package ru.mattakvshi.base.jthreads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Example2 {
    private static int a = 0;
    private static AtomicInteger b = new AtomicInteger(0);

    public static void main(String []args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Example2.class) {
                    //for(int i = 0; i < 10; i++)a++;
                    System.out.println("Thread 1: ");
                    IntStream.range(0, 10).forEach(i -> a++);
                    System.out.println("End thread 1.");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Example2.class){
                    System.out.println("Thread 2: ");
                    IntStream.range(0,10).forEach(i -> a--);
                    System.out.println("End thread 2.");

                }
            }
        });

            thread.start();
            thread2.start();

            thread.join();
            thread2.join();

            System.out.println(a);
    }
}
