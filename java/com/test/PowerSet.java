package com.test;

public class PowerSet {

    public static void main(String[] args){
        char[] set = {'a', 'b', 'c', 'd'};
        printPowerSet(set);
    }

    private static void printPowerSet(char[] set){

        int powSetCount = (int)Math.pow(2, set.length);
        System.out.println("Printing powerset with size: "+powSetCount);

        for(int cnt = 0; cnt < powSetCount; cnt++){
            //check if ith bit is set in the counter i , if yes then print the ith char if the set

            for(int i = 0; i < set.length; i++){
                if( (cnt & 1<<i) >0){//ith bit is set
                    System.out.print(set[i]);
                }
            }
            System.out.println();

        }

    }

}
