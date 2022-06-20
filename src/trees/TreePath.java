// Sample code

// TreeNode root = new TreeNode(5);
// root.left = new TreeNode(4);
// root.right = new TreeNode(8);
// root.left.left = new TreeNode(11);
// root.right.left = new TreeNode(13);
// root.right.right = new TreeNode(4);
// root.left.left.left = new TreeNode(7);
// root.left.left.right = new TreeNode(2);
// root.right.right.right = new TreeNode(1);


//         5
//       / \
//       4.  8
//      /.  / \
//     11  13  4
//     /\       \
//   7. 2       1
    
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22

import java.util.*;

class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode() {}
TreeNode(int val) { this.val = val; }
TreeNode(int val, TreeNode left, TreeNode right) {
this.val = val;
this.left = left;
this.right = right;
}
}
public class TreePath {
    
    public static void main(String[] args){
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(5);
        
        path(root, 22);
        
    }
    public static void path(TreeNode root, int sum){
        ArrayList<Integer> paths = new ArrayList<>();
        pathToSum(root, sum, 0, paths);
    }
    public static void pathToSum(TreeNode node, int sum, int calculatedSum, ArrayList<Integer> paths){
    
        if(node == null)
            return;
    
        calculatedSum += node.val;
        paths.add(node.val);
        if(calculatedSum == sum && node.right == null && node.left == null){
                System.out.println("Path --> " );
                for(int i=0;i<paths.size();i++)
                    System.out.print(paths.get(i) +" - ");
                
                // paths.remove() ?
        }
        if(node.left !=null)
            pathToSum(node.left, sum, calculatedSum, paths);
            
        if(node.right!=null)
            pathToSum(node.right, sum, calculatedSum, paths);
            
        
        
        paths.remove(paths.size()-1);
    
    }
}

// 1 -> 5 CS 5
// 2 -> 4 CS 9.     8 CS 13
// 3-> 11 CS 20    13 CS
// 4 -> 2 CS 22

// Sum = 22
//         5
//       / \
//       4.  8
//      /.  / \
//     11  13  4
//     /\       \
//   7. 2       5


