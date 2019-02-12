package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Merge the given set of intervals in O(n log n) time and O(n) space
public class MergeIntervals {
    static class Interval implements Comparable<Interval>{
        int startTime, endTime;
        Interval(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int compareTo(Interval e){//for sorting in the increasing order
            return this.startTime - e.startTime;
        }

    }

    public static void main(String[] args){

        int[][] intervals = {
                {1,5}, {6,10},{11,13},{14,15},
                {2,7}, {8,9}, {12,15} , {4,5},{9,17}, {3,4}
        };

        int[][] intervals2 = {
                {1,5}, {4,10},{11,13},{11,100}, {101,110}
        };

        int[][] intervals3 = {
                {1,5}, {6,10}
        };

        List<Interval> mergedIntervals = mergeIntervals(intervals);
        for (Interval in: mergedIntervals){
            System.out.print("("+in.startTime+" "+in.endTime+") ");
        }
        System.out.println();

        mergedIntervals = mergeIntervals(intervals2);
        for (Interval in: mergedIntervals){
            System.out.print("("+in.startTime+" "+in.endTime+") ");
        }
        System.out.println();

        mergedIntervals = mergeIntervals(intervals3);
        for (Interval in: mergedIntervals){
            System.out.print("("+in.startTime+" "+in.endTime+") ");
        }

/*
Output:
(1 17)
(1 10) (11 100) (101 110)
(1 5) (6 10)
 */

    }

    static List<Interval> mergeIntervals(int[][] intervals){
        List<Interval> intervalList = new ArrayList<>();

        for (int[] interval: intervals){//store the intervals
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        Collections.sort(intervalList);//sort in the increasing order of start times

        int minStart = intervalList.get(0).startTime, maxEnd = Integer.MIN_VALUE;

        List<Interval> mergedIntervals = new ArrayList<>();

        for (Interval in: intervalList){

            if( in.startTime> maxEnd && maxEnd!= Integer.MIN_VALUE){//and new event starts here
                //add the start and end points in the merged interval
                mergedIntervals.add(new Interval(minStart, maxEnd));

                //new minStart time and maxEnd time
                minStart = in.startTime;
                maxEnd = in.endTime;
            }
            maxEnd = in.endTime > maxEnd?in.endTime:maxEnd;// got a new max end time
        }

        //the last interval wouldn't have been captured by the above loop
        mergedIntervals.add(new Interval(minStart, maxEnd));

        return mergedIntervals;
    }
}
