package generics;

public class GenericsDemo {
    public static void main (String[] args) {
        GenericClass <String, Integer> obj =
                new GenericClass<String, Integer>("Generic Class Example !", 10);

        obj.print();

        //See the ease of using Generics ?
        GenericClass <String, String> obj2 =
                new GenericClass<String, String>("Generic Class Example !", "10");

        obj2.print();
    }
}
class GenericClass<T, U> {
    T obj1;  // An object of type T
    U obj2;  // An object of type U

    // constructor
    GenericClass(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    // To print objects of T and U
    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
