package threadsafe;

/**
 * 观察者模式，注册监听器风险
 * @author: ElasticForce
 */
public class RegisterListener {
    int count;

    public RegisterListener(MySource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println("\n获得的count:"+count);
            }
        });
        for (int i = 0; i <1000; i++) {
            System.out.print(" ");
        }
        count=77;
    }

    public static void main(String[] args) {
        MySource source = new MySource();
        new Thread(()->{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            source.eventCome(new Event() {
            });
        }).start();
        RegisterListener registerListener = new RegisterListener(source);
    }

    interface Event{
    }
    interface EventListener{
        void onEvent(Event event);
    }
    static class MySource{
        private EventListener listener;
        void registerListener(EventListener eventListener){
            this.listener=eventListener;
        }
        void eventCome(Event event){
            if (listener!=null){
                listener.onEvent(event);
            }else {
                System.out.println("初始化未完成");
            }
        }
    }
}
