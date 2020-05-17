package stopthreads;

/**
 * stop方法会使线程突然终止
 * @author: ElasticForce
 */
public class StopMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            //模拟银行转账,有100笔订单正在转账,每次转账需要50ms
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.stop();
    }
}
