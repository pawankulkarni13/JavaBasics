package streams;

import java.util.Random;
import java.util.stream.Stream;

public class RandomIntegerDemo {
    public static void main(String[] args) {
        random();
        randomAscendingOrder();
        maxMinIntInSet();
    }

    private static void maxMinIntInSet() {
        System.out.println("Maximum");
        System.out.println(Stream.of ( 5 , 3 , 4 , 55 , 2 )
                .mapToInt (a -> a)
                .max ()
                .getAsInt ()); // 55

        System.out.println("Minimum");
        System.out.println(Stream.of ( 5 , 3 , 4 , 55 , 2 )
                .mapToInt (a -> a)
                .min ()
                .getAsInt ()); // 2
    }

    private static void random() {
        ( new Random())
                .ints ()
                .limit ( 10 )
                .forEach ( System . out :: println);
    }

    private static void randomAscendingOrder() {
        System.out.println("Random Ascending Order");
        ( new  Random ())
                .ints ()
                .limit ( 10 )
                .sorted ()
                .forEach ( System . out :: println);
    }
}
