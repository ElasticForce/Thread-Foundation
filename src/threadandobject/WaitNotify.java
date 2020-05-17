package threadandobject;

/**
 * 使用notify来唤醒等待的线程
 * @author: ElasticForce
 */
public class WaitNotify {
    //设置一个普通对象
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        //线程1获取到锁后进入等待，释放锁
        Thread thread1 = new Thread(()->{
           synchronized (object){
               try {
                   System.out.println(Thread.currentThread().getName()+"获取到monitor");
                   object.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+"结束");
           }
        });

        //线程2获取到锁后，唤醒线程1，自己运行完后，线程1再运行
        Thread thread2 = new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"获取到monitor");
                object.notify();
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        });

        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}
