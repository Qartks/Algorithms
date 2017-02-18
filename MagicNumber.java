package com.algorithms.qartks;

/**
 * Created by qartks on 2/18/17.
 */
public class MagicNumber {

    static int getNthMagicNumber(int n) {
        int power = 1;
        int answer = 0;

        while (n > 0) {
            power = power * 5;

            if ((n & 1) == 1) {
                answer += power;
            }
            n >>= 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(getNthMagicNumber(n));

    }
}
