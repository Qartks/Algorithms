package com.algorithms.qartks;

import javafx.util.Pair;

/**
 * Created by qartks on 1/27/17.
 */
public class Knapsack01 {

    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        solve(values, weights, W);

    }

    private static void solve(int[] values, int[] weights, int W) {
        int N = values.length;
        int[][] dp = new int[N+1][W+1];

        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i-1] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w - weights[i-1]]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[N][W]);
    }
}
