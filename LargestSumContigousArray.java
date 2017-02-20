package com.algorithms.qartks;

/**
 * Created by qartks on 2/19/17.
 */
public class LargestSumContigousArray {

    public static void main(String[] args) {

        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));

    }

    private static int maxSubArraySum(int[] arr) {
        int max_so_far = arr[0];
        int curr_max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curr_max = Math.max(arr[i], arr[i] + curr_max);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}
