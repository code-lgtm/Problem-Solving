package epi.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestContainedIntervalLength {
    //Find the Longest Consecutive Subsequence in O(n) time and O(m) space, for example -2 -1 0 1 2 3 for the given array  {3,-2,7,9,8,1,2,0,-1,5,8}
    public static void main(String[] args){
        int[] ip = {5,3,-2,7,9,8,1,2,0,-1,5,8};
        System.out.println(getLongestConSub(ip));

        /*
        output: 6
        Worst case time complexity analysis (when all the characters are consecutive) :
            Total n iterations for the first value = O(n)
            After this the total array would have been replaced by -Infinity , so there will be a constant time for remaining n-1 elements , costing O(n-1)
            So, Total time: O(n) + (n-1) = O(n) approx

       Space complexity: O(m) - Where m is the number of unique values in the input

         */

    }

    static int getLongestConSub(int[] ip){
        int max = -1;
        Map<Integer, Integer> ipSet = new HashMap<>();

        for (int i = 0; i < ip.length; i++){
            ipSet.put(ip[i], i);
        }

        for (int j = 0; j<ip.length;j++ ){

            if (ip[j] == Integer.MIN_VALUE){
                continue;
            }

            int conLen = 0;
            int rCur=ip[j], lCur = ip[j]-1;

            while(ipSet.containsKey(rCur)){//try going right, that is value >= ip[j]
                conLen++;
                int ind = ipSet.get(rCur);
                ip[ind] = Integer.MIN_VALUE;//Delete the parsed value to reduce time complexity - Assuming the input wont have -infinity as the value
                rCur++;
            }

            while(ipSet.containsKey(lCur)){//try going left, that is value < ip[j]
                conLen++;
                int ind = ipSet.get(lCur);
                ip[ind] = Integer.MIN_VALUE;//Delete the parsed value to reduce time complexity - Assuming the input wont have -infinity as the value
                lCur--;
            }

            max = conLen>max? conLen:max;// see if we have a new max
        }

        return max;
    }

}
