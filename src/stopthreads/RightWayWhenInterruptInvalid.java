package stopthreads;

/**
 * 不应该生吞异常，而是将异常抛给调用者
 * run方法是顶层函数，不能再向上抛出异常，需要处理该异常
 * @author: ElasticForce
 */
public class RightWayWhenInterruptInvalid implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("exception");
            try {
                throwAnException();
            } catch (InterruptedException e) {
                System.out.println("保存日志文件,跳出循环");
                e.printStackTrace();
                break;
            }
        }
    }

    public void throwAnException() throws InterruptedException {
        Thread.sleep(2000);
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new RightWayWhenInterruptInvalid());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }


}
