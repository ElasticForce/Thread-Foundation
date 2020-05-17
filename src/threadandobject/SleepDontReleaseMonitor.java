package threadandobject;

/**
 * 正面sleep不会释放monitor锁
 * @author: ElasticForce
 */
public class SleepDontReleaseMonitor {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    System.out.println(Thread.currentThread().getName()+"获取到了monitor");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"退出同步代码块");
                }
            }
        };
        new Thread(r).start();
        new Thread(r).start();
    }
}
