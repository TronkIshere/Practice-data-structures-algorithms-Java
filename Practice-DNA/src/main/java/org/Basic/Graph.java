package org.Basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private LinkedList<Integer>[] adj;
    private int V; //number of vertices in Graph
    private int E; //number of edges in Graph

    public Graph(int nodes){
        this.V= nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int v = 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    //BFS – Breadth-First Search
    public void bfs(int s){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    //DFS - Depth First Search
    public void dfs(int s){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()){
            int u = stack.peek();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u + " ");
                for(int v : adj[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }

    //Recursive Depth First Search
    public void recursiveDfs() {
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; v++){
            if(!visited[v]){
                dfs(v, visited);
            }
        }
    }

    public void dfs(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");
        for(int W : adj[v]){
            if(!visited[W]){
                dfs(W, visited);
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++){
            sb.append(v + ": ");
            for(int w : adj[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);

        System.out.println("Recursive Depth First Search: ");
        g.recursiveDfs();
        System.out.println();

        System.out.println("BFS – Breadth-First Search: ");
        g.bfs(0);
        System.out.println();

        System.out.println("DFS - Depth First Search: ");
        g.dfs(0);
        System.out.println();



    }
}
