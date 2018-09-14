package com.test;

import jdk.nashorn.internal.objects.NativeJava;

import java.util.HashMap;
import java.util.Map;

public class StaircaseProblem_DP {

    private static Map<Integer, Integer> ways = new HashMap<Integer, Integer>();


    //number of ways a kid can climb a staircase having 10 steps, if he can take 1, 2 or 3 steps at a time. Top down approach
    public static void main (String[] args){
        int totalSteps = 4;
        int stepIndex = totalSteps - 1;
        System.out.println(countWays1(stepIndex)+" - "+countWays2(stepIndex)+" - "+countWays3(stepIndex));
    }

    //Naive way O(2^n)
    private static int  countWays1(int n){
        if(n == 0){//1
            return 1;
        }else if(n == 1){ // 11, 2
            return 2;
        }else if(n == 2){
            return 4;//4 ways to climb the third stair. 111, 12, 21, 3
        }

        return countWays1(n -1) + countWays1(n -2) + countWays1(n -3);
    }

    //Naive way with memoisation. Top down approach
    private static int  countWays2(int n){

        if(n == 0){//1
            return 1;
        }else if(n == 1){ // 11, 2
            return 2;
        }else if(n == 2){
            return 4;//4 ways to climb the third stair. 111, 12, 21, 3
        }

        int way1, way2, way3;

        if(ways.containsKey(n-1)){
            way1 = ways.get(n-1);
        }else{
            way1 = countWays2(n -1 );
            ways.put(n-1, way1);
        }

        if(ways.containsKey(n-2)){
            way2 = ways.get(n-2);
        }else{
            way2 = countWays2(n -2);
            ways.put(n-2, way2);
        }

        if(ways.containsKey(n-3)){
            way3 = ways.get(n-3);
        }else{
            way3 = countWays2(n -3 );
            ways.put(n-3, way3);
        }


        return way1 + way2 + way3;

    }

    //DP - Bottoms up
    private static int countWays3(int n){


       int[] ways = new int[n+1];
        ways[0] = 1; //one way to climb on stair
        ways[1] = 2; //two ways to climb 2nd stairs
        ways[2] = 4; //4 ways to climb the third stair. 111, 12, 21, 3

        for(int i = 3; i <=n; i++){
            ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
        }
        // 1 2 4

        return ways[n];


    }

}


