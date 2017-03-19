package com.algorithms.qartks;

import java.io.*;

/**
 * Created by qartks on 2/20/17.
 */
public class QuoraChallengesUpvote {


    public static void main(String[] args) throws IOException {
        String[] line = null;
        int N = 0, K = 0;
        long arr[] = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        arr = new long[N];
        line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(line[i]);
        }
        br.close();

        solve(N, K, arr);
    }

    private static void solve(int N, int K, long[] arr) {
        long[][] incDP = new long[2][N];
        long[][] decDP = new long[2][N];

        incDP[0][0] = 1;
        decDP[0][0] = 1;
        for (int i = 1; i < N ; i++) {
            incDP[0][i] = 1 + (arr[i] >= arr[i-1] ? incDP[0][i-1] : 0);
            decDP[0][i] = 1 + (arr[i] <= arr[i-1] ? decDP[0][i-1] : 0);
        }

        incDP[1][N-1] = 1;
        decDP[1][N-1] = 1;
        for (int i = N-2; i >= 0 ; i--) {
            incDP[1][i] = 1 + (arr[i] >= arr[i+1] ? incDP[1][i+1] : 0);
            decDP[1][i] = 1 + (arr[i] <= arr[i+1] ? decDP[1][i+1] : 0);
        }

        long countInc = 0;
        long countDec = 0;

        for (int i = 0; i < K - 1; i++) {
            countInc += incDP[0][i];
            countDec += decDP[0][i];
        }

        for (int i = K - 1; i <= N - 1; i++) {
            countInc += Math.min((long) K, incDP[0][i]);
            countDec += Math.min((long) K, decDP[0][i]);
            System.out.println(countInc - countDec);
            countInc -= Math.min((long) K, decDP[1][i-(K-1)]);
            countDec -= Math.min((long) K, incDP[1][i-(K-1)]);
        }
    }
}
