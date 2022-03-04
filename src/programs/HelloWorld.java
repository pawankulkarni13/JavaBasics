package programs;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {

        System.out.println(100 + 100 +"String" );
        System.out.println("String Company" + 100 + 100);

        String s = "hello";

        double d1 = 1.1;
        double d2 = 1.01;
        System.out.println(d1==d2);

        System.out.println("Hello World");
        Parent obj = new Child();
        obj.display();

        int [] arr = new int[3];

        Arrays.stream(arr).min().getAsInt();

        int a =1;
        double b =3;
        float c=4;
        long d=5;

//        int i = (a + d) * (c + b);
        char ch = "gin".charAt(0);
        System.out.println("agin".charAt(0)-'a');

    }
}

class Parent
{
    int a=100;
    public void display()
    {
        System.out.println("Display in parent A: "+a);
    }
}

class Child extends Parent
{
    int b=200;

    public void display()
    {
        System.out.println("Display in parent B: "+b);
    }
}

