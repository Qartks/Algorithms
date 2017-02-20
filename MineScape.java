package com.algorithms.qartks;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qartks on 2/19/17.
 */
public class MineScape {


    public static void main(String[] args) {
        int n = 20;
        int row = 10;
        int col = 10;
        generateMineField(row, col, n);
    }

    private static void generateMineField(int R, int C, int n) {
        int[][] field = new int[R][C];
        int minePlaced = 0;
        Random r = new Random();

        while (minePlaced < n) {
            int row = r.nextInt(R);
            int col = r.nextInt(C);

            if (field[row][col] == 0) {
                field[row][col] = ++minePlaced;
            }
        }

        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
    }
}
