package com.algorithms.qartks;

import java.util.*;

/**
 * Created by qartks on 1/14/17.
 */
public class Misc {

    static void calculateSpan(int[] price) {
        int[] span = new int[price.length];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;

        for (int i = 1; i < price.length; i++) {

            while (!s.isEmpty() && price[s.peek()] <= price[i]) {
                s.pop();
            }

            span[i] = (s.empty()) ? (i+1) : (i - s.peek());
            s.push(i);

            System.out.println(s.toString());
        }

        System.out.println(Arrays.toString(span));
    }

    static void printSprial(int m, int n, int[][] mat) {
        int k = 0, l = 0,  i;

        while (k < m && l < n) {
            for (i = l; i < n; i++) {
                System.out.print(mat[k][i] + " ");
            }
            k++;

            for (i = k; i < m; i++) {
                System.out.print(mat[i][n-1] + " ");
            }
            n--;

            if (k < m) {
                for (i = n-1; i >= l; i--) {
                    System.out.print(mat[m-1][i] + " ");
                }
                m--;
            }

            if (l < n) {
                for (i = m-1; i >= k; i--) {
                    System.out.print(mat[i][l] + " ");
                }
                l++;
            }
        }
    }

    static private void randomShuffle(int[] array) {
        Math.abs(UUID.randomUUID().getMostSignificantBits());
        Random r = new Random();

        for (int i = array.length-1; i > 0 ; i--) {

            int j = r.nextInt(i+1);
            swap(array, i, j);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int findGreatProd(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        Arrays.sort(arr);

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < Math.sqrt(arr[i]); j++) {
                if (arr[i] % arr[j] == 0) {
                    int result = arr[i] /arr[j];

                    if (result != arr[j] && map.containsKey(arr[j]) && map.get(arr[j]) > 0) {
                        return arr[i];
                    } else if (result == arr[j] && map.containsKey(arr[j]) && map.get(arr[j]) > 1) {
                        return arr[i];
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr));
        randomShuffle(arr);
        System.out.println(Arrays.toString(arr));

        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                    {7,  8,  9,  10, 11, 12},
                    {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
                    };

        printSprial(5, 6, a);

        int price[] = {10, 4, 5, 90, 120, 80};
        System.out.println();
        calculateSpan(price);

        int prod[] = {17, 2, 1, 15, 30};
        System.out.println();
        System.out.println(findGreatProd(prod));

    }
}
