package uncaughtexception;

/**
 * 这里尝试用普通的捕获异常方式来捕获子线程异常
 * @author: ElasticForce
 */
public class CantCatchSubThreadException {
    public static void main(String[] args) {
        try {
            new Thread(()->{throw new RuntimeException("子线程异常");}).start();
            System.out.println("如果捕获到，这句话不会执行");
        }catch (RuntimeException e){
            System.out.println("捕获到了子线程异常");
        }
    }
}
