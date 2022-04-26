## Graph
A Graph is a non-linear data structure consisting of nodes and edges. 
The nodes are sometimes also referred to as vertices and the edges are lines or arcs that connect any two nodes in the graph. 

    A Graph consists of a finite set of vertices(or nodes) and set of Edges which connect a pair of nodes.

Unlike trees, graphs may contain cycles, so we may come to the same node again.
### Breadth-First Search 

Time Complexity: O(V+E) where V is a number of vertices in the graph and E is a number of edges in the graph.

Usages:
Peer to Peer Networks.
Shortest Path and Minimum Spanning Tree for unweighted graph 
Crawlers in Search Engines
GPS Navigation systems
Broadcasting in Network
Social Networking Websites
In Garbage Collection
Cycle detection in undirected graph
Finding all nodes within one connected component
Path Finding


### Depth First Search

Depth-first search is an algorithm for traversing or searching tree or graph data structures. 
The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) 
and explores as far as possible along each branch before backtracking. 
So the basic idea is to start from the root or any arbitrary node and mark the node and move to the adjacent unmarked node 
and continue this loop until there is no unmarked adjacent node. 
Then backtrack and check for other unmarked nodes and traverse them.

Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
Space Complexity: O(V), since an extra visited array of size V is required.

Usages :
Detecting cycle in a graph 
Path Finding 
Finding Strongly Connected Components of a graph
Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs.


### What is a Mother Vertex? 
A mother vertex in a graph G = (V, E) is a vertex v such that all other vertices in G can be reached by a path from v.

Time Complexity : O(V + E)

