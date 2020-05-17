package stopthreads.volatiledemo;

/**part1:适用的情况
 * @author: ElasticForce
 */
public class VolatileUseful {
    private static volatile boolean cancelFlag=false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           int num=0;
           try {
                while (num<1000&&!cancelFlag){
                 System.out.println(num++);
                 Thread.sleep(10);
               }
           }catch (InterruptedException e) {
               e.printStackTrace();
           }
        });
        thread.start();
        Thread.sleep(1000);
        cancelFlag = true;

    }
}
