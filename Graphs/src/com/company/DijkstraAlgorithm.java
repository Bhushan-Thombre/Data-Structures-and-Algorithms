// Dijkstra's Algorithm
// Time Complexity = O(V * V)
// The time complexity can be optimized using min heap to extract minimum key
// Then the time complexity will be O(E * log V + V * log V)
// This algorithm does not work if the graph contains negative weight edges
// This algorithm will produce different output if we add a weight to each edge of the graph
package com.company;

import java.util.Arrays;

public class DijkstraAlgorithm {

    static final int V = 4;


    static int[] dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] fin = new boolean[V];

        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int j = 0; j < V; j++) {
                if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            fin[u] = true;
            for (int v = 0; v < V; v++) {
                if (!fin[v] && graph[u][v] != 0) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 50, 100, 0},
                { 50, 0, 30, 200 },
                { 100, 30, 0, 20 },
                { 0, 200, 20, 0 },};
        int[] ans = dijkstra(graph, 0);
        System.out.println(Arrays.toString(ans));
    }
}
