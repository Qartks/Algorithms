package com.algorithms.qartks;

/**
 * Created by qartks on 2/19/17.
 */
public class SearchWordMatrix {

    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        char grid[][] = {{'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                         {'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                         {'G','E','E','K','S','F','O','R','G','E','E','K','S'}};
        patternSearch(grid, "EEE");
    }

    private static void patternSearch(char[][] grid, String word) {

        int R = grid.length;
        int C = grid[0].length;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (search2D(grid, row, col, word)) {
                    System.out.println("Word found at " + (row) + " , " + (col));
                }
            }
        }
    }

    private static boolean search2D(char[][] grid, int row, int col, String word) {
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }

        int R = grid.length;
        int C = grid[0].length;

        for (int d = 0; d < 8; d++) {
            int rw = row + x[d];
            int cl = col + y[d];
            int i;

            for (i = 1; i < word.length(); i++) {
                if (rw >=R || cl >= C || rw < 0 || cl < 0) break;
                if (grid[rw][cl] != word.charAt(i)) break;

                rw += x[d];
                cl += y[d];
            }
            if (i == word.length()) return true;
        }
        return false;
    }
}
