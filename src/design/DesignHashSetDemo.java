package design;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 *
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 */
public class DesignHashSetDemo {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.add(5);      // set = [1, 2]
        myHashSet.add(4);      // set = [1, 2]
        myHashSet.display();

        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]

        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyHashSet {

    private Node[] set;

    public MyHashSet() {
        set = new Node[101]; // Assuming this will suffice at start.
    }

    public void add(int key) {
        // key less than 10 to power of 6

        if(key >= 0 && key <= 1000000 && !this.contains(key)) {
            int index = this.hashFunction(key);
            if(this.set[index] == null) {
                // add first node in that index
                this.set[index] = new Node(key);
            }
            else {
                // collision
                Node head = this.set[index];
                while(head.next != null) {
                    head = head.next;
                }
                head.next = new Node(key);
                // add node at the end of list
            }
        }
    }

    public void remove(int key) {
        if(this.contains(key)) {
            int index = hashFunction(key);
            Node head = this.set[index];
            Node list;
            if(head.data == key) {
                list = removeFirst(head);
            }
            else {
                list = removeFromMiddle(head, key);
            }
            this.set[index] = list; // updating the index with new list
        }
        //trying out a binary search related algo to delete
    }

    public boolean contains(int key) {
        int index = this.hashFunction(key);
        Node head = this.set[index];
        while(head != null) {
            if(head.data == key) return true;
            head = head.next;
        }
        return false; // key not found

    }

    private Node removeFromMiddle(Node head, int key) {
        Node list = head;
        //Loop thru nodes
        while(head.next != null) {
            if(head.next.data == key) {
                head.next = head.next.next;
                break;
                // remove first element and break out of loop
            }
            head = head.next;
        }
        return list;
    }

    private Node removeFirst(Node head) {
        return head.next;
    }

    private int hashFunction(int key) {
        Integer obj = key;
        int h;
        return (h=obj.hashCode()) ^ (h >>> 16);
    }

    public void display(){
        System.out.println("Data - ");
        for (Node node : set){
            if(node!=null)
                System.out.print(node.data+" - ");
        }
        System.out.println();
    }
}