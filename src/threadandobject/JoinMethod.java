package threadandobject;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * 测试join方法
 * @author: ElasticForce
 */
public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Long before = System.currentTimeMillis();
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
        Long after = System.currentTimeMillis();
        System.out.println("主线程执行完毕"+(after-before));
    }
}
