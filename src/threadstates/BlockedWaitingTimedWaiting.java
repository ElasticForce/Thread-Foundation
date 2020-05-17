package threadstates;

/**
 * 线程的Blocked、Waiting、TimedWaiting状态
 * @author: ElasticForce
 */
public class BlockedWaitingTimedWaiting {
    public static void main(String[] args) throws InterruptedException {
        TestState state = new TestState();
        //设置两个线程竞争同一个资源
        Thread thread1 = new Thread(state);
        //保证thread1先执行run方法，先抢到锁
        thread1.start();
        Thread.sleep(100);
        //thread2后进入，会进入阻塞状态
        Thread thread2 = new Thread(state);
        thread2.start();
        //此时应该打印thread1线程处于计时等待状态
        System.out.println(thread1.getName()+" "+thread1.getState());
        //此时应该打印thread2线程处于阻塞状态
        System.out.println(thread2.getName()+" "+thread2.getState());
        Thread.sleep(1000);
        //确保thread1执行wait方法，此时应该打印thread1线程处于等待状态
        System.out.println(thread1.getName()+" "+thread1.getState());
    }
}
class TestState implements Runnable{

    @Override
    public void run() {
        try {
            syn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void syn() throws InterruptedException {
        Thread.sleep(1000);
        wait();
    }
}