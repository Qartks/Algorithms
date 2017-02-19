package com.algorithms.qartks;

import java.util.*;

/**
 * Created by qartks on 2/18/17.
 */
public class AmicableNumbers {

    static int sumOfDivisors(int n) {
        int sum = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ( n%i == 0) {
                sum += i;
                if (n/i != i) {
                    sum += n/i;
                }
            }
        }
        return sum;
    }

    static int findAmicableNumbers(int[] arr) {
        int result = 0;

        Set<Integer> set = new HashSet<>();

        for (int i : arr) set.add(i);

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(sumOfDivisors(arr[i]))) {
                result++;
            }
        }

        return result/2;
    }

    public static void main(String[] args) {

        int arr[] = {2620, 2924, 5020, 5564, 6232, 6368};

        System.out.println(findAmicableNumbers(arr));

    }
}
