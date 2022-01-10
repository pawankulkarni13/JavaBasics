package trees;

/**
 * Simple Example of Tree Struture
 */
public class BinaryTreeDemo {

    Node root;

    public BinaryTreeDemo(int key) {
        this.root = new Node(key);
    }

    public BinaryTreeDemo() {
        this.root = null;
    }

    public static void main(String[] args) {

        BinaryTreeDemo binaryTree = new BinaryTreeDemo();
        binaryTree.root = new Node(1);

        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);

        binaryTree.root.left.left = new Node(4);

    }
}
class Node{
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
