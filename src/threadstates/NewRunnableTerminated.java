package threadstates;

/**
 * 展示线程的new、runnable、terminated状态
 * @author: ElasticForce
 */
public class NewRunnableTerminated {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                //运行中不停打印当前状态
                try {
                    System.out.println(Thread.currentThread().getState()+" "+i);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //开始前打印，应该为New
        System.out.println(thread.getState());
        thread.start();
        //开始后立刻打印，应该为Runnable
        System.out.println(thread.getState());
        Thread.sleep(500);
        //保证线程运行完后，打印状态，应该为Terminated
        System.out.println(thread.getState());
    }
}
