package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/5/17.
 */
public class MaxSizeSqaureMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]  {{0, 1, 1, 0, 1},
                                        {1, 1, 0, 1, 0},
                                        {0, 1, 1, 1, 0},
                                        {1, 1, 1, 1, 0},
                                        {1, 1, 1, 1, 1},
                                        {0, 0, 0, 0, 0}};

        printMaxSumSquare(matrix);
    }

    private static void printMaxSumSquare(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[][] sum = new int[R][C];

        for (int i = 0; i < R; i++) {
            sum[i][0] = matrix[i][0];
        }

        for (int i = 0; i < C; i++) {
            sum[0][i] = matrix[0][i];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 1) {
                    sum[i][j] = Math.min(sum[i][j-1], Math.min(sum[i-1][j-1], sum[i-1][j])) + 1;
                } else {
                    sum[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }
    }
}
