package com.algorithms.qartks;

import java.util.Arrays;

public class HeapSort {
	
	public static void heapSort(int[] arr) {
		int len = arr.length;
		
		for(int i = len/2 - 1; i >=0; i--) {
			heapify(arr, len, i);
		}
		
		for(int i = len-1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}
	}
	
	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, 3, 2, 76, 5, 89, 11, 6, 3};
		
		heapSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
