package design;

import java.util.Arrays;

public class DesignCustomStackWithIncrementOperationDemo {

    public static void main(String[] args) throws Exception {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        System.out.println("Poping Out "+customStack.pop());   // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        System.out.println(customStack.toString());

        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        System.out.println(customStack.toString());

        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        System.out.println(customStack.toString());

        System.out.println("Poping Out "+customStack.pop());                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println("Poping Out "+customStack.pop());                            // return 202 --> Return top of the stack 102, stack becomes [201]
        System.out.println("Poping Out "+customStack.pop());                            // return 201 --> Return top of the stack 101, stack becomes []
        System.out.println("Poping Out "+customStack.pop());                            // return -1 --> Stack is empty return -1.
    }

}

class CustomStack {

    private int[] arr;
    private int top;
    private final int capacity;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        capacity = maxSize;
        top = -1;
    }

    public void push(int x) throws Exception {

        System.out.println("Pushing In "+ x);
        if(ifFull()){
            return;
//            throw new Exception("OverFlow");
        }
        ++top;
        arr[top]=x;
    }

    public int pop() throws Exception {
        if(isEmpty()){
            return -1;
//            throw new Exception("Empty Stack");
        }
        return arr[top--];
    }

    private boolean isEmpty() {
        return top ==-1;
    }

    private boolean ifFull() {
        return capacity == top+1;
    }

    public void increment(int k, int val) {
        k = Math.min(k, capacity);
        for(int i=0;i<k;i++){
            arr[i] = arr[i] + val;
        }
    }
    public String toString() {
        return "CustomStack{" +
                "arr=" + Arrays.toString(arr) +
                ", top=" + top +
                ", capacity=" + capacity +
                "} " + super.toString();
    }
}
