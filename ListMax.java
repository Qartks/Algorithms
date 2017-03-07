package com.algorithms.qartks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by qartks on 3/7/17.
 */
public class ListMax {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        String[] line1 = io.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i+1);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            String[] op = io.nextLine().split(" ");
            int a = Integer.parseInt(op[0]);
            int b = Integer.parseInt(op[1]);
            int k = Integer.parseInt(op[2]);

            for (int j = a; j <=b; j++) {
                arr[j-1] += k;
                result = Math.max(result, arr[j-1]);
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(result);
    }
}
