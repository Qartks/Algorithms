package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 3/7/17.
 */
public class MaxDiff {


    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 2, 4, 8, 1};

        System.out.println(maxDiff2(arr));
    }

    private static int maxDiff2(int[] arr) {
        int result = -1;
        if (arr == null || arr.length <= 1) {
            return result;
        }
        int n = arr.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
        }

        rightMax[n-1] = arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }

        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMax));

        for (int i = 1; i < n; i++) {
            result = Math.max(result, rightMax[i] - leftMin[i]);
        }

        return result;
    }

    private static int maxDiff(int[] arr) {
        int result = -1;
        if (arr == null || arr.length <= 1) {
            return result;
        }
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n ; j++) {
                if (arr[j] > arr[i]) {
                    result = Math.max(result, arr[j] - arr[i]);
                }
            }
        }
        return result;
    }
}
