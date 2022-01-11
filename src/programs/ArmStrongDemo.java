package programs;

import java.util.Arrays;

public class ArmStrongDemo {

    public static boolean isArmStrong(int number){
        int n = order(number);
        int temp=number, sum=0;
        while (temp!=0)
        {
            int r = temp%10;
            sum = sum + power(r,n);
            temp = temp/10;
        }

        // If satisfies Armstrong condition
        return (sum == number);
    }

    static int order(int x) {
        int n = 0;
        while (x != 0)
        {
            n++;
            x = x/10;
        }
        return n;
    }

    static int power(int x, long y) {
        if( y == 0)
            return 1;
        if (y%2 == 0)
            return power(x, y/2)*power(x, y/2);
        return x*power(x, y/2)*power(x, y/2);
    }

    public static void main(String[] args) {
        System.out.println("153 "+isArmStrong(153));
        System.out.println("123 "+isArmStrong(123));
    }

}
