package com.vaibhav.snippets.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockShow {

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        d.executeTask();
    }

}
class DeadLock {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();


    public void executeTask() {
        Test1 t1 = new Test1(lock1, lock2);
        Test2 t2 = new Test2(lock1, lock2);

        Thread t11 = new Thread(t1);
        Thread t22 = new Thread(t2);
        t11.start();
        t22.start();
    }
}


    class Test1 implements  Runnable {

        Lock lock1 ;
        Lock lock2 ;
    Test1(Lock l1, Lock l2) {
        this.lock1 = l1;
        this.lock2 = l2;
    }

        @Override
        public void run() {
            System.out.println("test 1 is going to acquire lock 1");
            lock1.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test 1 is going to acquire lock 2");
            lock2.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock1.unlock();
            lock2.unlock();
        }
    }

    class  Test2 implements  Runnable {

        Lock lock1 ;
        Lock lock2 ;
        Test2(Lock l1, Lock l2) {
            this.lock1 = l1;
            this.lock2 = l2;
        }
        @Override
        public void run() {
            System.out.println("test 2 is going to acquire lock 2");
            lock2.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test 2 is going to acquire lock 1");
            lock1.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock2.unlock();
            lock1.unlock();
        }
    }




