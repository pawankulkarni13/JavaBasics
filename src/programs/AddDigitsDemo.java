package programs;

import java.util.Arrays;

public class AddDigitsDemo {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(54321));
    }

    private static int addDigits(int num) {

        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }

}
