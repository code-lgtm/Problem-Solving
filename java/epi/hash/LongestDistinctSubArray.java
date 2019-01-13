package epi.hash;

import java.util.HashMap;
import java.util.Map;

//Find to longest distinct subarray in O(n) time and O(m) space ; m = number of unique inputs
public class LongestDistinctSubArray {

    public static void main(String[] args){
        char[] ip = "fsfetwenwe".toCharArray();
        System.out.println(getLongestSubAry(ip));
        ip = "fefefefeabcd".toCharArray();
        System.out.println(getLongestSubAry(ip));

        /*
        Output:
                Range: 1 5
                5
                Range: 6 11
                6
         */
    }

    static int getLongestSubAry(char[] ip){
        int max = -1;
        Map<Character, Integer> pos = new HashMap<>();
        int loc1 = 0, loc2 = 0;
        for (int i = 0,  j=0; i< ip.length-1 && j <ip.length;j++){
            if(! pos.containsKey(ip[j])){//if it not repeated element then put it in the map and see if we get a max sub array
                pos.put(ip[j], j);
                int tempMax = j-i+1;
                if(tempMax > max){
                    max = tempMax;
                    loc1 = i;
                    loc2 = j;
                }

            }else{// we got a repeated char, i should start from the previous occurence of the repeated char, and update the index of the repeated char // sliding window
                int preJ = pos.get(ip[j]);
                i = preJ+1;
                pos.put(ip[j], j);
            }
        }
        System.out.println("Range: "+loc1+" "+loc2);
        return max;
    }

}
