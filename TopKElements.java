package com.algorithms.qartks;

import java.util.*;

/**
 * Created by qartks on 2/16/17.
 */
public class TopKElements {
    
    public static List<Integer> getTopKElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            maxHeap.add(m);
        }

        List<Integer> result = new ArrayList<>();
        while (result.size() < k) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    } 

    public static void main(String[] args) {
        int[] arr = {1 ,1 , 1, 2 , 2, 2, 2, 2, 3, 2, 3, 3, 4, 5, 4};

        System.out.println(getTopKElements(arr, 2).toString());
    }
}
