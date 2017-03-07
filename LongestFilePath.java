package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 3/2/17.
 */
public class LongestFilePath {

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        String[] lines = input.split("\n");
        int[] dp = new int[lines.length + 1];
        int maxLen = 0;

        System.out.println(input);
        for (String s : lines) {
            int level = s.lastIndexOf("\t")+1;
            dp[level + 1] = dp[level] + s.length() - level + 1;
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, dp[level + 1] - 1);
            }
        }

        System.out.println(maxLen);
    }

}
