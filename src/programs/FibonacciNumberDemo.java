package programs;

public class FibonacciNumberDemo {
    public static void main(String[] args) {
        int n = 7;
        int result = fibonacci(n);
        System.out.println("fibonacci = " + result);

        System.out.println("Print Fibonacci");
        int n1=0,n2=1,n3,i,count=10;
        System.out.print(n1+" "+n2);
        //loop starts from 2 because 0 and 1 are already printed
        for(i=2;i<count;++i){
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
