package programs;

import java.lang.reflect.InvocationTargetException;

class First{
    String s;
}
class Second{
    String s;
}
public class NewOperatorNewInstanceDemo {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        createObject("First");
        createObject("Second");
    }

    private static void createObject(String cls) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object obj = Class.forName(cls).newInstance();
//        Object obj = Class.forName(cls).getDeclaredConstructor().newInstance();
        System.out.println("Object created for class:" + obj.getClass().getName());
    }
}


