package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class CountTreesDemo {
    private int V;
    private LinkedList<Integer> adj[];

    CountTreesDemo(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i <  v; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String args[]) {
        CountTreesDemo g = new CountTreesDemo(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println(g.countTrees());
    }

    private int countTrees() {
        boolean visited[] = new boolean[V];
        int res = 0;
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                DFSUtil(i, visited);
                res ++;
            }
        }
        return res;
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n,visited);
            }
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
