package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    static void printAdjacencyList(ArrayList<ArrayList<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + "->>");
            }
            System.out.println("END");
        }
    }

    // Breadth First Search of disconnected graph that also return the number of connected components
    // Time Complexity = O(V + E)
    static void BFS(ArrayList<ArrayList<Integer>> adjList, int s, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    // Breadth First Search of disconnected graph that also return the number of connected components
    // Time Complexity = O(V + E)
    static int BFSDis(ArrayList<ArrayList<Integer>> adjList, int V) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                BFS(adjList, i, visited);
                count++;
            }
        }
        System.out.println();
        return count;
    }

    // Depth First Search of disconnected graph that also return the number of connected components
    // Time Complexity = O(V + E)
    static void DFS(ArrayList<ArrayList<Integer>> adjList, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : adjList.get(s)) {
            if (!visited[u]) {
                DFS(adjList, u, visited);
            }
        }
    }

    // Depth First Search of disconnected graph that also return the number of connected components
    // Time Complexity = O(V + E)
    static int DFSDis(ArrayList<ArrayList<Integer>> adjList, int V) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < V; i++) {
            DFS(adjList, i, visited);
            count++;
        }
        return count;
    }

    // Cycle detection in Undirected Graph
    // Time complexity = O(V + E)
    static boolean cycleDetectUndirected(ArrayList<ArrayList<Integer>> adjList, int s, boolean[] visited, int parent) {
        visited[s] = true;
        for (int u : adjList.get(s)) {
            if (!visited[u]) {
                if (cycleDetectUndirected(adjList, u, visited, s)) {
                    return true;
                }
            }else if (u != parent) {
                return true;
            }
        }
        return false;
    }

    // Cycle detection in Undirected Graph
    // Time complexity = O(V + E)
    static boolean cycleDetectUndirectedWrapper(ArrayList<ArrayList<Integer>> adjList, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (cycleDetectUndirected(adjList, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Cycle detection in Directed Graph
    // Time complexity = O(V + E)
    static boolean cycleDetectDirectedDFS(ArrayList<ArrayList<Integer>> adjList, int s, boolean[] visited, boolean[] recStack) {
        visited[s] = true;
        recStack[s] = true;
        for (int u: adjList.get(s)) {
            if (!visited[u] && cycleDetectDirectedDFS(adjList, u, visited, recStack)) {
                return true;
            }else if (recStack[u]) {
                return true;
            }
        }
        recStack[s] = false;
        return false;
    }

    // Cycle detection in Directed Graph
    // Time complexity = O(V + E)
    static boolean cycleDetectDirectedDFSWrapper(ArrayList<ArrayList<Integer>> adjList, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            recStack[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (cycleDetectDirectedDFS(adjList, i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        addEdge(adjList,0,1);
        addEdge(adjList,2,1);
        addEdge(adjList,2,3);
        addEdge(adjList,3,4);
        addEdge(adjList,4,5);
        addEdge(adjList,5,3);
        System.out.println("Adjacency List Representation of Graph is: ");
        printAdjacencyList(adjList);

        System.out.println("Breadth First Search: ");
        BFSDis(adjList, V);
        // Number of Connected  Components
        // System.out.println(BFSDis(adjList, V))

        System.out.println("Depth First Search: ");
        DFSDis(adjList, V);
        System.out.println();
        // Number of Connected  Components
        // System.out.println(DFSDis(adjList, V))

        System.out.println("Cycle Detection in undirected graph: ");
        if(cycleDetectUndirectedWrapper(adjList,V))
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");

        System.out.println("Cycle Detection in directed graph: ");
        if (cycleDetectDirectedDFSWrapper(adjList, V)){
            System.out.println("Cycle found");
        }else {
            System.out.println("No cycle found");
        }
    }
}