package com.algorithms.qartks;

import java.util.*;

/**
 * Created by qartks on 2/12/17.
 */
public class InterviewY {


    static List<String> groupAnagrams(List<String> list) {

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] s1 = o1.toCharArray();
                char[] s2 = o2.toCharArray();

                return String.valueOf(s2).compareTo(String.valueOf(s1));
            }
        });
        return list;
    }

    static String getRest(List<String> r1, List<String> r2) {
        Map<String, Integer> map = new HashMap<>();

        int rank = 1;
        for (String s : r1) {
            map.put(s, rank++);
        }

        rank = 1;
        String result = "Yelpwich";
        int minRank = Integer.MAX_VALUE;
        for (String s : r2) {
            if (map.containsKey(s)) {
                int getRank = map.get(s);
                int totalRank = getRank +rank;
                if (totalRank < minRank) {
                    minRank = totalRank;
                    result = s;
                }
            }
            rank++;
        }

        return result;
    }
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        l1.add("A");
        l1.add("B");
        l1.add("C");

        l2.add("E");
        l2.add("B");

        System.out.println(getRest(l1, l2));

        List<String> list = new ArrayList<>();
        list.add("pet");
        list.add("dog");
        list.add("ert");
        list.add("etp");
        list.add("dt");
        list.add("tep");

        System.out.println(list.toString());
        System.out.println(groupAnagrams(list).toString());

    }
}
