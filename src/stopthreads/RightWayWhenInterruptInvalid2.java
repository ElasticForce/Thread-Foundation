package stopthreads;

/**
 * 自己恢复中断，调用者可以判断到发生了中断
 * @author: ElasticForce
 */
public class RightWayWhenInterruptInvalid2 implements Runnable{
    @Override
    public void run() {
        while (true&&!Thread.currentThread().isInterrupted()){
            System.out.println("exception");
            reInterrupt();
        }
    }

    public void reInterrupt(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new RightWayWhenInterruptInvalid2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }


}
