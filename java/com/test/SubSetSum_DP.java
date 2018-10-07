package com.test;

public class SubSetSum_DP {

    // Explaination: https://www.youtube.com/watch?v=s6FhG--P7z0

    public static void main(String[] args){
        int[] set = {2,3,7,8,10};
        int sum = 11;
        checkSubsetSum(set, sum);

        /*
        Output:
        Sum Possible: true
                    8
                    3
         */

    }
//Time complexity - O(input.size * total_sum)
    private static void checkSubsetSum(int[] set, int sum){
        boolean[][] sumMat = new boolean[set.length + 1][sum + 1];// taking one additional row and columns

        //set first column True, as a sum of 0 is possible using an empty set
        for(int i = 0; i < sumMat.length; i++){
            sumMat[i][0] = true;
        }

        //set the first row as false, except 0,0, as empty set can't yield any sum
        for(int i = 1; i < sumMat[0].length; i++){
            sumMat[0][i] = false;
        }

        for(int i = 1; i < sumMat.length; i++){
            for(int j = 1; j< sumMat[0].length; j++){
                if(j < set[i-1]){//copy the value from the top
                    sumMat[i][j] =  sumMat[i-1][j];
                }else{//j >= set[i] if the value at top is True then copy it, else go set[i-1] step back and copy that value
                    sumMat[i][j] =  sumMat[i-1][j] || sumMat[i-1][j - set[i-1]];
                }
            }
        }

        boolean sumPossible = sumMat[sumMat.length -1][sumMat[0].length -1];

        System.out.println("Sum Possible: "+sumPossible); //check the last element

        if(sumPossible){//print the elements/subset summing to the given sum

            int i = sumMat.length-1, j = sumMat[0].length-1;

            while (i >= 1 && j >=1){
                if(sumMat[i][j] == true && sumMat[i-1][j] ==false){
                    System.out.println(set[i-1]);
                    j = j - set[i-1-1];
                    i = i-1;
                }else if(sumMat[i][j] == true && sumMat[i-1][j] ==true){
                    i = i-1;
                }else{
                    i--;
                    j--;
                }
            }

        }

    }

}
