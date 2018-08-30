package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletSum_UniqueIP {

    //Find the triplet with the given sum. Not the input MUST NOT contain duplicated and is unsorted
    public static void main(String[] args) {
        int[] ip = {27, 15,17, 5,7,31};
        findTripletWithSum(ip, 75);
    }



    public static void findTripletWithSum(int[] ip, int sum) {

        Arrays.sort(ip);//n log n

    //populate a hash set
        Set<Integer> hs = new HashSet<Integer>();//O(n log n)
        for(int i:ip){
            hs.add(i);
        }

        //take two pointers
        int left = 0 , right = ip.length -1;

        while(left< ip.length && right>0){
            int num = sum - (ip[left] + ip[right]);
            if(hs.contains(num)){
                System.out.println("Triplet Found: "+ip[left] + " "+ip[right]+" "+num);
                return;
            }else if (ip[left] +ip[right] > sum){//reduce the sum by 1 step by shifting the right pointer towards left, then next iteration will check of there is a matching third number
                right--;
            }else{
                left++;
            }
        }

        System.out.println("Triplet NOT Found ");


    }

}
