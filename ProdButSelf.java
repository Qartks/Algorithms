package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/25/17.
 */
public class ProdButSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 1, 2, 0, 4};

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
