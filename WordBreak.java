package com.algorithms.qartks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qartks on 2/25/17.
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;

        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 0; i <=s.length() ; i++) {
            for (String w : wordDict) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && s.substring(j, i).equals(w)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");

        System.out.println(wordBreak(s, list));
    }
}
