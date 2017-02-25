package com.algorithms.qartks;

/**
 * Created by qartks on 2/25/17.
 */
public class SortedIfReversed {

    public static boolean sortedIfSubArrayReversed (int[] arr) {
        if (arr == null) {
            return false;
        }
        int n = arr.length;

        if (n == 1 || n == 0) {
            return true;
        }

        // First Increasing Part
        int i;
        for (i=1; i < n && arr[i-1] < arr[i]; i++);
        if (i == n) return true;

        // Decreasing Part
        int j = i;
        while (arr[j] < arr[j-1]) {
            if (i > 1 && arr[j] < arr[i-2]) return false;
            j++;
        }
        if (j == n) return true;

        // Second Increasing Part
        int k = j;
        while (k < n && k > 1) {
            if (arr[k-1] > arr[k]) {
                return false;
            }
            k++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5, 4, 3, 6, 7};

        System.out.println(sortedIfSubArrayReversed(arr));
    }
}
