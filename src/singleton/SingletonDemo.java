package singleton;

public class SingletonDemo {
    public static SingletonDemo instance = new SingletonDemo();

    private SingletonDemo() {
    }
    public SingletonDemo getInstance(){
        return instance;
    }
}
