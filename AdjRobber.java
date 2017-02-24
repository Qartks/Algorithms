package com.algorithms.qartks;

/**
 * Created by qartks on 2/24/17.
 */
public class AdjRobber {

    public static int rob(int[] nums) {
        int prevYes = 0;
        int prevNo = 0;
        for (int i = 0; i < nums.length; i++) {

        }

        return Math.max(prevYes, prevNo);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        System.out.println(rob(nums));
    }
}
