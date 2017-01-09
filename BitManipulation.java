package com.algorithms.qartks;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by qartks on 1/4/17.
 */
public class BitManipulation {

    public static int rotateLeft(int n, int k)
    {
        return  (n << k) | (n >> (32 - k));
    }

    public static int rotateRight(int n, int k)
    {
        return (n >> k) | (n << (32 - k));
    }

    public static int numberOfBits(int n)
    {

        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;

    }

    public static boolean isPalindrome(String s)
    {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void printAllPalindromes(String s)
    {
        List<String> result = new ArrayList<>();
        printPalindromeUtil(result, s,0, s.length());

        System.out.println(result.toString());
    }

    private static void printPalindromeUtil(List<String> result, String s, int l, int r) {

        for (int i = l; i < r; i++) {
            String sub = s.substring(i, r);
            System.out.println(sub);
            if (isPalindrome(sub)) {
                printPalindromeUtil(result, sub, i+1, r);
                result.add(sub);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(numberOfBits(32));

        int result = rotateLeft(32, 3);
        System.out.println(result);
        result = rotateRight(32, 3);
        System.out.println(result);

        BitSet b = new BitSet();
        b.set(1);
        b.set(2);
        b.set(5);
        System.out.println(b.toString());

        System.out.println(isPalindrome("nitin"));
        printAllPalindromes("nitin");
    }
}
