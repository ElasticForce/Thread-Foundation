package createthreads;

/**
 * 用Runnable实现线程
 * @author ElasticForce
 */
public class RunnableStyle implements Runnable{

    @Override
    public void run() {
        System.out.println("使用Runnable实现线程");
    }

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }
}
