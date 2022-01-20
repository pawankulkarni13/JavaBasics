package programs;

public class NumberIsOddEvenWithoutModulus {

    public static void main(String[] args) {

        //Checking if the number is even or odd without using the % operator:

        int num = 101;
        System.out.println((num & 1) == 0 ?  "EVEN" : "ODD" );

        num = 100;
        System.out.println((num & 1) == 0 ?  "EVEN" : "ODD" );

    }
}
