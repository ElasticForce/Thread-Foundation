package threadandobject;

import java.util.concurrent.locks.ReentrantLock;

/**
 * sleep不会释放lock
 * @author: ElasticForce
 */
public class SleepDontReleaseLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable r = () -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取到了lock");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"释放了lock");
            }
        };
        new Thread(r).start();
        new Thread(r).start();
    }
}
