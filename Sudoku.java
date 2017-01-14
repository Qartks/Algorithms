package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 1/10/17.
 */
public class Sudoku {

    static class Pos {
        int row;
        int col;
        boolean result;
    }

    static int N = 9;

    public static void main(String[] args) {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if (SolveSudoku(grid))
            printGrid(grid);
        else
            System.out.println("No solution exists");
    }

    private static void printGrid(int[][] grid) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private static boolean UsedInRow(int grid[][], int row, int num)
    {
        for (int col = 0; col < N; col++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    private static boolean UsedInCol(int grid[][], int col, int num)
    {
        for (int row = 0; row < N; row++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    private static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num)
    {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row+boxStartRow][col+boxStartCol] == num)
                    return true;
        return false;
    }

    private static boolean isSafe(int grid[][], int row, int col, int num)
    {
        return !UsedInRow(grid, row, num) &&
                !UsedInCol(grid, col, num) &&
                !UsedInBox(grid, row - row%3 , col - col%3, num);
    }

    private static boolean SolveSudoku(int[][] grid) {
        int row, col;

        Pos p = AllAssigned(grid);
        row = p.row;
        col = p.col;

        if (!p.result) {
            return true;
        }


        for (int num = 1; num <= 9 ; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;

                if (SolveSudoku(grid)) {
                    return true;
                }

                grid[row][col] = 0;
            }
        }

        return false;
    }

    private static Pos AllAssigned(int[][] grid) {
        int row, col = 0;
        Pos res = new Pos();
        for (row = 0; row < N; row++) {
            for (col = 0; col < N; col++) {
                if (grid[row][col] == 0) {
                    res.result = true;
                    res.col = col;
                    res.row = row;
                    return res;
                }
            }
        }
        res.result = false;
        res.col = col;
        res.row = row;
        return res;
    }
}
