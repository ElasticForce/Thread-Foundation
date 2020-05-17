package threadandobject;

import java.util.concurrent.TimeUnit;

/**
 * 使用TimeUnit中的sleep方法
 * @author: ElasticForce
 */
public class InterruptTimeUnitSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i <10; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        Thread.sleep(1);
        thread.interrupt();
    }
}
