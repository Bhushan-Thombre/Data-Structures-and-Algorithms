// Simple implementation of Prim's Algorithm using Adjacency Matrix
// Time Complexity = O(V * V)
// The time complexity can be optimized using min heap to extract minimum key and using adjacency list representation
// Then the time complexity will be O(E * log V)
package com.company;

import java.util.Arrays;

public class PrimAlgorithm {
    static final int V = 4;
    public static int primMST(int[][] graph) {
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        boolean[] mSet = new boolean[V];
        int res = 0;

        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int j = 0; j < V; j++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }
            mSet[u] = true;
            res += key[u];
            for (int v = 0; v < V; v++) {
                if (!mSet[v] && graph[u][v] != 0) {
                    key[v] = Math.min(key[v], graph[u][v]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 5, 8, 0},
                { 5, 0, 10, 15 },
                { 8, 10, 0, 20 },
                { 0, 15, 20, 0 },};

        System.out.print(primMST(graph));
    }
}
