package ru.mattakvshi.base.jthreads;

import java.util.concurrent.locks.ReentrantLock;

public class Example3 {
    private static int a = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String []args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    //System.out.println(Thread.currentThread().getName());
                    if (a % 2 == 0) System.out.println(a);
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    //System.out.println(Thread.currentThread().getName());
                    a++;
                    lock.unlock();
                }
            }
        });

        System.out.println(Thread.currentThread().getName());

        Thread.sleep(5000);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println("end");
    }
}
