package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/25/17.
 */
public class BitCount {

    public static int[] bitCounting(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }
    public static void main(String[] args) {

        System.out.println(Arrays.toString(bitCounting(10)));
    }
}
