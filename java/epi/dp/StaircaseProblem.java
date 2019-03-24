package epi.dp;

//number of ways a kid can climb a staircase having n steps, if he can take 1, 2 or 3 steps at a time - Time and space O(n)
/*
This is classic implementation of fibonacci series. number of ways you can reach level f(n) = f(n-1) + f(n-2) + f(n-3)
 */
public class StaircaseProblem {
    public static void main (String[] args){
        int n = 10;
        int numWays = getNumWays(n);
        System.out.println(numWays);
        //Output: 274
    }


    static int getNumWays(int n){

        int[] auxWays = new int[n];
        //Seed data
        auxWays[0] = 1; //one way to climb on stair
        auxWays[1] = 2; //two ways to climb 2nd stairs
        auxWays[2] = 4; //4 ways to climb the third stair. 111, 12, 21, 3


        for (int i = 3; i < n; i++){//starting from 4th stair
            auxWays[i] = auxWays[i-1] + auxWays[i-2] + auxWays[i-3] ;
        }


        return auxWays[n-1];
    }
}
