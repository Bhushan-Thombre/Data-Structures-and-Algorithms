package com.company;

public class Main {

    static boolean isSafe(int[][] grid, int row, int col, int n) {
        for (int a = 0; a < grid.length; a++) {
            if (grid[a][col] == n) {
                return false;
            }
        }
        for (int b = 0; b < grid.length; b++) {
            if (grid[row][b] == n) {
                return false;
            }
        }
        int sqrt = (int)Math.sqrt(grid.length);
        int subGridRowStart = row - row % sqrt;
        int subGridColStart = col - col % sqrt;
        for (int i = subGridRowStart; i < subGridRowStart + sqrt; i++) {
            for (int j = subGridColStart; j < subGridColStart + sqrt; j++) {
                if (grid[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean solveSudoku(int[][] grid, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }
        for (int num = 1; num <= n; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                if (solveSudoku(grid, n)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    static void printSudoku(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] grid = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int n = grid.length;
        if (solveSudoku(grid, n)) {
            printSudoku(grid, n);
        }else {
            System.out.println("No solution exist!");
        }
    }
}
