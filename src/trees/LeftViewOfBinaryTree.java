package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        // constructor
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;

    static void inorder(Node temp) {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.data + " - ");
        inorder(temp.right);
    }

    private static void printLeftView(Node temp) {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.data + " - ");
    }

    static void insert(Node temp, int data) {

        if (temp == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        root = new Node(12);
        root.left = new Node(13);
        root.left.left = new Node(8);
        root.right = new Node(10);
        root.right.left = new Node(20);
        root.right.right = new Node(9);

        System.out.println("Inorder traversal before insertion: ");
        inorder(root);
        System.out.println();
        int data = 14;
        insert(root, data);
        insert(root, 22);

        System.out.println("Inorder traversal after insertion: ");
        inorder(root);
        System.out.println();

        System.out.println("Root of Tree - " + root.data);

        System.out.println("Left Side of Tree - ");
        printLeftView(root);
    }
}
