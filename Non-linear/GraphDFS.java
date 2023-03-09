package DS.GRAPHS;

import Fundamentals.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class GraphDFS {

    int V; // number of vertices
    ArrayList<Integer>[] adj; // adjacency list

    GraphDFS(int numberOfVertex) {
        V = numberOfVertex;
        adj = new ArrayList[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void edge(int x, int y) {
        adj[x].add(y);
    }

    void DFS(int source) {

        boolean[] visited = new boolean[V];
        Stack<Integer> s1 = new Stack<>();

        s1.push(source); //push first vertex
        int node;

        while(!s1.empty()) { // while still elements
            source = s1.peek(); // get the top most element
            s1.pop(); // pop the top most element

            for (int i = 0; i < adj[source].size(); i++) { // 
                node = adj[source].get(i);
                if (!visited[node]) {
                    s1.push(node);
                }
            }

            if (visited[source] == false) {
                System.out.print(source + " ");
                visited[source] = true;
            }
        }
    }


    public static void main(String[] args) {
        GraphDFS g1 = new GraphDFS(6);

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

        System.out.println("Depth First Search");
        g1.DFS(0);
    }
}
