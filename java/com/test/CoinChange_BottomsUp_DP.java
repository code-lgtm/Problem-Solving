package com.test;

public class CoinChange_BottomsUp_DP {

    public static void main(String[] a){
        int total = 13;
        int[] coins = {7,2,3,6};
        System.out.println(calMinCoins(total,  coins));
    }

    // time complexity: O(total * totalCoins)
    private static int calMinCoins( int total, int[] coins){

        int[] coinValAux = new int[total +1];//aux array for having values from 0 ... total, index 0 will me marked as 0, remaining to infinity
        int[] coinPicked = new int[total + 1];

        coinPicked[0] = -1;
        for(int i = 1; i < coinPicked.length; i++){
            coinValAux[i] = Integer.MAX_VALUE;
            coinPicked[i] = -1;
        }


        for (int i =0 ; i < coins.length; i++){
            for(int j = 1; j < coinValAux.length; j++){// that is for every new coin value, iterate through all the coin values to see what is the min num if coins possible at every iteration
                if(j >= coins[i]){
                    int jNotPicked = coinValAux[j];//that is simply the number of coins which has already been picked for the value J
                    int jPicked = coinValAux[j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE: coinValAux[j - coins[i]] + 1;// adding 1 for the current coin if the value isnt infinity
                    coinValAux[j] = Math.min(jPicked, jNotPicked);

                    if(jPicked < jNotPicked){//that is the coin is picked
                        coinPicked[j] = i;//ith coin has been picked along with the jth coin
                    }


                }
            }
        }



        return coinValAux[coinValAux.length -1];
    }
}
