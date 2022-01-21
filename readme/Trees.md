#### Full Binary Tree 

A Binary Tree is a full binary tree if every node has 0 or 2 children. The following are the examples of a full binary tree. We can also say a full binary tree is a binary tree in which all nodes except leaf nodes have two children. 

               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40

             18
           /    \   
         15     20    
        /  \       
      40    50   
    /   \
   30   50

#### Complete Binary Tree 

A Binary Tree is a Complete Binary Tree if all the levels are completely filled except possibly the last level and the last level has all keys as left as possible 

               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40
#### Perfect Binary Tree
 
A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children and all leaf nodes are at the same level. 

               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40
      
In a Perfect Binary Tree, the number of leaf nodes is the number of internal nodes plus 1   

L = I + 1 Where L = Number of leaf nodes, I = Number of internal nodes.

#### Balanced Binary Tree 

A binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes. For Example, the AVL tree maintains O(Log n) height by making sure that the difference between the heights of the left and right subtrees is at most 1. Red-Black trees maintain O(Log n) height by making sure that the number of Black nodes on every root to leaf paths is the same and there are no adjacent red nodes. Balanced Binary Search trees are performance-wise good as they provide O(log n) time for search, insert and delete. 

#### A degenerate (or pathological) tree

A Tree where every internal node has one child. Such trees are performance-wise same as linked list. 

      10
      /
    20
     \
     30
      \
      40

https://github.com/eugenp/tutorials/tree/master/data-structures/src/main/java/com/baeldung

#### Tree Traversals (Inorder, Preorder and Postorder)

        1
       / \
      2   3
     / \
    4   5
    
#### Depth First Traversals: 
1.  Inorder (Left, Root, Right) : 4 2 5 1 3 
2.  Preorder (Root, Left, Right) : 1 2 4 5 3 
3.  Postorder (Left, Right, Root) : 4 5 2 3 1

#### Breadth-First or Level Order Traversal: 1 2 3 4 5 

Algorithm Inorder(tree)
1. Traverse the left subtree, i.e., call Inorder(left-subtree)
2. Visit the root.
3. Traverse the right subtree, i.e., call Inorder(right-subtree)

Uses of Inorder 
In the case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used. 
Example: In order traversal for the above-given figure is 4 2 5 1 3.

Algorithm Preorder(tree)
1. Visit the root.
2. Traverse the left subtree, i.e., call Preorder(left-subtree)
3. Traverse the right subtree, i.e., call Preorder(right-subtree) 

Uses of Preorder 
Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on an expression tree. 
Example: Preorder traversal for the above-given figure is 1 2 4 5 3.

Algorithm Postorder(tree)
1. Traverse the left subtree, i.e., call Postorder(left-subtree)
2. Traverse the right subtree, i.e., call Postorder(right-subtree)
3. Visit the root.

Uses of Postorder 
Postorder traversal is used to delete the tree. 
Postorder traversal is also useful to get the postfix expression of an expression tree.
Example: Postorder traversal for the above-given figure is 4 5 2 3 1.

It is not possible to construct a general Binary Tree from preorder and postorder traversals.
But if the tree is mentioned as Full Binary Tree. we can construct the tree without ambiguity
A Full Binary Tree is a binary tree where every node has either 0 or 2 children

