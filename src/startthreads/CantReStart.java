package startthreads;

/**
 * 不能重复调用start方法
 * @Author: ElasticForce
 */
public class CantReStart {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();
        thread.start();
    }
}
