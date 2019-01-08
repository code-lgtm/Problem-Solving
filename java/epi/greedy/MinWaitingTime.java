package epi.greedy;

import java.util.Arrays;

public class MinWaitingTime {
    //A DB can perform one query at a time and query processing time is given. Find the total min waiting time of all queries

    public static void main(String[] args){
        int[] queries = {2,5,1,3};
            System.out.println(getMinWaitingTime(queries));
    }

    //simply start from the min query and calculate the waiting time
    // Time complexity - O(n log n), space: O(1)
    static int getMinWaitingTime(int[] queries){
        Arrays.sort(queries);
        int time = 0, totalWaitTime = 0;

        for (int i = 1; i<queries.length; i++){
            time += queries[i-1];
            totalWaitTime += time;
        }

        return totalWaitTime;
    }

    // Time: 1 2 3 5
    // Start time of each query 0 1 3 6
    //Total wait time: 0+ 1 + 3 + 6 = 10
}
