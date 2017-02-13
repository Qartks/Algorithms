package com.algorithms.qartks;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by qartks on 1/10/17.
 */
public class BackTracking {

    static int N = 8;

    static void NQueenProblem() {
        int board[][] = new int [N][N];

        if (!solveNQueen(board, 0)) {
            System.out.println("No solutions for N Queen problem");
            return;
        } else {
            printKTSolution(board);
        }
    }

    private static boolean solveNQueen(int[][] board, int col) {
        if (col >=N) {
            return true;
        }

        // Rows
        for (int i = 0; i < N; i++) {
            if (isQueenSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueen(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isQueenSafe(int[][] board, int row, int col) {
        int i, j;

        if (board[row][col] == 1 || row < 0 || row >= N || col < 0 || col >= N) {
            return false;
        }

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<N; i++, j--)
            if (board[i][j] == 1)
                return false;


        return true;
    }

    static void knightTour()
    {
        int sol[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(sol[i], -1);
        }

        int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;

        if (!solveKT(sol, moveX, moveY, 0, 0, 1)) {
            System.out.println("Solution does not exist");
        } else {
            printKTSolution(sol);
        }
        Math.min(0 , 1);

    }

    private static boolean isSafe(int x, int y, int[][] sol)
    {
        return (x>=0 && x <N && y >=0 && y < N && sol[x][y] == -1);
    }

    private static boolean solveKT(int[][] sol, int[] moveX, int[] moveY, int x, int y, int step)
    {

        int next_X, next_Y;

        if (x<0 && x >=N && y <0 && y >= N) {
            return false;
        }

        if (step == N*N) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            next_X = x + moveX[i];
            next_Y = y + moveY[i];

            if (isSafe(next_X, next_Y, sol)) {
                sol[next_X][next_Y] = step;
                if (solveKT(sol, moveX, moveY, next_X, next_Y, step + 1)) {
                    return true;
                } else {
                    sol[next_X][next_Y] = -1;
                }
            }
        }

        return false;
    }

    private static void printKTSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(sol[i]));
        }
    }

    static void permute(char[] s, int l, int r)
    {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i <= r; i++) {
                swap(s, l, i);
                permute(s, l+1, r);
                swap(s, l, i);
            }
        }
    }

    static private void swap(char[] s, int l, int i) {
        char temp = s[l];
        s[l] = s[i];
        s[i] = temp;
    }

    static private boolean mColor(int[][] graph, int m)
    {
        int[] color = new int [4];

        if (mColorUtil(graph, m, color, 0)) {
            System.out.println(Arrays.toString(color));
            return true;
        }
        System.out.println("No Solutions Found!");
        return false;
    }

    private static boolean mColorUtil(int[][] graph, int m, int[] color,  int v) {

        if (v == 4) {
            return true;
        }

        for (int c = 1; c<= m; c++) {
            if (mColorIsSafe(graph, color, c, v)) {
                color[v] = c;
                if (mColorUtil(graph, m, color, v + 1)) {
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }

    private static boolean mColorIsSafe(int[][] graph, int[] color, int c, int v) {
        for (int i = 0; i < 4; i++) {
            if (graph[v][i] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = new String("love");
        permute(s.toCharArray(), 0, s.length()-1);

        knightTour();

        System.out.println();
        NQueenProblem();

        System.out.println("\n");
        int graph[][] = {{0, 1, 1, 1},
                        {1, 0, 1, 0},
                        {1, 1, 0, 1},
                        {1, 0, 1, 0},
                    };
        int m = 3;
        mColor(graph, m);

        Integer i = 12;
        Integer j = -(~i);

        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(-i));
        System.out.println(Integer.toBinaryString(~i));
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
    }
}
