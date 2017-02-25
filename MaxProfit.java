package com.algorithms.qartks;

/**
 * Created by qartks on 2/25/17.
 */
public class MaxProfit {

    public static int maxProfit(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i] - min);
        }

        return max;
    }

    public static int maxProfitMultipleTrans(int[] arr) {
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                result += (arr[i+1] - arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(arr));
        System.out.println(maxProfitMultipleTrans(arr));
    }
}
