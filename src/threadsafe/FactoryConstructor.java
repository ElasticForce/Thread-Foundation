package threadsafe;

/**
 * 使用工厂方法来解决
 * @author: ElasticForce
 */
public class FactoryConstructor {
    static FactoryUser user;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                user=getInstance(1,"张三");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(200);
        System.out.println(user);
    }
    public static FactoryUser getInstance(int id,String name) throws InterruptedException {
        FactoryUser safeuser = new FactoryUser(id,name);
        return safeuser;
    }
}
class FactoryUser{
    private int id;
    private String name;

    public FactoryUser(int id, String name) throws InterruptedException {
        this.id = id;
        //在构造函数中对user进行赋值
        FactoryConstructor.user=this;
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

