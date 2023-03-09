package DS.GRAPHS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    int V; // number of vertices

    //dynamic array, space allocation is handled automatically
    ArrayList<Integer> adj[]; //adjacency  list

    GraphBFS(int numberOfVertex) {
        V = numberOfVertex;
        adj = new ArrayList[numberOfVertex]; // new keyword is used for allocating space
        for(int i = 0; i < numberOfVertex; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void edge(int x, int y) {
        adj[x].add(y);
    }

    void BFS(int sourceVertex) {

        boolean[] visited = new boolean[V]; // boolean array stating if the vertice has been visited
        Queue<Integer> vertices = new LinkedList<Integer>();

        visited[sourceVertex] = true; // first vertex visited
        vertices.add(sourceVertex); // add the first vertex to the queue

        while(!vertices.isEmpty()) { // while there's still elements
            sourceVertex = vertices.remove();
            System.out.print(sourceVertex + " ");
            Iterator i = adj[sourceVertex].iterator();
            while(i.hasNext()) {
                int n = (int) i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    vertices.add(n);
                }
            }
        }

    }

    public static void main(String[] args) {

        GraphBFS g1 = new GraphBFS(6);

        g1.edge(0,1);
        g1.edge(0,2);
        g1.edge(0,5);
        g1.edge(1,0);
        g1.edge(1,2);
        g1.edge(2,0);
        g1.edge(2,1);
        g1.edge(2,3);
        g1.edge(2,4);
        g1.edge(3,2);
        g1.edge(4,2);
        g1.edge(4,5);
        g1.edge(5,0);
        g1.edge(5,4);

        System.out.println("Breath First Search");
        g1.BFS(0);
    }
}
