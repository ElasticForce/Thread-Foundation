package threadsafe;

import java.util.concurrent.TimeUnit;

/**
 * 构造函数还未执行完毕，就this赋值导致的逸出
 * @author: ElasticForce
 */
public class ThisAssignmentEscape {
    static User user;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                new User(1,"张三");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(200);
        System.out.println(user);
    }
}
class User{
    private int id;
    private String name;

    public User(int id, String name) throws InterruptedException {
        this.id = id;
        //在构造函数中对user进行赋值
        ThisAssignmentEscape.user=this;
        Thread.sleep(100);
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
