package com.test;

public class MagicPoint_WithDuplicates {
    //https://www.geeksforgeeks.org/find-fixed-point-array-duplicates-allowed/

    //Time complexity: Worst case O(n), best case sublinear
    public static void main(String[] args){
        //magic index is an index i such that i = ar[i]
        // int[] ip = {-10, -1, 3, 3, 10, 30, 30, 50, 100};
        int[] ip = {-10, -1, 4, 4, 4, 6, 30, 30, 100};
        int ind = getMagicInd(ip, 0, ip.length-1);

        System.out.println("Magic Index: "+ind);
    }

    static int getMagicInd(int[] ip, int left, int right){

        if(left > right){
            return -1;
        }

        int mid = (left + right)/2;

        int midValue = ip[mid];
        if(ip[mid] == mid){
            return midValue;
        }

        //if ar[10] is 5, then there can't be anynumber > 5 till index 10 IF ar[5] is 5. That is no point searching between 5 and 10 in this case, left search should continue from 0 -> 5
        int leftIndex = Math.min(midValue, mid-1);
        int letVal = getMagicInd(ip, 0, leftIndex);
        if(letVal >= 0){
            return letVal;
        }

        //similarly
        int rightIndex = Math.max(mid+1, midValue);
        return getMagicInd(ip, rightIndex, right);





    }

}
