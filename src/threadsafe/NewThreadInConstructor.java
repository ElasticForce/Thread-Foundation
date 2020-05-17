package threadsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 在构造函数中新建一个线程
 * @author: ElasticForce
 */
public class NewThreadInConstructor {
    private Map<Integer,String> cities;

    public NewThreadInConstructor() {
        new Thread(()->{
            cities=new HashMap<>();
            cities.put(1,"北京");
            cities.put(2,"上海");
            cities.put(3,"广州");
        }).start();
    }
    public Map getCities(){
        return cities;
    }
    public Map getCitiesProvided(){
        return new HashMap(cities);
    }

    public static void main(String[] args) throws InterruptedException {
        NewThreadInConstructor threadInConstructor = new NewThreadInConstructor();
        Map cities = threadInConstructor.getCities();
        //TimeUnit.SECONDS.sleep(1);
        System.out.println(cities.get(1));
    }
}

