package programs;

public class StaticBlockDemo {
    static
    {
        System.out.println("b");
    }

    public static void main(String[] args)
    {
        System.out.println("c");

        System.out.println(Test.i);
    }
}

class Test {
    static int i;

    static
    {
        System.out.println("a");

        i = 100;
    }
}

