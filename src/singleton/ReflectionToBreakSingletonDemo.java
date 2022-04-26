package singleton;

import java.lang.reflect.Constructor;

public class ReflectionToBreakSingletonDemo {
    public static void main(String[] args) {

        SingletonDemo instance1 = SingletonDemo.instance;
        SingletonDemo instance2 = null;
        try {
            Constructor[] constructors = SingletonDemo.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (SingletonDemo) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- " + instance1.hashCode());
        System.out.println("instance2.hashCode():- " + instance2.hashCode());

        System.out.println("instance1.getInstance().hashCode():- " + instance1.getInstance().hashCode());
        System.out.println("instance2.getInstance().hashCode():- " + instance2.getInstance().hashCode());

        //See the difference ?
    }
}
