package com.test;

public class ShitedArySearch {

    public static void main(String[] args) {
        int[] shiftedAry = {7, 8, 9, 10, 11, 13, 15, 20, 1, 2, 3};
        int key = 2;

        int pivot = findPivotInd(shiftedAry, 0, shiftedAry.length - 1);
        System.out.println("Pivot: "+pivot);

        int foundKey = findKey(shiftedAry, pivot, key);
        System.out.println((foundKey == -1)? "NOT FOUND!": "Found "+foundKey);

    }


    static int findPivotInd(int[] shiftedAry, int min, int max){

        if(min > max){
            return -1;
        }

        int mid = (min + max)/2;

        if(mid < shiftedAry.length -1 && shiftedAry[mid] > shiftedAry[mid+1]){
            return mid;//pivot index
        }

        int leftFound = findPivotInd(shiftedAry, min, mid-1);

        if(leftFound != -1){
            return leftFound;
        }else{
            return findPivotInd(shiftedAry, mid+1, max);
        }


    }

   static  int findKey(int[] shiftedAry, int pivotIndex, int key){
            int foundLeft = bSearch(shiftedAry, 0, pivotIndex, key);
            if(foundLeft == -1){
                return bSearch(shiftedAry, pivotIndex+1, shiftedAry.length-1, key);
            }else{
                return foundLeft;
            }
    }

    static int bSearch (int[]shiftedAry, int min, int max, int key){
        if(min > max){
            return -1;
        }

        int mid = (min+max)/2;
        if(shiftedAry[mid] == key){
            return key;
        }
        int found = bSearch(shiftedAry, min, mid-1, key);
        if(found != -1){
            return found;
        }else{
            return bSearch(shiftedAry, mid+1, max, key);
        }

    }
}


