package com.test;

import java.util.HashMap;
import java.util.Map;

public class KnapSack_TopDown_DP {

    private static Map<Index, Integer> memMap = new HashMap<Index, Integer>();

    public static void main(String args[]){
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int w= getMaxWeightTopDown(val, wt, 30, 0);
        System.out.println(w);
    }


    private static int getMaxWeightTopDown(int values[], int weights[], int remainingWeight, int currentItem){

        //base case
        if(currentItem >= weights.length || remainingWeight <= 0){
            return 0;
        }

        //fom a key based on remainingWeight and remainingCount
        Index key = new Index();
        key.remainingItems = weights.length - currentItem -1;
        key.remainingWeight = remainingWeight;

        //see if key exists in map. If so then return the maximumValue for key stored in map.
        if(memMap.containsKey(key)) {
            return memMap.get(key);
        }

        int max;
        if(weights[currentItem] <= remainingWeight) {//get the max between picking this item and not picking
            int noPick = getMaxWeightTopDown(values, weights, remainingWeight, currentItem + 1);
            int pick = values[currentItem] + getMaxWeightTopDown(values, weights, remainingWeight - weights[currentItem], currentItem + 1);
            max=Integer.max(noPick, pick);
        }else{//remainingWt < weights[currentItem], do not pick the current item but try picking the next
            max=getMaxWeightTopDown(values, weights, remainingWeight, currentItem + 1);
        }

        memMap.put(key, max);
        return max;

    }

    /**
     * Key for memoization
     */
    static class Index {
        int remainingWeight;
        int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (remainingWeight != index.remainingWeight) return false;
            return remainingItems == index.remainingItems;

        }

        @Override
        public int hashCode() {
            int result = remainingWeight;
            result = 31 * result + remainingItems;
            return result;
        }
    }
}
