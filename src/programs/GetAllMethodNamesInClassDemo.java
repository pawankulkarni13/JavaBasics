package programs;

import list.linkedlist.SinglyLL;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllMethodNamesInClassDemo {
    public static void main(String[] args) throws Exception {

        System.out.println("Method Names - ");
        getAllMethods(SinglyLL.class).forEach(System.out::println);

        System.out.println("Public Field Names - ");
        getAllPublicFieldNames(SinglyLL.class).forEach(System.out::println);

        System.out.println("All Field Names - ");
        getAllFieldNames(SinglyLL.class).forEach(System.out::println);

        System.out.println("Creating Object of SinglyLL");
        SinglyLL singlyLL = (SinglyLL) createObject("list.linkedlist.SinglyLL");
        if (singlyLL != null) {
            System.out.println("Succesfully Created Object "+singlyLL.toString());
        } else {
            System.out.println("Null Reference");
        }
    }

    public static List<String> getAllMethods(final Class<?> cls) {
        return Arrays.stream(cls.getDeclaredMethods())
                .map(Method::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getAllPublicFieldNames(final Class<?> cls) {
        return Arrays.stream(cls.getFields())
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getAllFieldNames(final Class<?> cls) {
        List fields = new ArrayList<String>();
        Class currentCls = cls;
        while (currentCls != null) {
            fields.addAll(
                    Arrays.stream(currentCls.getDeclaredFields())
                            .filter(field -> !field.isSynthetic())
                            .map(Field::getName)
                            .collect(Collectors.toList()));
            currentCls = currentCls.getSuperclass();
        }
        return fields;
    }

    public static Object createObject(String cls)
            throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            ClassNotFoundException {
        Class objectClass = Class.forName(cls);
        Constructor objectConstructor = objectClass.getConstructor();
        return objectConstructor.newInstance();
    }

}
