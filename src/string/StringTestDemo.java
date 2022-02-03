package string;

public class StringTestDemo {
    final static int start = 2;

    public static int end = 0;

    final int variable = 30;

    public static void main(String[] args) {

        final int result = 20;

        final int anotherVar;
        ;

        StringTestDemo f = new StringTestDemo();

        anotherVar = 20;

        System.out.println(anotherVar);

        System.out.println(f.variable);

        System.out.println(f.foo(result));

        for (int k = 0; k < 3; k++) {

            switch (k) {

                case start:
                    System.out.print(" test1 ");

                case start - 1:
                    System.out.print(" test2 ");

                default:
                    System.out.print(" test0 ");

            }
        }

        //1
        String a = "test";

        String b = new String("test");

        String c = new String("test");

        String d = "test";

        System.out.println(b == c);

        System.out.println(a == c);

        System.out.println(a == d);

        //2
//        if (foo(256)){
//
//            System.out.println("valid");
//
//        }else{
//
//            System.out.println("Invalid");
//
//        }
    }

    int foo(int a) {

        return a + 5;

    }

    /*public static boolean foo(int a){

        if(a<=0){

            return false;

        }

        if(a==1){

            return true;

        }else{

            return foo(a%2);

        }

    }*/

}
