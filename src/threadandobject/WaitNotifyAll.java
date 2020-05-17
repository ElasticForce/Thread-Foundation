package threadandobject;

/**
 * 使用notifyAll来唤醒所有等待的线程
 * @author: ElasticForce
 */
public class WaitNotifyAll {

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread(object);
        //设置三个线程来争夺锁
        new Thread(waitThread).start();
        new Thread(waitThread).start();
        new Thread(waitThread).start();

        //让三个线程都进入等待状态
        Thread.sleep(1000);
        //让唤醒线程来唤醒所有等待的线程
        new Thread(()->{
            synchronized (object){
                System.out.println("唤醒线程获取到monitor");
                object.notifyAll();
                System.out.println("唤醒线程执行结束");
            }
        }).start();
    }
}

class WaitThread implements Runnable{
    private Object object;

    public WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
            synchronized (object){
                try {
                    System.out.println(Thread.currentThread().getName()+"获取到monitor");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"结束");
            }
    }
}
