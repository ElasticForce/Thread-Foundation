package threadandobject;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用wait/notify来完成一个生产者消费者模式
 * @author: ElasticForce
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        TransactionStorage storage = new TransactionStorage(10);
        Thread producer = new Thread(new Producer(storage));
        Thread consumer = new Thread(new Consumer(storage));
        producer.start();
        consumer.start();
    }
}
class TransactionStorage{
    private int maxszie;
    private LinkedList<Date> list;

    //设置仓库容量
    public TransactionStorage(int maxszie) {
        this.list = new LinkedList<>();
        this.maxszie=maxszie;
    }

    public synchronized void put() throws InterruptedException {
        if (list.size()==maxszie){
            //库存满了就等待
            wait();
        }
        list.add(new Date());
        System.out.println("生产者生产了商品，仓库剩余容量"+list.size());
        //仓库有库存就唤醒消费者
        notify();
    }

    public synchronized void take() throws InterruptedException {
        if (list.size()==0){
            //仓库没有库存就进入等待
            wait();
        }
        System.out.println(list.poll()+"消费者购买了商品，仓库剩余容量:"+list.size());
        //仓库有空位就唤醒生产者
        notify();
    }
}

class Producer implements Runnable{
    TransactionStorage storage;

    public Producer(TransactionStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    TransactionStorage storage;

    public Consumer(TransactionStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
