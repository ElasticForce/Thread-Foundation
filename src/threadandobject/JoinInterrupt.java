package threadandobject;

import java.util.concurrent.TimeUnit;

/**
 * join被中断的情况
 * @author: ElasticForce
 */
public class JoinInterrupt {
    public static void main(String[] args){
        //获取主线程
        Thread main = Thread.currentThread();
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"开始运行");
            try {
                //在子线程中中断主线程
                main.interrupt();
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被中断了");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            thread.interrupt();
            System.out.println(Thread.currentThread().getName()+"被中断了");
        }
        System.out.println("主线程结束运行");
    }
}
