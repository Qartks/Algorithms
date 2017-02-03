package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/1/17.
 */
public class MatrixMultiplication {

    public static void matrixDp(int[] p) {
        int n = p.length;
        int m[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int L = 2; L < n; L++) {
            for (int i = 1; i <n-L+1 ; i++) {

                int j = i+L-1;
                if (i == j) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j-1; k++) {
                    m[i][j] = Math.min(m[i][j], m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]);
                }
            }
        }
        printArray(m);
        System.out.println(m[1][n-1]);
    }

    private static void printArray(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void main(String[] args) {

        int arr[] = new int[] {1, 2, 3, 4};
        matrixDp(arr);

    }
}
