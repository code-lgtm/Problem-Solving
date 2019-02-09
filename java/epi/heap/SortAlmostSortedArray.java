package epi.heap;

import java.util.PriorityQueue;

//given an array where every number is atmost k Step away from its actual position, sort the array in O(n log k) time and O(k) space

public class SortAlmostSortedArray {

    public static void main(String[] args){
            int[] ip = {3,-1,2,6,4,5,8};
            int k = 2;
            sortAlmostSortedAry(ip,  k);

            //Output: -1 2 3 4 5 6 8
    }

    static void sortAlmostSortedAry(int[] ip, int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
        //insert the first k+1 elements in the heap
        for(int i = 0; i < k+1; i++){
            minHeap.add(ip[i]);
        }

        int cur = k+1;
        while (!minHeap.isEmpty()){
            System.out.print(minHeap.poll()+" ");
            if(cur < ip.length){
                minHeap.add(ip[cur++]);
            }
        }
    }
}
