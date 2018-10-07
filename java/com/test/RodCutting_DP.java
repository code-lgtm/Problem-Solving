package com.test;

public class RodCutting_DP {

//explaination: https://www.youtube.com/watch?v=IRwVmTmN6go

    public static void main(String[] args){
        int totalLength = 5;
        int[] pieces = {1,2,3,4};
        int[] prices = {2,5,7,8};

        System.out.println("Max Profit: "+ getMaxProfit(totalLength, pieces, prices));
    }
// Time complexity: O (totalLength * pieces )
    private static int getMaxProfit(int totalLength, int[] pieces, int[] prices){

        int[][] profitMat = new int[prices.length + 1][totalLength+1];

        for(int i = 1; i< profitMat.length; i++){
            for(int j = 1; j < profitMat[0].length; j++){

                if(pieces[i-1]  >  j){//cant use the given piece for the length j, copy the value from the top
                    profitMat[i][j] = profitMat[i-1][j];
                }else{//find the max, between picking and not picking
                    int notPick = profitMat[i-1][j];
                    int pick = profitMat[i][j - pieces[i-1]] + prices[i-1];
                    profitMat[i][j] = Integer.max(notPick, pick);
                }

            }
        }

        return profitMat[profitMat.length -1][profitMat[0].length -1];

    }
}
