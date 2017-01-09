package com.algorithms.qartks;

import java.util.Arrays;

public class BlockCutting {
	
	public static int blockStatic(int[] prices, int len)
	{
		int[] result = new int[len + 1];

		result[0] = 0;
		for (int i = 1 ; i <= len; i++)  {
			int q = Integer.MIN_VALUE;
			for( int j = 1; j <= i; j++)  {
				q = Math.max(q, prices[j] + result[i - j]);
			}
			result[i] = q;
		}
		
		System.out.println(Arrays.toString(result));
		return result[len];
	}
	
	
	public static void main(String args[]) 
	{
		int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		
		System.out.println(blockStatic(prices, 5));
	}

}
