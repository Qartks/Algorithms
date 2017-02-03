package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 1/27/17.
 */
public class LIS {

    static void longestCommonSubsequence(String s, String t) {

        int[][] dp = new int [s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        System.out.println(dp[s.length()][t.length()]);
    }

    public static void longestIncreasingSubsequence(int[] arr) {
        int[] lis = new int[arr.length];
        int[] prev = new int[arr.length];

        Arrays.fill(lis, 1);
        prev[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(prev));
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };

        longestIncreasingSubsequence(arr);

        String X = "AGGTAB";
        String Y = "GXTXAYB";

//        longestCommonSubsequence(X, Y);
    }
}
