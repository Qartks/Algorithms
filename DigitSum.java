package com.algorithms.qartks;

/**
 * Created by qartks on 2/20/17.
 */
public class DigitSum {

    /*
    Given integers sum and numberLength, find the number of non-negative integers less than 10numberLength such that
    the sum of digits for each of them is equal to sum.

    Example

    For sum = 5 and numberLength = 2, the output should be
    digitSumInverse(sum, numberLength) = 6.

    These integers are: 5, 14, 23, 32, 41, 50.

     */

    private static int digitSumInverse(int sum, int numberLength) {
        int size = (int) Math.pow(10, numberLength);

        int result = 0;
        for (int i = 1; i < size; i++) {
            if (sumOfDigits(i) == sum) result++;
        }

        return result;
    }

    private static int sumOfDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum += (n%10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(digitSumInverse(5, 2));
    }
}
