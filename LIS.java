package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 1/27/17.
 */
public class LIS {

    static void longestBitonicSeq(int[] arr) {
        int n = arr.length;
        int lis[] = new int[n];
        int lds[] = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 1; i < n ; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = n-2; i >=0 ; i--) {
            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1 );
        }

        System.out.println(max);
    }

    static void longPalindromicSeq(String s) {
        int n = s.length();

        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <n-L+1 ; i++) {

                int j = i+L-1;

                if (s.charAt(i) == s.charAt(j) && L == 2) {
                    dp[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }

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

    public static void longestIncreasingSumSubsequence(int[] arr) {
        int[] lis = new int[arr.length];

        Arrays.fill(lis, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + arr[i]) {
                    lis[i] = lis[j] + arr[i];
                }
            }
        }

        System.out.println(Arrays.toString(lis));
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

//        longestIncreasingSubsequence(arr);

        String X = "AGGTAB";
        String Y = "GXTXAYB";

//        longestCommonSubsequence(X, Y);

        String seq = "GEEKSFORGEEKS";
//        longPalindromicSeq(seq);

        int bitonic[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
//        longestBitonicSeq(bitonic);

        int incSum[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        longestIncreasingSumSubsequence(incSum);
    }
}
