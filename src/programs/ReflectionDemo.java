package programs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        MyClazz myClazz = new MyClazz();

        Class cls = myClazz.getClass();
        System.out.println("The name of class is " + cls.getName());

        Constructor constructor = cls.getConstructor();
        System.out.println("The name of constructor is " + constructor.getName());

        System.out.println("The public methods of class are : ");

        Method[] methods = cls.getMethods();

        for (Method method:methods)
            System.out.println(method.getName());

        Method m1 = cls.getDeclaredMethod("publicMethodWithArg", String.class);
        m1.invoke(myClazz, "from Pawan");

        Field field = cls.getDeclaredField("str");
        field.setAccessible(true);
        field.set(myClazz, "JAVA World!!!");

        Method m2 = cls.getDeclaredMethod("publicMethodWithNoArg");
        m2.invoke(myClazz);

        Method m3 = cls.getDeclaredMethod("privateMethod");
        m3.setAccessible(true);

        m3.invoke(myClazz);
    }
}

class MyClazz{

    private String str;

    public MyClazz() {
        this.str = "Hello World !!!";
    }
    public void publicMethodWithNoArg(){
        System.out.println("Public Method without Arg - The Welcome String is - " +str);
    }

    public void publicMethodWithArg(String s){
        System.out.println("Public Method with Arg - The Welcome String is - " +str + s);
    }

    private void privateMethod(){
        System.out.println("Private Method - The Welcome String is - "+str);
    }

}