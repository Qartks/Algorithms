package com.algorithms.qartks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qartks on 2/16/17.
 */
public class MajorityMoore {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        findMajority(arr);

        int[] a = {1, 2, 2, 2, 2, 2, 3, 4, 5};
        printMajority(a, a.length);
    }

    private static void findMajority(List<Integer> arr) {
    }

    private static void printMajority(int a[], int size)
    {
        int cand = findCandidate(a, size);

        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }

    private static int findCandidate(int a[], int size)
    {
        int m = 0, i = 1;

        for (int j = 1; j < size; j++) {
            if (a[m] == a[j]) {
                i++;
            } else {
                i--;
            }

            if (i == 0) {
                m = j;
                i = 1;
            }
        }

        return a[m];

//        int maj_index = 0, count = 1;
//        int i;
//        for (i = 1; i < size; i++)
//        {
//            if (a[maj_index] == a[i])
//                count++;
//            else
//                count--;
//            if (count == 0)
//            {
//                maj_index = i;
//                count = 1;
//            }
//        }
//        return a[maj_index];
    }

    private static boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++)
        {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }
}
