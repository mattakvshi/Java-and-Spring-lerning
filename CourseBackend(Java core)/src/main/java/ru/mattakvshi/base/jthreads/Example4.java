package ru.mattakvshi.base.jthreads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Example4 {
    //private static volatile int a = 0;
    private static AtomicInteger b = new AtomicInteger(0);

    public static void main(String []args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                        IntStream.range(0, 10).forEach(i -> b.incrementAndGet());
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                        IntStream.range(0,10).forEach(i -> b.decrementAndGet());
                }
            });

            thread.start();
            thread2.start();

            thread.join();
            thread2.join();

            System.out.println(b.intValue());
        }
    }
}
