package threadproperties;

/**
 * 线程的id
 * @author: ElasticForce
 */
public class ThreadId {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程id:"+Thread.currentThread().getId());
        System.out.println("子线程id:"+thread.getId());
    }
}
