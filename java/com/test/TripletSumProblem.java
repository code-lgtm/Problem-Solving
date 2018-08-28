package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TripletSumProblem {

    //this hash will maintain value: their positions map
    private static Map<Integer, ArrayList> numHash = null;

    //Find the triplet with the given sum. Not the input might contain duplicated and is unsorted
    public static void main(String[] args) {
        int[] ip = {1, -6, 70, 5, 5,37, 28, 83, 26, 37, 95, 27};
        findTripletWithSum(ip, 133);
    }

    public static void findTripletWithSum(int[] ip, int sum){
        //pick first two numbers by bruitforce anf the 3rd using a hash
        //time comlexity O(n2)
        for(int i = 0; i < ip.length; i++){
            for(int j = i+1; j < ip.length; j++){
                int thirdNum = sum - (ip[i]+ip[j]);
                if (hashContains(ip, thirdNum, i, j)){
                    System.out.println("Found a triplet: "+ ip[i]+" + "+ip[j]+" + "+thirdNum);
                    return;//we are looking for just one triplet
                }
            }
        }
    }

    //runs in O(1) in average case
    public static boolean hashContains(int[] ip, int third , int i, int j){

        if(numHash == null){//initialize and populate the hash
           numHash = new HashMap<Integer, ArrayList>();
           for(int k = 0; k < ip.length; k++){
               if(numHash.containsKey(ip[k])){
                   ArrayList<Integer> indexes = numHash.get(ip[k]);
                   indexes.add(k);//that is a given number is found in these many indexes
               }else{
                   ArrayList<Integer> indexes = new ArrayList<Integer>();
                   indexes.add(k);
                   numHash.put(ip[k], indexes);
               }
           }
        }


        //else the hash has already been populated
        //now we have to check if hash has the number 'third' which was not at index i and j

        if(numHash.containsKey(third)){
            ArrayList<Integer> indexes = numHash.get(ip[i]);//basically 'indexes' must have an index which is not i and j
            int matched = 0;
            for(int ind: indexes){
                if(ind == i || ind == j){
                    matched++;
                }
            }

            if( (indexes.size() - matched) > 0){//that is the third number occurs atleast one more time other than i and j, so we are not picking an idexed which has already been picked by bruitforce
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }

    }

}
