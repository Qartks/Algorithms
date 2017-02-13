package com.algorithms.qartks;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

/**
 * Created by qartks on 2/6/17.
 */
public class RYInterview {


    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        Set<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int result = o1.getValue().compareTo(o2.getValue());

                if (result == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return result;
            }
        });

        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(io.nextLine());

        for (int i = 0; i < n; i++) {
            String ss = io.nextLine();
//            System.out.println(ss);
            String s[] = ss.split(" ");
//            System.out.println(Arrays.toString(s));
            Integer value = Integer.parseInt(s[1]);
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + value);
            } else {
                map.put(s[0], value);
            }
        }


//5
//orange 2
//apple 3
//plum 5
//peach 1
//orange 3

//        map.put("orange", 3);
//        map.put("apple", 2);
//        map.put("plum", 1);
//        map.put("peach", 2);

//        System.out.println(map.toString());
//        sortedSet.addAll(map.entrySet());
//        System.out.println(sortedSet.toString());
        int med = map.size()%2 == 0 ? map.size()/2 + 1 : map.size()/2;

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int result = o1.getValue().compareTo(o2.getValue());

                if (result == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return result;
            }
        });

        System.out.println(list.get(--med));

    }
}
