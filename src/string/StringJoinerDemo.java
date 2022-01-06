package string;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner joiner =  new  StringJoiner ( " . " , " Prefix- " , " -suffix " );
        for ( String s :  "Hello world how are you" . split ( "  " )) {
            joiner.add(s);
        }
        System.out.println(joiner); // Prefix- Hello world how are you -suffix
    }
}
