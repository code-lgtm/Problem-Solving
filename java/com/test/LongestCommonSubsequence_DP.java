package com.test;

public class LongestCommonSubsequence_DP {

    public static void main(String[] args){

        String s1 = "aefbghcid", s2="abjklcd"; //abcd is the LCS

        findLcs(s1, s2);


        /*
              abjklcd
             00000000
            a01111111
            e01111111
            f01111111
            b01222222
            g01222222
            h01222222
            c01222233
            i01222233
            d01222234


         */

    }

    private static void findLcs(String s1, String s2){

        int[][] tmp = new int[s1.length() + 1][s2.length() + 1];

        //O(n^2) time and space
        for(int i = 1; i < tmp.length; i++){
            for(int j=1; j < tmp[0].length; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    tmp[i][j] = tmp[i-1][j-1] + 1;//diagonally opposite element tells the longest subsequence seen yet
                    System.out.print(s1.charAt(i-1));//for printing the longest subsequence incrementally
                }else{
                    int tmpMax = tmp[i][j-1] > tmp[i-1][j] ? tmp[i][j-1]: tmp[i-1][j];
                    tmp[i][j] = tmpMax; // just fill it with the max subsequence that we have seen till this point, so that it can later be used
                }
            }
        }

        System.out.println("Length of LCS: "+ tmp[tmp.length -1][tmp[0].length -1]);
    }


}
