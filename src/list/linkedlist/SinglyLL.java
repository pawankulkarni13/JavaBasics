package list.linkedlist;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SinglyLL {
    private Node head;

    public void printNodes(int a){
        printNodes(head, a);
    }
    private void printNodes(Node start,int a){

        if (start == null)

            return;

        System.out.print(start.data); //Print statement

        if(start.next != null )

            if(a==0){

                printNodes(start.next.next,1);

            }else{

                printNodes(start.next,0);

            }

        System.out.print(start.data);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addNodeInBeginning(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void addNodeAtEnd(int data) {
        Node current = head;
        while (current.next != null) {
            current = current.next; // we'll loop until current.next is null
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

    public void addNodeAtPosition(int position, int data){
        //create new node.
        Node node = new Node();
        node.data = data;
        node.next = null;


        if (this.head == null) {
            //if head is null and position is zero then exit.
            if (position != 0) {
                return;
            } else { //node set to the head.
                this.head = node;
            }
        }

        if (head != null && position == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }

        Node current = this.head;
        Node previous = null;

        int i = 0;

        while (i < position) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }

            i++;
        }

        node.next = current;
        previous.next = node;
    }

    public void empty(){
        head = null;
    }

    public Node deleteNthNode(int n){
        return deleteNode(head, n);
    }

    void deleteNodeAlternate(Node head, int position){
        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        // Find previous node of the node to be deleted inorder to swap with position+1 node.
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;
    }

    private Node deleteNode(Node head, int n){
        if (head.next == null){
            return deleteNodeInBeginning(); //Assuming only one node exists !!
        }

        Node curr = head;
        int len = 0;
        while(curr!=null){
            len++;
            curr = curr.next;
        }

        //We have length
        curr = head;
        Node prev = null;
        for (int i = 0; i < len - n; i++) {
            prev = curr;
            curr = curr.next;
        }

        if (prev != null) {
            prev.next = curr.next;
        } else {
            return head.next;
        }
        return head;
    }

    public Node deleteNodeInBeginning() {
        Node temp = head;
        head = head.next;
        return temp;
    }

    public Node deleteNodeAtEnd() {
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return current;
    }

    public Node reverse(){
        return reverse(head);
    }

    private Node reverse(Node node) {
        Stack<Node> reverse = new Stack<>();
        Node current = node;

        while (current.next != null) {
            reverse.add(current);
            current = current.next;
        }

        head = current;
        while(!reverse.isEmpty()){
            current.next = reverse.peek();
            reverse.pop();
            current = current.next;
        }
        current.next = null;

        display();

        return node;
    }

    public Node merge(SinglyLL singlyLL){
        return merge(singlyLL.head);
    }

    private Node merge(Node newNodes){
        Node originalHead = this.head;
        Node newHead = newNodes;

        Node currentNode = this.head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newHead;

        this.head = originalHead;
        return this.head;
    }

    public void display(){
        System.out.print("LinkedList Elements --> ");
        Node current = head;
        while (current != null) {
            current.displayNodes();
            current = current.next;
        }
        System.out.println(" null");
    }

    public <T> T getMiddle() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length ++;
            current = current.next;
        }
        int mid = length/2;
        current = head;
        int i = 0;
        while (current != null) {
            if(i==mid) {
                return (T) current.data;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    private Node swapNodes(Node head) {
        if(head ==null || head.next==null)
            return head;

        Node secondNode = head.next;
        Node thirdNode = secondNode.next;

        secondNode.next = head;
        head.next = swapNodes(thirdNode);

        return secondNode;
    }
    public void swapNodes() {
        Node node = swapNodes(this.head);
        this.head = node;
        display();
    }

    public void swapNodes(int k) {
        Node fast = this.head;
        Node slow = this.head;
        Node first = head, second = head;

        // Put fast (k-1) nodes after slow
        for(int i = 0; i < k - 1; ++i)
            fast = fast.next;

        // Save the node for swapping
        first = fast;

        // Move until the end of the list
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Save the second node for swapping
        // Note that the pointer second isn't necessary: we could use slow for swapping as well
        // However, having second improves readability
        second = slow;

        // Swap values
        Object temp = first.data;
        first.data = second.data;
        second.data = temp;

        System.out.println("Swapping Nodes - k = "+k);
        display();
    }
}
class Node<T> {
    public T data;
    public Node<T> next;

    public void displayNodes() {
        System.out.print("{ " + data + " } --");
    }
}
