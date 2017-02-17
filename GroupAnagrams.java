package com.algorithms.qartks;

import java.util.*;
/**
 * Created by qartks on 2/16/17.
 */
public class GroupAnagrams {

    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }

        result.addAll(map.values());

//        Collections.sort(result, (a, b) -> b.size() - a.size());
//
//        for(String key: map.keySet()) {
//            Collections.sort(map.get(key));
//        }

        return result;

    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(arr));
    }

    private static void printResult(List<List<String>> lists) {
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
}
