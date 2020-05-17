package threadsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁的简单演示
 * @author: ElasticForce
 */
public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(()->{
            synchronized (lock1){
                try {
                    System.out.println(Thread.currentThread().getName()+"获取到锁1");
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName()+"获取到锁2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1").start();
        new Thread(()->{
            synchronized (lock2){
                try {
                    System.out.println(Thread.currentThread().getName()+"获取到锁2");
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName()+"获取到锁1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程2").start();
    }
}
