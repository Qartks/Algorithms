package com.algorithms.qartks;

/**
 * Created by qartks on 2/17/17.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length==0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }

        return pre;
    }

    public static String longestCommonPrefixBinary (String[] strs) {
        if (strs == null || strs.length==0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        int low = 1;
        int high = minLen;

        while (low <= high) {
            int mid = low/2 + high/2 + (low & high & 1);
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }



    public static void main(String[] args) {
        String[] strs = {"prefix", "prefox", "prefbox", "prefsox", "prefp"};

        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixBinary(strs));

    }
}
