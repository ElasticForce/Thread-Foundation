package createthreads;

/**
 * 使用Thread实现线程
 * @author ElasticForce
 */
public class ThreadStyle extends Thread{
    @Override
    public void run() {
        System.out.println("使用Thread类实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
