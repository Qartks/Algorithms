package com.algorithms.qartks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qartks on 2/17/17.
 */
public class LongestSubStringNonRepeating {

    static public int longestSubStringNonRepeating (String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        } else if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                index = Math.max(index, map.get(c));
            }
            result = Math.max(result, i - index);
            map.put(c, i);
        }
        System.out.println(map.toString());
        return result;
    }


    public static void main(String[] args) {

        String s = "aabbbdefbgf";

        System.out.println(longestSubStringNonRepeating(s));

    }
}
