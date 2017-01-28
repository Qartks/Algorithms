package com.algorithms.qartks;

import java.util.*;
import java.io.*;

/**
 * Created by qartks on 1/26/17.
 */
public class InterviewH {

    public static void main(String[] args) throws Exception {

        Scanner io = new Scanner(new BufferedInputStream(System.in));

        List<Integer> canyon = null;
        int abilityToFly = 0;

        while (io.hasNextInt()) {

            if (canyon == null) {
                canyon = new ArrayList<>();
            }

            int flyValue = io.nextInt();
            abilityToFly += flyValue;
            canyon.add(flyValue);
        }

        if (canyon == null || abilityToFly == 0 || canyon.get(0) == 0) {
            System.out.println("failure");
            return;
        }

        completeTheQuest(canyon);
    }

    private static void completeTheQuest(List<Integer> canyon) {
        int len = canyon.size();
        int[] fly = new int[len];
        int[] path = new int[len];

        Arrays.fill(path, -1);
        Arrays.fill(fly, Integer.MAX_VALUE);
        
        fly[0] = 0;
        path[0] = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if ( (i <= j + canyon.get(j)  && fly[j] != Integer.MAX_VALUE) || (j + canyon.get(j) > len) ) {
                    fly[i] = Math.min(fly[i], fly[j] + 1);
                    path[i] = j;
                }
            }
        }

        if (fly[len-1] == Integer.MAX_VALUE) {
            System.out.print("failure");
            return;
        }

        System.out.println(Arrays.toString(fly));
        for (int i = 0; i < len; i++) {

            if (i+1 >= len || fly[i] != fly[i+1]) {
                System.out.print(i + ", ");

            }

        }
        System.out.print("out");
    }
}


//5
//6
//0
//4
//2
//4
//1
//0
//0
//4
//a
