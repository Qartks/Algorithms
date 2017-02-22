package com.algorithms.qartks;

/**
 * Created by qartks on 2/20/17.
 */
public class QuoraChallengesUpvote {


    public static void main(String[] args) {
        int[] arr = {1 ,2 ,3 , 1, 1};

//        System.out.println(getIncrease);

        int N = 3;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j  || (i+j)%N==N-1){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }
}
