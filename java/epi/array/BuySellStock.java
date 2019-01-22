package epi.array;


//Buy and sell at a price for the max profit - Time O(n) space (1)
public class BuySellStock {
    public static void main(String[] args){
        int[] prices = {310,315, 275, 295, 260, 270, 290, 230, 255, 250};
        int maxProfit = getMaxProfit(prices);
        System.out.println(maxProfit);
        //output: 30
    }

    //maintain the difference of min seen and the current value . See when is this difference max
    static int getMaxProfit(int[] prices){
        int maxProfit = Integer.MIN_VALUE, minSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++){
            minSoFar = prices[i] < minSoFar? prices[i]:minSoFar;//see if we have seen a new min
            int curProfit = prices[i]-minSoFar;
            maxProfit = curProfit>maxProfit? curProfit: maxProfit; //get the max profit
        }

        return maxProfit;
    }
}
