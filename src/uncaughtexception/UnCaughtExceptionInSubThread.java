package uncaughtexception;

/**
 * 子线程抛出异常时，主线程不会停止
 * @author: ElasticForce
 */
public class UnCaughtExceptionInSubThread {
    public static void main(String[] args) {
        new Thread(()->{
           throw new RuntimeException("子线程发生了异常");
        }).start();

        for (int i = 0; i <1000; i++) {
            System.out.println("保存日志信息");
        }
    }
}
