public class OperatorDemo {
    public static void main(String[] args) {
        int a=10;
        int b=-10;
        System.out.println(~a); //-11 (minus of total positive value which starts from 0)
        System.out.println(~b);


        //For positive number, >> and >>> works same
        System.out.println(20>>2);
        System.out.println(20>>>2);
        //For negative number, >>> changes parity bit (MSB) to 0
        System.out.println(-20>>2);
        System.out.println(-20>>>2);
    }
}
