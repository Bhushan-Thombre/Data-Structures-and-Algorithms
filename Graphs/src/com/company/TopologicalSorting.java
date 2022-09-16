// Kahn's Algorithm
// Topological sorting algorithm is only valid for acyclic graphs
package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {

    static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
    }

    // BFS based topological sorting
    // Time complexity = O(V + E)
    static void topologicalSortBFS(ArrayList<ArrayList<Integer>> adjList, int V) {
        int[] in_degree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adjList.get(i)) {
                in_degree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int x : adjList.get(u)) {
                if (--in_degree[x] == 0) {
                    queue.add(x);
                }
            }
        }
    }

    // DFS based topological sorting algorithm
    // Time Complexity = O(V + E)
    static void topologicalSortDFS(ArrayList<ArrayList<Integer>> adjList, int s, Stack<Integer> stack, boolean[] visited) {
        visited[s] = true;
        for (int i : adjList.get(s)) {
            if (!visited[i]) {
                topologicalSortDFS(adjList, i, stack, visited);
            }
        }
        stack.push(s);
    }

    // DFS based topological sorting algorithm
    // Time Complexity = O(V + E)
    static void topologicalSortDFSWrapper(ArrayList<ArrayList<Integer>> adjList, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortDFS(adjList, i, stack, visited);
            }
        }
        while(!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + " ");
        }
    }

    // Cycle detection for directed graph using Kahn's algorithm
    // Time complexity = O(V + E)
    static boolean cycleDetectDirected(ArrayList<ArrayList<Integer>> adjList, int V) {
        int[] in_degree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adjList.get(i)) {
                in_degree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int x : adjList.get(u)) {
                if (--in_degree[x] == 0) {
                    queue.add(x);
                }
            }
            count++;
        }
        if (count != V) {
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        addEdge(adjList,0, 1);
        addEdge(adjList,1, 3);
        addEdge(adjList,2, 3);
        addEdge(adjList,3, 4);
        addEdge(adjList,2, 4);

        System.out.println("BFS based Topological Sorting: ");
        topologicalSortBFS(adjList, V);
        System.out.println();

        System.out.println("DFS based Topological Sorting: ");
        topologicalSortDFSWrapper(adjList, V);
        System.out.println();

        System.out.println("Cycle Detection: ");
        if (cycleDetectDirected(adjList, V)) {
            System.out.println("Cycle Found");
        }else{
            System.out.println("Cycle not found");
        }
    }
}
