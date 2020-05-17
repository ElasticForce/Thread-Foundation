package threadsafe;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用public方法使得private对象逸出
 * @author: ElasticForce
 */
public class ObjectEscape {
    public static void main(String[] args) {
        Escpae escpae = new Escpae();
        Map cities = escpae.getCities();
        System.out.println(cities.remove(3));
        System.out.println(cities.get(3));
    }
}
class Escpae{
    private Map<Integer,String> cities;

    public Escpae() {
        cities=new HashMap<>();
        cities.put(1,"北京");
        cities.put(2,"上海");
        cities.put(3,"广州");
    }
    public Map getCities(){
        return cities;
    }
}
