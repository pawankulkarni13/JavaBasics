package trees;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Stack;

public class BinaryTreeTraversalDemo {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.displayPreorder();

        System.out.println();

        System.out.println("Inorder traversal of binary tree is ");
        tree.displayInorder();

        System.out.println();

        System.out.println("Postorder traversal of binary tree is ");
        tree.displayPostorder();

        System.out.println();
        System.out.println("Inorder traversal of binary tree Using Stack is ");
        tree.displayInorderUsingStack();

        System.out.println();
        System.out.println("Print Postorder traversal from given Inorder and PreOrder Traversal");
        int in[] = { 4, 2, 5, 1, 3};
        int pre[] = { 1, 2, 4, 5, 3 };
        tree.constructPostOrderFromInOrderAndPreOrder(in, pre, in.length);
        System.out.println();

        System.out.println("Build Tree Using InOrder and PreOrder Traversals");
        tree.buildTree(in, pre);
        System.out.println();

        int post [] = {4,5,2,3,1};
        System.out.println("Build Tree Using InOrder and PostOrder Traversals");
        tree.buildTreeFromInAndPost(in, post);
        System.out.println();

        System.out.println("Build Full Binary Tree using PreOrder and PostOrder Traversals");
        tree.buidFullBinaryTreeFromPreAndPost(pre, post);
        System.out.println();

        System.out.println("Height of Tree");
        tree.maxDepth();
        System.out.println();

        System.out.println("Level Order Traversal to Demonstrate BFS");
        tree.levelOrderTraversal();
        System.out.println();

        System.out.println("Print Tree In Visual Order - ");
        tree.printTree();

    }
}

class BinaryTree {

    Node root;
    static private int preIndex = 0;

    BinaryTree() { root = null; }

    private void displayInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        displayInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        displayInorder(node.right);
    }
    private void displayPreorder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        displayPreorder(node.left);

        /* now recur on right subtree */
        displayPreorder(node.right);
    }
    private void displayPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        displayPostorder(node.left);

        // then recur on right subtree
        displayPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    public void displayPreorder() {
        displayPreorder(root);
    }

    public void displayInorder() {
        displayInorder(root);
    }

    public void displayPostorder() {
        displayPostorder(root);
    }

    public void displayInorderUsingStack() {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {
            while (curr !=  null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();

            System.out.print(curr.key + " ");

            curr = curr.right;
        }
    }

    public void constructPostOrderFromInOrderAndPreOrder(int[] in, int[] pre, int len) {
        //Search Index of Root in inorder to get left/right. Pre has root always at 0th index.
        int root = search(in, pre[0], len);

        if (root != 0)
            constructPostOrderFromInOrderAndPreOrder(in, Arrays.copyOfRange(pre, 1, len), root);

        if (root != len - 1)
            constructPostOrderFromInOrderAndPreOrder(Arrays.copyOfRange(in, root+1, len),
                    Arrays.copyOfRange(pre, 1+root, len), len - root - 1);

        System.out.print( pre[0] + " ");
    }

    private int search(int arr[], int x, int n)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }

    public void buildTree(int[] in, int[] pre) {
        Node root = buildTree(in, pre, 0, in.length-1);

        System.out.println("Displaying Inorder Traversal Post Building Tree !!");
        displayInorder(root);
        System.out.println();
        System.out.println("Displaying PreOrder Traversal Post Building Tree !!");
        displayPreorder(root);

    }

    private Node buildTree(int[] in, int[] pre, int inStrt, int inEnd) {
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.key);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    private int search(int[] in, int inStrt, int inEnd, int key) {
        int i;
        for (i = inStrt; i <= inEnd; i++) {
            if (in[i] == key)
                return i;
        }
        return i;
    }

    public void buildTreeFromInAndPost(int[] in, int[] post) {
        Node root = buildTreeFromInAndPost(in, post, 0, in.length-1, 0, post.length-1);
        System.out.println("Displaying Inorder Traversal Post Building Tree using In/Post !!");
        displayInorder(root);
        System.out.println();
        System.out.println("Displaying PreOrder Traversal Post Building Tree using In/Post !!");
        displayPreorder(root);
        System.out.println();
        System.out.println("Displaying PostOrder Traversal Post Building Tree using In/Post !!");
        displayPostorder(root);
    }

    private Node buildTreeFromInAndPost(int[] in, int[] post, int inStrt, int inEnd, int postStrt, int postEnd) {
        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Postrder traversal using
           postIndex and decrement postIndex */
        Node node = new Node(post[postEnd]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;
        int iIndex = search(in, inStrt, inEnd, node.key);

        /* Using index in Inorder traversal, construct left
           and right subtress */
        node.left = buildTreeFromInAndPost(in, post, inStrt, iIndex - 1, postStrt, postStrt - inStrt + iIndex - 1);
        node.right = buildTreeFromInAndPost(in, post, iIndex + 1, inEnd, postEnd - inEnd + iIndex, postEnd - 1);

        return node;
    }

    public void buidFullBinaryTreeFromPreAndPost(int[] pre, int[] post) {
        preIndex = 0;
        Node root = buildFullBinaryTree(pre, post, 0, pre.length-1, pre.length);
        System.out.println("Displaying Inorder Traversal Post Building Full Binary Tree using Pre/Post !!");
        displayInorder(root);
        System.out.println();
        System.out.println("Displaying PreOrder Traversal Post Building Full Binary Tree using Pre/Post !!");
        displayPreorder(root);
        System.out.println();
        System.out.println("Displaying PostOrder Traversal Post Building Full Binary Tree using Pre/Post !!");
        displayPostorder(root);
    }

    private Node buildFullBinaryTree(int[] pre, int[] post, int l, int h, int size) {
        // Base case
        if (preIndex >= size || l > h)
            return null;

        // The first node in preorder traversal is
        // root. So take the node at preIndex from
        // preorder and make it root, and increment
        // preIndex
        Node root = new Node(pre[preIndex]);
        preIndex++;

        // If the current subarray has only one
        // element, no need to recur or
        // preIndex > size after incrementing
        if (l == h || preIndex >= size)
            return root;
        int i;

        // Search the next element of pre[] in post[]
        for (i = l; i <= h; i++)
        {
            if (post[i] == pre[preIndex])
                break;
        }
        // Use the index of element found in
        // postorder to divide postorder array
        // in two parts. Left subtree and right subtree
        if (i <= h)
        {
            root.left = buildFullBinaryTree(pre, post, l, i, size);
            root.right = buildFullBinaryTree(pre, post, i + 1, h-1, size);
        }
        return root;
    }

    public void maxDepth() {
        System.out.println("Height of tree is : " + maxDepth(root));
    }

    private int maxDepth(Node root) {
        if (root == null)
            return -1;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            displayCurrentLevel(root, i);
    }

    private int height(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    private void displayCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1) {
            displayCurrentLevel(root.left, level - 1);
            displayCurrentLevel(root.right, level - 1);
        }
    }

    public void printTree() {
        try (PrintStream os = new PrintStream(System.out, true)) {
            os.print(traversePreOrder(root));

        }
    }
    private String traversePreOrder(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.key);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.left, root.right!= null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                               boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.key);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);

        }
    }
}