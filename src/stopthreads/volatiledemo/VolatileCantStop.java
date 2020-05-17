package stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者模式下的Volatile
 * 情形：生产者生产速度大于消费者消费速度
 * 生产者会将商品存入阻塞队列中
 * @author: ElasticForce
 */
public class VolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<>(10);

        Producer producer = new Producer(storage);

        Thread thread = new Thread(producer);
        //生产者开始生产
        thread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (Math.random()<0.85){
            System.out.println("消费者取出"+consumer.takeNums());
            Thread.sleep(100);
        }
        System.out.println("消费者不再消费");
        producer.cancelFlag=true;
        System.out.println(producer.cancelFlag);
    }
}
class Producer implements Runnable{
    public volatile boolean cancelFlag = false;
    BlockingQueue<Integer> storage;

    public Producer(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num=0;
        try {
            while (num<Integer.MAX_VALUE&&!cancelFlag){
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
