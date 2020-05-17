package uncaughtexception;

/**
 * 在子线程内部捕获异常
 * @author: ElasticForce
 */
public class TryCatchInSubThread{
    public static void main(String[] args) {
        try {
            new Thread(()->{
                try {
                    throw new RuntimeException("子线程异常");
                }catch (RuntimeException e){
                    System.out.println("在子线程内部捕获到了异常");
                }
            }).start();
            System.out.println("如果捕获到，这句话不会执行");
        }catch (RuntimeException e){
            System.out.println("在主线程捕获到了子线程异常");
        }
    }
}
