package threadandobject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * join的原理实现
 * @author: ElasticForce
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"开始运行");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束运行");
        });
        thread.start();
        //thread.join();
        synchronized (thread){
            thread.wait();
        }
        System.out.println("主线程执行完毕");

    }
}
