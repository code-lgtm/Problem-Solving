package epi.array;

//max profit by buying a selling stocks twice, when the second trade will start after the firstone - Time O(n) space O(1)
//https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
public class BuySellStockTwice {

    public static void main(String[] args) {
        int[] stockPrices = {12,11,13,9,12,8,14,13,15};
        int maxProfit = getMaxProfit(stockPrices);
        System.out.print(maxProfit);

        //Output: 10
    }

    //do two passes, one from left and other from right
    //left pass tells the max profit for the first trade
    //right pass implies the max profit if the trade starts after the first trade
    //then we simply need to find max(leftProfit[i] + rightProfit[i+1] - as the right trade will happen after the left
    static int getMaxProfit(int[] stockPrices){
        int maxProfit = Integer.MIN_VALUE;

        int[] leftProfit = new int[stockPrices.length];
        int[] rightProfit = new int [stockPrices.length];
        int minPrice = Integer.MAX_VALUE, maxPrice = Integer.MIN_VALUE;
        int maxProfitLeft = Integer.MIN_VALUE, maxProfitRight = Integer.MIN_VALUE;

        //left pass

        for (int i = 0; i < stockPrices.length; i++){
            minPrice = stockPrices[i] < minPrice? stockPrices[i]: minPrice;
            maxProfitLeft = Integer.max(maxProfitLeft, stockPrices[i] - minPrice);
            leftProfit[i] = maxProfitLeft;
        }

        //right pass

        for (int i = stockPrices.length-1; i >= 0; i--){
            maxPrice = stockPrices[i] > maxPrice? stockPrices[i]: maxPrice;
            maxProfitRight = Integer.max(maxProfitRight, maxPrice - stockPrices[i]);
            rightProfit[i] = maxProfitRight;
        }

        //get the max profit
        for (int i = 0; i < stockPrices.length-1; i++){
            maxProfit = Integer.max(maxProfit, leftProfit[i] + rightProfit[i+1]);

        }

        return maxProfit;
    }

}
