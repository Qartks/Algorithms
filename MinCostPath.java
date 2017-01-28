package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 1/27/17.
 */
public class MinCostPath {

    public static int minCost(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        } else if (m == 0 && n == 0) {
            return cost[m][n];
        } else {
            return cost[m][n] + Math.min( minCost(cost, m-1, n-1),
                    Math.min(minCost(cost, m-1, n),
                    minCost(cost, m, n-1) ));
        }
    }

    public static void minCostDP(int[][]cost, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        dp[0][0] = cost[0][0];

        for (int i = 1; i <=m; i++) {
            dp[i][0] = dp[i-1][0] + cost[i][0];
        }

        for (int i = 1; i <=n ; i++) {
            dp[0][i] = dp[0][i-1] + cost[0][i];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] = cost[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }

        System.out.println(dp[m][n]);
    }


    public static void main(String[] args) {

        int cost[][] = { {1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3} };

        System.out.println(minCost(cost, 2, 2));

        minCostDP(cost, 2, 2);

    }
}
