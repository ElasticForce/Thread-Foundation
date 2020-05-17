package uncaughtexception;

/**
 * @author: ElasticForce
 */
public class UseOwnUnCaughtExceptionHandler {
    public static void main(String[] args) {
        //使用自定义的全局异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new OwnUnCaughtExceptionHandler());
        new Thread(()->{
            throw new RuntimeException("子线程异常");
        }).start();
        int i= 1/0;
    }
}
