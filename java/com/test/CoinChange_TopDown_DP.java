package com.test;

import java.util.HashMap;
import java.util.Map;

public class CoinChange_TopDown_DP {

    private static Map<Integer, Integer> coinMem = new HashMap<Integer, Integer>();

    public static void main(String[] args){
        int total = 5;
        int[] coins = {1,2,3};
        System.out.println(calMinCoins(total,  coins));
    }

    // time complexity: O(total * totalCoins)
   private static int calMinCoins( int remaining, int[] coins){

            if(remaining == 0){
                return 0; // no coins required
            }

            //check if we have already computed this solution, if yes then return it
            if(coinMem.containsKey(remaining)){
                return  coinMem.get(remaining);
            }

            int levelMin = Integer.MAX_VALUE;

            for(int coin: coins){//each level has the same set of coins

                int temRem = remaining - coin;
                if (temRem >= 0){//that is if using this coin is possible?
                    int tempMin = calMinCoins(temRem, coins);
                    if(tempMin < levelMin){
                        levelMin = tempMin;
                    }
                }

            }


        levelMin = levelMin == Integer.MAX_VALUE ? 0: levelMin + 1;

            coinMem.put(remaining, levelMin);

         return levelMin;
    }
}
