package com.algorithms.qartks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qartks on 3/3/17.
 */
public class NextGreater {

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {2, 1, 3, 4, 2};

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for (int n : nums2) {
            while (!s.isEmpty() && n > s.peek()) {
                map.put(s.pop(), n);
            }
            s.push(n);
        }

        System.out.println(map.toString());
    }
}
