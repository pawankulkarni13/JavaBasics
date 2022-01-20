package datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack(String.class,10);

        Scanner s = new Scanner(System.in);

        String [] str = new String[5];

//        String revStr = Stream.of(s)
//                .map(word->new StringBuilder(word).reverse())
//                .collect(Collectors.joining(" "));


        myStack.push("Pawan");
        myStack.push("Pawan2");
        myStack.push("Pawan3");
        myStack.push("Pawan4");
        myStack.push("Pawan5");

        System.out.println(myStack);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}

class MyStack<T> {

    private T t[];
    private int top;
    private int capacity;

    public MyStack(T cls,int size){
        this.t = (T[]) Array.newInstance((Class<?>) cls,size);
        capacity = size;
        top = -1;
    }

    public void push(T value) throws Exception {
        if(ifFull()){
            throw new Exception("OverFlow");
        }
        t[++top]=value;
    }

    public T pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty Stack");
        }
        return t[top--];
    }

    private boolean isEmpty() {
        return top ==-1;
    }

    private boolean ifFull() {
        return capacity == top;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "t=" + Arrays.toString(t) +
                ", top=" + top +
                ", capacity=" + capacity +
                "} " + super.toString();
    }
}
