package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquaresOfNumberDemo {
    public static void main(String[] args) {
        Stream.of ( 1 , 2 , 3 , 2 , 1 )
                .map (s -> s * s)
                .distinct ()
                .collect ( Collectors. toList ())
                .forEach ( System . out :: println);
    }
}
