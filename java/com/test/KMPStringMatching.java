package com.test;

public class KMPStringMatching {
//explaination: https://www.youtube.com/watch?v=GTJr8OvyEVQ

    public static void main(String[] args){
    //Time complexity O(ip.length + pattern.length)
    
        char[] ip = "abxabcabcaby".toCharArray();
        char[] pattern = "abcaby".toCharArray();
        int[] tempMatchAry = getTempMatchAry(pattern);
        int matchIndex = performMatch(ip, pattern, tempMatchAry);
        System.out.println(matchIndex);
    }

    private static int performMatch(char[] ip, char[] pattern, int[] tempMatchAry){

        int i =0, j=0;

        while(i < ip.length && j < pattern.length){

            if(ip[i] == pattern[j]){
                i++;
                j++;
            }else{
                if (j!=0){
                    j = tempMatchAry[j-1];
                }else{
                    i++;
                }

            }

        }

        if(j == pattern.length){
            return i - j;//starting point of pattern in the input
        }

        return -1;
    }

    //this method checks of there is a prefix which is a suffix as well, at every index of the pattern
    private static int[] getTempMatchAry(char[] pattern){

        int[] temp = new int[pattern.length];
        int i = 1, j = 0;

        while(i < pattern.length && j < pattern.length){
            if(pattern[j] == pattern[i]){
                temp[i] = j+1;
                i++;
                j++;
            }else{
                if(j!= 0){
                    j = temp[j-1];
                }else{
                    temp[i] = 0;
                    i++;
                }

            }

        }

        return temp;
    }

}
