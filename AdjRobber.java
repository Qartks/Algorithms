package com.algorithms.qartks;

/**
 * Created by qartks on 2/24/17.
 */
public class AdjRobber {

    public static int rob(int[] nums) {
        int prevYes = 0;
        int prevNo = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = nums[i] + temp;
        }

        return Math.max(prevYes, prevNo);
    }

    public static int rob2(int[] nums) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(b + nums[i], a);
            }
        }

        return Math.max(a, b);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 7, 4};

        System.out.println(rob2(nums));
    }
}
