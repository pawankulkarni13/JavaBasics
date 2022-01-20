package string;

public class StringMisc {
    public static void main(String[] args) {
        nullRefMethod();
    }

    private static void nullRefMethod() {
        method(null);
    }

    private static void method(Object o) {
        System.out.println("Object method");
    }

    private static void method(String s) {
        System.out.println("String method");
    }
}
