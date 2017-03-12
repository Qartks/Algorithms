package com.algorithms.qartks;

/**
 * Created by qartks on 3/10/17.
 */
public class LongestSubArrEqual {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 2, 2, 2, 2, 2, 1, 3, 3, 3, 4, 4, 4, 5, 5};

        int currMax = 0;
        int maxLength = Integer.MIN_VALUE;
        int currElement = arr[0];

        for (int num : arr) {
            if (num == currElement) {
                currMax++;
            } else {
                currMax = 1;
                currElement = num;
            }

            maxLength = Math.max(maxLength, currMax);
        }

        System.out.println(maxLength);
    }
}
