package threadsafe;

import java.util.concurrent.TimeUnit;

/**
 * 锁死的简单演示
 * @author: ElasticForce
 */
public class SemaphoreLockOut {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                synchronized (object){
                    System.out.println("开始等待");
                    object.wait();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            synchronized (object){
                System.out.println("开始唤醒");
                object.notifyAll();
            }

        }).start();
    }
}
