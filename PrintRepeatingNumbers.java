package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/19/17.
 */
public class PrintRepeatingNumbers {

    private static void printRepeatingNumbers(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] % n;
            System.out.println(index);
            arr[index] += n;
        }

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++)
        {
            if ((arr[i]/n) > 1)
                System.out.print(i + " ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 1, 3, 6, 6};

        printRepeatingNumbers(arr);
    }
}
