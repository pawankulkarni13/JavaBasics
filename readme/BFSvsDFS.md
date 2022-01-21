### BFS 
BFS stands for Breadth First Search is a vertex based technique for finding a shortest path in graph. It uses a Queue data structure which follows first in first out. In BFS, one vertex is selected at a time when it is visited and marked then its adjacent are visited and stored in the queue. It is slower than DFS. 

Input:

        A
       / \
      B   C
     /   / \
    D   E   F
    
Output: A, B, C, D, E, F


### DFS
DFS stands for Depth First Search is a edge based technique. It uses the Stack data structure, performs two stages, first visited vertices are pushed into stack and second if there is no vertices then visited vertices are popped. 

Input:

        A
       / \
      B   C
     /   / \
    D   E   F
    
Output: A, B, D, C, E, F

#### Difference between DFS BFS

| S No      | BFS | DFS |
| ----------- | ----------- | -----------|
|1. |BFS stands for Breadth First Search.	|DFS stands for Depth First Search.|
|2.	|BFS(Breadth First Search) uses Queue data structure for finding the shortest path.	|DFS(Depth First Search) uses Stack data structure.
|3.	|BFS can be used to find single source shortest path in an unweighted graph, because in BFS, we reach a vertex with minimum number of edges from a source vertex.	|In DFS, we might traverse through more edges to reach a destination vertex from a source.
|4.	|BFS is more suitable for searching vertices which are closer to the given source.	|DFS is more suitable when there are solutions away from source.
|5.	|BFS considers all neighbors first and therefore not suitable for decision making trees used in games or puzzles.	|DFS is more suitable for game or puzzle problems. We make a decision, then explore all paths through this decision. And if this decision leads to win situation, we stop.
|6.	|The Time complexity of BFS is O(V + E) when Adjacency List is used and O(V^2) when Adjacency Matrix is used, where V stands for vertices and E stands for edges.	|The Time complexity of DFS is also O(V + E) when Adjacency List is used and O(V^2) when Adjacency Matrix is used, where V stands for vertices and E stands for edges.
|7.	|Here, siblings are visited before the children.|	Here, children are visited before the siblings|


