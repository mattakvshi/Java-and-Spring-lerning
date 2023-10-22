package ru.mattakvshi.base.jthreads;

import java.util.concurrent.Semaphore;

public class Example1 {
    private static int a = 0;
    private static Semaphore sem = new Semaphore(1);

    public static void main(String []args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                     if(sem.tryAcquire()){
                         //System.out.println(Thread.currentThread().getName());
                         if (a % 2 == 0) System.out.println(a);
                         sem.release();
                     }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(sem.tryAcquire()) {
                        //System.out.println(Thread.currentThread().getName());
                        a++;
                        sem.release();
                    }
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
