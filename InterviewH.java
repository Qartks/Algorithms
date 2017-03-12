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
        minimumFlight(canyon);
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
                if (i <= j + canyon.get(j)  && fly[j] != Integer.MAX_VALUE) {
                    fly[i] = Math.min(fly[i], fly[j] + 1);
                    path[i] = j;
                }
            }
        }

        System.out.println(canyon.toString());
        System.out.println(Arrays.toString(fly));
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

    //Function caluclates the minimum flight required to clear the canyon without landing on the dragons
    static private void minimumFlight(List<Integer> canyon){
        ArrayList<Integer> flights = new ArrayList<Integer>();
        int lastFlight = 0, currentFlight = 0, selectedIndex = 0;
        int i;
        for(i=0;i<canyon.size();i++){
            if(i > currentFlight) // if the index is beyond current flight then just break out
                break;
            if(i > lastFlight){
                lastFlight = currentFlight;  // update last flight
                flights.add(selectedIndex);
            }
            int sum = i + canyon.get(i);
            if(sum > currentFlight && !isDragon(canyon,sum))
                selectedIndex = i;
            currentFlight = Math.max(currentFlight, sum);           // update current flight
        }

        // if i crosses the last flight and flights are present then add the last selected index
        if((i > lastFlight) && (flights.size() > 0) && flights.get(flights.size()-1) != selectedIndex){
            flights.add(selectedIndex);
        }

        // if last flight index was greater than or equal to last index of array then flight is possible
        if(lastFlight >= canyon.size()-1 && flights.size() != 0){
            for(Integer x : flights)
                System.out.print(x+", ");
            System.out.println("out");
        }
        else
            System.out.println("failure");

    }

    //Function finds if a dragon is present at the location given the array. Basically it checks if the location is 0 or not.
    static private boolean isDragon(List<Integer> array, int index) {
        if (index >= array.size() - 1)
            return false;
        return array.get(index) == 0;
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
