package datastructures;

import java.util.LinkedList;

public class StackDemoUsingLinkedList {
    public static void main(String[] args) throws Exception {
        MyDemoStack myStack = new MyDemoStack(String.class);


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

class MyDemoStack<T> {

    private LinkedList<T> linkedListStack;

    public MyDemoStack(T cls){
        linkedListStack = new LinkedList<T>();
    }

    public void push(T value) throws Exception {
        linkedListStack.addFirst(value);
    }

    public T pop() throws Exception {
        return linkedListStack.removeFirst();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "linkedListStack=" + linkedListStack +
                '}';
    }
}
