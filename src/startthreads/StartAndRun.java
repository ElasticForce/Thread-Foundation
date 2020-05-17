package startthreads;

/**
 * @Author: ElasticForce
 */
public class StartAndRun {
    public static void main(String[] args) {
        Runnable r = () ->{
            System.out.println(Thread.currentThread().getName());
        };
        //直接调用run方法
        r.run();
        //调用start方法
        new Thread(r).start();
    }
}
