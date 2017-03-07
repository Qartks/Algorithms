package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 3/7/17.
 */
public class ConvertPalindrome {

    public static void main(String[] args) {
        String[] letters = {"aabbbaa", "bcd", "abc", "abcd"};

        System.out.println(Arrays.toString(mystery(letters)));
    }

    private static int[] mystery(String[] letters) {
        int[] result = new int[letters.length];

        int i = 0;
        for (String letter : letters) {
            result[i++] = operations(letter);
        }
        return result;
    }

    private static int operations(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        if (s.length() == 1) {
            return result = 1;
        }

        int end = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            result += (Math.abs((int)s.charAt(i) - (int)s.charAt(end)));
            end--;
        }
        return result;
    }
}
