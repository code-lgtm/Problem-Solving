package com.test;

import java.util.Arrays;

public class Duplicates {
    public static void main(String[] args){
        int a = b = 0;
        int[] ip = {7,2,4,5,2,7,2,9,3,4,3,3,1,5};
       int n =  removeDuplicates(ip);
       for (int i = 0; i <= n; i++){
           System.out.print(ip[i]);
       }
       //Output: 1234579
    }

    //Two pointer approach - Time: O(n log n) , Space O(1);
    private static int removeDuplicates(int[] ip){
        Arrays.sort(ip);//Heap sort nlog(n) time and constant space
        int left = 0;
        for(int right = 1; right<ip.length; right++){
            if(ip[left] != ip[right]){
                ip[++left] = ip[right];
            }
        }
        return left;
    }
}