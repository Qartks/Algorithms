package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 1/27/17.
 */
public class CoinChange {


    public static long countWays(int[] arr, int n) {

        long ways[] = new long[n+1];

        ways[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <=n ; j++) {
                ways[j] += ways[j - arr[i]];
            }
            System.out.println(Arrays.toString(ways));
        }
        return ways[n];
    }

    public static void main(String[] args) {

        int arr[] = {1, 4, 5, 7, 15};
        int n = 15;

        System.out.println(countWays(arr, n));
    }
}
