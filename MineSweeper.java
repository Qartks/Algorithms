package com.algorithms.qartks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by qartks on 3/12/17.
 */
public class MineSweeper {

    static int[] xDir = {0, 0, -1, 1, 1, -1, 1, -1};
    static int[] yDir = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void printField(char[][] arr) {
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                if (arr[i][j] == 'M') {
                    System.out.print("E" + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int minesCount(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int xPos = x + xDir[i];
            int yPos = y + yDir[i];

            if (isValid(board, xPos, yPos) && board[xPos][yPos] == 'M') {
                count++;
            }
        }
        return count;
    }

    private static boolean isValid(char[][] board, int xPos, int yPos) {
        int R = board.length;
        int C = board[0].length;

        if (xPos < 0 || xPos >= R || yPos < 0 || yPos >= C) {
            return false;
        }

        return true;
    }

    static public int updateBoard(char[][] board, int[] click) {
        int R = board.length;
        int C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return -1;
        }

        dfs(board, visited, click[0], click[1]);
        return 1;
    }

    private static void dfs(char[][] board, boolean[][] visited,  int x, int y) {
        if (!isValid(board, x, y) || visited[x][y]) return;

        int nums = minesCount(board, x, y);

        if (nums == 0) {
            board[x][y] = 'B';
            visited[x][y] = true;
            for (int i = 0; i < 8; i++) {
                int xPos = x + xDir[i];
                int yPos = y + yDir[i];
                dfs(board, visited, xPos, yPos);
            }
        } else {
            board[x][y] =  (char) ('0' + nums);
        }
    }

    public static void main(String[] args) {
        char[][] field = new char[][]
                    {{'E', 'E', 'E', 'E', 'E'},
                    {'E', 'E', 'M', 'E', 'E'},
                    {'E', 'E', 'E', 'E', 'E'},
                    {'E', 'M', 'E', 'E', 'E'}};

        Scanner io = new Scanner(System.in);
        int result = 0;

        while (result != -1) {
            printField(field);
            String[] move = io.nextLine().split(" ");
            result = updateBoard(field, new int[]{Integer.parseInt(move[0]), Integer.parseInt(move[1])});
        }
        printField(field);

    }
}
