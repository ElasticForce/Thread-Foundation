package stopthreads;

/**
 * 普通的正确结束线程的方式（没有sleep、wait方法）
 * @author: ElasticForce
 */
public class RightWayToStopThreadNormal{
    public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(()->{
        int num=0;
        while (!Thread.currentThread().isInterrupted()&&num<=Integer.MAX_VALUE/10000){
            System.out.println(num);
            num++;
        }
    });

    thread.start();
    Thread.sleep(1000);
    thread.interrupt();
    }
}
