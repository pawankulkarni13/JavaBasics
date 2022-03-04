package programs;

//  The static initializer is a static {} block of code inside java class,
//  and run only one time before the constructor or main method is called.
public class StaticBlockDemo {
    public StaticBlockDemo(){
        System.out.println("Constructor !!!");
    }
    static {
        System.out.println("Static Block !!!");
    }

    public static void main(String[] args) {
        System.out.println("Main Method");

        System.out.println(Test.i);
    }
}

class Test {
    static int i;

    public Test(){
        System.out.println("Test Constructor !!!");
    }
    static {
        System.out.println("Test Static Block !!!");
        i = 100;
    }
}

