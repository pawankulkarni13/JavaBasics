package trees;

import java.sql.SQLOutput;

public class BinarySearchTreeDemo {

    Node root;

    BinarySearchTreeDemo() { root = null; }

    BinarySearchTreeDemo(int value) { root = new Node(value); }

    void insertNode(int key) { root = insert(root, key); }

    private Node insert(Node root, int key) {
        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    public void insertWithoutRecursion(int key){
        Node node=new Node(key);
        if(root==null) {
            root = node;
            return;
        }
        Node prev=null;
        Node temp=root;
        while (temp!=null){
            if(temp.key>key){
                prev=temp;
                temp=temp.left;
            }
            else if (temp.key<key){
                prev=temp;
                temp=temp.right;
            }
        }
        if(prev.key>key)
            prev.left=node;
        else prev.right=node;
    }

    public void deleteNode(int key) { root = delete(root, key); }

    Node delete(Node root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void inorder() {
        System.out.print("InOrder --> ");
        inorder(root);
        System.out.println();
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void preOrder() {
        preOrder(root);
        System.out.println();
    }

    void preOrder(Node node)  {
        if (node == null)
            return;

        //first print root node first
        System.out.print(node.key + " ");
        // then traverse left subtree recursively
        preOrder(node.left);
        // next traverse right subtree recursively
        preOrder(node.right);
    }

    void postOrder() {
        postOrder(root);
        System.out.println();
    }
    void postOrder(Node node)  {
        if (node == null)
            return;

        // first traverse left subtree recursively
        postOrder(node.left);

        // then traverse right subtree recursively
        postOrder(node.right);

        // now process root node
        System.out.print(node.key + " ");
    }

    boolean search(int key)  {
        Node currNode = search(root, key);
        if (currNode!= null)
            return true;
        else
            return false;
    }

    //recursive insert function
    private Node search(Node root, int key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return search(root.left, key);
        // val is less than root's key
        return search(root.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTreeDemo tree = new BinarySearchTreeDemo();

        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(70);
        tree.insertNode(60);
        tree.insertNode(80);
        tree.insertNode(10);

        traverseTree(tree);

        System.out.println("\t\tDelete 20");
        tree.deleteNode(20);

        tree.inorder();

        System.out.println("\t\tDelete 30");
        tree.deleteNode(30);

        tree.inorder();

        System.out.println("\t\tDelete 50");
        tree.deleteNode(50);

        tree.insertNode(10);
        tree.inorder();

        traverseTree(tree);

        System.out.println("Searching for Node 10 - "+tree.search(10));
        System.out.println("Searching for Node 80 - "+tree.search(80));
        System.out.println("Searching for Node 50 - "+tree.search(50));
        System.out.println("Searching for Node 60 - "+tree.search(60));

        System.out.println("Maximum Value in BST - "+ tree.maxNode());
        System.out.println("Minimum Value in BST - "+ tree.minNode());
    }

    private int maxNode() {
        Node current = root;
        while (current.right != null)
            current = current.right;
        return current.key;
    }

    private int minNode() {
        Node current = root;
        while (current.left != null)
            current = current.left;
        return current.key;
    }

    private static void traverseTree(BinarySearchTreeDemo tree) {
        System.out.println("InOrder Traversal of Tree - ");
        tree.inorder();
        System.out.println("PreOrder Traversal of Tree - ");
        tree.preOrder();
        System.out.println("PostOrder Traversal of Tree - ");
        tree.postOrder();
    }

}
