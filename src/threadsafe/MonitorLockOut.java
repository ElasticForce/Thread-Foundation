package threadsafe;

import java.util.concurrent.TimeUnit;

/**
 * 嵌套监视器的锁死
 * @author: ElasticForce
 */
public class MonitorLockOut {
    public static void main(String[] args) throws InterruptedException {
        Object monitorA = new Object();
        Object monitorB = new Object();
        new Thread(()->{
            synchronized (monitorA){
                synchronized (monitorB){
                    try {
                        System.out.println(Thread.currentThread().getName()+"进入等待");
                        monitorB.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程01").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            synchronized (monitorA){
                synchronized (monitorB){
                    System.out.println(Thread.currentThread().getName()+"开始唤醒");
                    monitorB.notifyAll();
                }
            }
        },"线程02").start();
    }
}
