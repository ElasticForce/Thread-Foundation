package threadandobject;

import java.util.concurrent.TimeUnit;

/**
 * @author: ElasticForce
 */
public class JoinState {
    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                //打印join期间主线程的状态
                System.out.println("join期间主线程状态："+main.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println("join前主线程状态："+main.getState());
        thread.join();
        System.out.println("join后主线程状态："+main.getState());
    }
}
