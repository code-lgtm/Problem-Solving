package epi.bst;

import java.util.Comparator;
import java.util.TreeSet;

//Find the closest elements from k sorted arrays - Time O(n log k) - n is total number of elements in all the arrays. Space O(k)
//Similar to https://www.geeksforgeeks.org/find-three-closest-elements-from-given-three-sorted-arrays/
public class ClosestEntriesInKSortedArrays {

    public static void main(String[] args){
        int[][] kSortedArrays = {
                {5,14,15},
                {3,6,9,12,15},
                {8,16,24}
        };

        int[][] kSortedArrays2 = {
                {5,14,17,20,25},
                {3,6,9,12,18},
                {8,16,24},
                {10,20,30,40}
        };

        TreeSet<ValInd> closestEntries = findClosestEntries(kSortedArrays);
        ValInd min = closestEntries.first();
        ValInd max = closestEntries.last();
        System.out.println(closestEntries);
        System.out.println("Min Distance: "+(max.value-min.value));

        closestEntries = findClosestEntries(kSortedArrays2);
        min = closestEntries.first();
        max = closestEntries.last();
        System.out.println(closestEntries);
        System.out.println("Min Distance: "+(max.value-min.value));

        /*
        Output:
[15, 15, 16]
Min Distance: 1
[18, 20, 20, 24]
Min Distance: 6
         */

    }

    static class ValInd{
        int value,  i, j;
        ValInd(int value, int i, int j){
            this.value = value;
            this.i = i;
            this.j = j;
        }
        public String toString(){
            return value+"";
        }
    }

    static TreeSet<ValInd> findClosestEntries(int[][] kSortedArrays){
        int k = kSortedArrays.length;
        TreeSet<ValInd> sortedCurHeads = new TreeSet<>(new Comparator<ValInd>() {
            @Override
            public int compare(ValInd o1, ValInd o2) {
                int valDelta= o1.value-o2.value;
                if(valDelta==0){
                    return o1.i - o2.i;//compare the array indexes. CRITICAL: WITHOUT THIS SET WONT STORE DUPLICATE ENTRIES LIKE 5 IN THE TEST CODE
                }
                return o1.value-o2.value;
            }
        });

        //store the 0th value of all the arrays, and find the min and max value
        for (int i = 0; i < k; i++){
            sortedCurHeads.add(new ValInd(kSortedArrays[i][0], i, 0));
        }

        while (true){
            //increment the minValue in an attempt to find an even smaller interval
            ValInd curMin =  sortedCurHeads.first();
            ValInd curMax = sortedCurHeads.last();

            if(curMin.j + 1 < kSortedArrays[curMin.i].length){//their exists another value
                sortedCurHeads.pollFirst();//drop the smallest value
                int nextVal = kSortedArrays[curMin.i][curMin.j + 1];
                sortedCurHeads.add(new ValInd(nextVal,curMin.i, curMin.j + 1 ));//insert the value which is next to the currentMin

            }else {//one of the arrays ran out of next value
                break;
            }
        }
        return sortedCurHeads;
    }

}
