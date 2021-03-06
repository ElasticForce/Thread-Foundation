package stopthreads;

/**
 * 如果sleep在循环内部的话，打断操作会失效
 * @author: ElasticForce
 */
public class InterruptInvalid {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= 100) {
                if (num % 10 == 0) {
                    System.out.println(num);
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        //确保thread线程进入阻塞状态后，再进行打断
        Thread.sleep(100);
        thread.interrupt();
    }
}
