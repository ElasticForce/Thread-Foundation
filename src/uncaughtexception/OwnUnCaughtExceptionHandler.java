package uncaughtexception;

/**
 * 设置自定义异常处理器
 * @author: ElasticForce
 */
public class OwnUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("自定义异常处理器捕获到"+t.getName()+"线程中的"+e.getMessage());
    }
}
