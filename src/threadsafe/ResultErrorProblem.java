package threadsafe;

/**
 * 结果错误的线程安全问题
 * 演示计数不准确，找到出错的位置
 * @author: ElasticForce
 */
public class ResultErrorProblem {
    private static int index=0;
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10000; i++) {
                    index++;
                }
            }
        };
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(index);
    }
}
