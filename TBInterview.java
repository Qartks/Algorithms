package com.algorithms.qartks;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by qartks on 2/9/17.
 */
public class TBInterview {


    public static int ascii_delettion_recur (String s, String t, int len1, int len2) {
        if (len1 == 0) {
            return sumOfAscii(t, len2);
        }

        if (len2 == 0) {
            return sumOfAscii(s, len1);
        }

        if (s.charAt(len1 - 1) == t.charAt(len2 - 1)) {
            return ascii_delettion_recur(s, t, len1 - 1, len2 - 1);
        }
        int deleteS = (int) s.charAt(len1 - 1);
        int deleteT = (int) t.charAt(len2 - 1);

        return Math.min(deleteS + ascii_delettion_recur(s, t, len1-1, len2), deleteT + ascii_delettion_recur(s, t, len1, len2 - 1));
    }

    public static int check_ascii_delettion_recur (String s, String t, int len1, int len2, int[][] dp) {
        if (len1 == 0) {
            return dp[len1][len2] = sumOfAscii(t, len2);
        }

        if (len2 == 0) {
            return dp[len1][len2] = sumOfAscii(s, len1);
        }

        if (s.charAt(len1 - 1) == t.charAt(len2 - 1)) {
            return dp[len1][len2] = check_ascii_delettion_recur(s, t, len1 - 1, len2 - 1, dp);
        }
        int deleteS = (int) s.charAt(len1 - 1);
        int deleteT = (int) t.charAt(len2 - 1);

        return dp[len1][len2] = Math.min(deleteS + check_ascii_delettion_recur(s, t, len1-1, len2, dp), deleteT + check_ascii_delettion_recur(s, t, len1, len2 - 1, dp));
    }

    private static int sumOfAscii(String s, int len) {
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += (int) s.charAt(i);
        }
        return sum;
    }

    public static void ascii_deletion_distance (String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <=len2 ; j++) {
                if (i == 0) {
                    dp[i][j] = sumOfAscii(t, j);
                } else if (j == 0){
                    dp[i][j] = sumOfAscii(s, i);
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int deleteS = (int) s.charAt(i - 1);
                    int deleteT = (int) t.charAt(j - 1);

                    dp[i][j] = Math.min(dp[i-1][j] + deleteS, dp[i][j-1] + deleteT);
                }
            }
        }

        for (int i = 0; i <= len1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    public static void main(String[] args) {
        String s = "boat";
        String t = "got";

        int dp[][] = new int[s.length()+1][t.length()+1];

//        System.out.println(ascii_delettion_recur(s, t, s.length(), t.length()));
//        System.out.println();
//        System.out.println(check_ascii_delettion_recur(s, t, s.length(), t.length(), dp));
//        System.out.println();
//        for (int i = 0; i <= s.length(); i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
//        System.out.println();
        ascii_deletion_distance(s, t);
    }
}
