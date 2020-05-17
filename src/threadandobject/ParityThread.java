package threadandobject;

/**
 * @author: ElasticForce
 */
public class ParityThread implements Runnable{
    private int num=0;
    @Override
    public void run() {
        synchronized (this){
            try {
                while (num<=100){
                    System.out.println(Thread.currentThread().getName()+" "+num++);
                    notify();
                    if (num<=100){
                        wait();
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ParityThread parityThread = new ParityThread();
        Thread evenThread = new Thread(parityThread,"偶数");
        Thread.sleep(100);
        Thread oddThread = new Thread(parityThread,"奇数");
        evenThread.start();
        oddThread.start();
    }
}

