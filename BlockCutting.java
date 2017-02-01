package com.algorithms.qartks;

import java.util.Arrays;

public class BlockCutting {
	
	public static int blockStatic(int[] prices, int len)
	{
		int[] result = new int[len + 1];
		int[] s = new int[len + 1];

		result[0] = 0;
		for (int i = 1 ; i <= len; i++)  {
			int q = Integer.MIN_VALUE;
			for( int j = 0; j < i; j++)  {
				if (q < prices[j] + result[i-j-1]) {
					q = prices[j] + result[i-j-1];
					s[i] = j+1;
				}
			}
			result[i] = q;
		}
		
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(s));

		int n = len;
		while (n > 0) {
			System.out.print(s[n] + " ");
			n = n - s[n];
		}
		System.out.println();
		return result[len];
	}

	public static int rodCutRecur(int[] prices, int n) {
		if (n == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			q = Math.max(q, prices[i] + rodCutRecur(prices, n - i));
		}
		return q;
	}
	
	
	public static void main(String args[]) 
	{
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		
		System.out.println(blockStatic(prices, 5));
//		System.out.println(rodCutRecur(prices, 8));
	}

}
