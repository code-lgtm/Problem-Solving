package com.test;

public class LongestPalindromicSubsequence_DP {

    public static void main(String[] args){
        String ip = "agbdba";

        getLogestP(ip.toCharArray());

    }

    static int getLogestP(char[] ip){

        int[][] aux = new int[ip.length][ip.length];


        for(int i = 0; i <= ip.length; i++){
          for(int j=0; j< ip.length -i; j++){

              // start at j end at j+i, including both indexes
              print(ip, j, j+i);

              if(ip[j] == ip[j+i]){
                  Math.max(aux[j-1][j+i], aux[j][j+i] + 1 );
              }

          }

        }
        return -1;
    }

    static void print(char[] ip, int start, int end){
        for(int i=start ;i <= end; i++){
            System.out.print(ip[i]);
        }
        System.out.println();
    }

}
