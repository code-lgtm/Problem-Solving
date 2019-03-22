package epi.dp;

//Find the largest continuous sum in the sub array - Time O(n) space O(1)
public class LargestContiguousSubArySum {

    public static void main(String[] args){
        int[] ary = {-2, -3, 4, -1, -2, 1, 5, -3};
        int largestSum = getLargestSum(ary);

        System.out.println(largestSum);

        int[] ary2 = {-2, -3, -4, -1, -2, -11, -5, -3};
        largestSum = getLargestSum(ary2);
        System.out.println(largestSum);

        /*
        Output:
        7
        -1
         */

    }

    static int getLargestSum(int[] ary){
        int maxSum = Integer.MIN_VALUE;
        int curMax = 0;

        for (int i: ary){
            curMax+= i;

            if (i>curMax){
                curMax= i;//this handles the case when all the numbers are negative
            }

            if (maxSum < curMax){
                maxSum = curMax;
            }

        }


        return maxSum;
    }
}
