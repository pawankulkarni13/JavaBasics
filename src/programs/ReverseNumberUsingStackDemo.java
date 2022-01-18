package programs;

import java.util.Stack;

public class ReverseNumberUsingStackDemo {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        System.out.println(reverseNumber(5864));

    }

    private static int reverseNumber(int i) {

        addAllDigitsToStack(i);
        int reversedNumber = 0;
        int j = 1;

        while(!stack.isEmpty()){
            reversedNumber = reversedNumber + (stack.peek() * j);
            stack.pop();
            j = j * 10;
        }

        return reversedNumber;
    }

    private static void addAllDigitsToStack(int i) {
        while(i != 0) {
            stack.push(i % 10);
            i = i / 10;
        }
    }
}
