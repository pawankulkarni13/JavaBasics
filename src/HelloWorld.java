public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("This is Main Method !!");


        Class c = HelloWorld.class;
        System.out.println(c.getClassLoader());

        System.out.println(String.class.getClassLoader());
    }
}
