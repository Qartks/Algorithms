package com.algorithms.qartks;

/**
 * Created by qartks on 1/27/17.
 */
public class EditDistance {

    public static void getEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        int dist[][] = new int[m+1][n+1];

        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <=n; j++) {

                if (i == 0) {
                    dist[i][j] = j;
                } else if (j == 0) {
                    dist[i][j] = i;
                } else if (s.charAt(i-1) == t.charAt(j-1)){
                    dist[i][j] = dist[i-1][j-1];
                } else {
                    dist[i][j] = 1 + Math.min(dist[i-1][j],
                                            Math.min(dist[i][j-1],
                                            dist[i-1][j-1]));
                }
            }
        }

        System.out.println(dist[m][n]);
    }


    public static void main(String[] args) {
            String s = "Kartikeya";
            String t = "Kartikaye";

            getEditDistance(s, t);
    }
}
