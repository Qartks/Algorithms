package com.algorithms.qartks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qartks on 2/25/17.
 */
public class SumOfThree {

//    public List<List<Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
//        List<List<Integer>> res = new LinkedList<>();
//
//        for (int i = 0; i < num.length-2; i++) {
//
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//
//                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
//
//                while (lo < hi) {
//
//                    if (num[lo] + num[hi] == sum) {
//
//                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
//
//                        while (lo < hi && num[lo] == num[lo+1]) lo++;
//                        while (lo < hi && num[hi] == num[hi-1]) hi--;
//
//                        lo++; hi--;
//
//                    } else if (num[lo] + num[hi] < sum)
//                        lo++;
//                    else
//                        hi--;
//                }
//            }
//        }
//        return res;
//    }

    public static List<List<Integer>> sumOfThree (int[] nums, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == sum) {

                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;

                    } else if (nums[i] + nums[l] + nums[r] < sum) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int A[] = {0, 0, 0, 0, 0, 0} ;
        int sum = 0;

        int x = -2;

        System.out.println(x%2);

        System.out.println(sumOfThree(A, sum));
    }
}
