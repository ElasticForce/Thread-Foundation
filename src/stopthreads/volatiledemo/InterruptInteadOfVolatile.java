package stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: ElasticForce
 */
public class InterruptInteadOfVolatile {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<>(10);
        InterruptInteadOfVolatile major = new InterruptInteadOfVolatile();
        Producer producer =major.new Producer(storage);

        Thread thread = new Thread(producer);
        System.out.println(thread.getState());
        //生产者开始生产
        thread.start();
        Thread.sleep(1000);

        Consumer consumer = major.new Consumer(storage);
        while (Math.random()<0.85){
            System.out.println("消费者取出"+consumer.takeNums());
            Thread.sleep(100);
        }
        System.out.println("消费者不再消费");
        thread.interrupt();
    }

class Producer implements Runnable{
    BlockingQueue<Integer> storage;

    public Producer(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num=0;
        try {
            while (num<Integer.MAX_VALUE&&!Thread.currentThread().isInterrupted()){
                if (Integer.bitCount(num)==1){
                    storage.put(num);
                    System.out.println(num+"存入仓库");
                    Thread.sleep(10);
                }
                num++;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产停止");
        }
    }
}

class Consumer{
    BlockingQueue<Integer> storage;

    public Consumer(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    public Integer takeNums() throws InterruptedException {
        return storage.take();
    }
}
}
