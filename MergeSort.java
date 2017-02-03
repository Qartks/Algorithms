package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/2/17.
 */
public class MergeSort {

    static void mergeSort(int[] arr) {
        int[] aux = arr.clone();
        mergeSortUtil(arr, 0, arr.length-1, aux);
    }

    private static void mergeSortUtil(int[] arr, int low, int high, int[] aux) {
        if (low >= high) return;

        int mid = low + (high - low)/2;
//        int mid = low/2 + high/2 + (low & high & 1);

        mergeSortUtil(arr, low, mid, aux);
        mergeSortUtil(arr, mid+1, high, aux);

        merge(arr, low, mid, high, aux);

    }

    private static void merge(int[] arr, int low, int mid, int high, int[] aux) {
        int left = low;
        int right = mid+1;
        int index = low;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                aux[index] = arr[left];
                left++;
            } else {
                aux[index] = arr[right];
                right++;
            }
            index++;
        }
        System.arraycopy(arr, left, aux, index, mid - left + 1);
        System.arraycopy(arr, right, aux, index, high - right + 1);
        System.arraycopy(aux, low, arr, low, high - low + 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 6, 4, 8, 56, 34, 56, 23, 1, 0};

        mergeSort(arr);
    }
}
