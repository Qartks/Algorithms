package com.algorithms.qartks;

/**
 * Created by qartks on 1/27/17.
 */
public class UglyNumber {

    public static int NthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int ugly_number = 0;

        int next_2 = 2;
        int next_3 = 3;
        int next_5 = 5;

        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            ugly_number = Math.min(next_2, Math.min(next_3, next_5));
            ugly[i] = ugly_number;

            if (ugly[i] == next_2) {
                i2 = i2 + 1;
                next_2 = ugly[i2] * 2;
            }
            if (ugly[i] == next_3) {
                i3 = i3 + 1;
                next_3 = ugly[i3] * 3;
            }
            if (ugly[i] == next_5) {
                i5 = i5 + 1;
                next_5 = ugly[i5] * 5;
            }
        }

        return ugly_number;
    }

    public static void main(String[] args) {
        System.out.println(NthUglyNumber(150));
    }
}
