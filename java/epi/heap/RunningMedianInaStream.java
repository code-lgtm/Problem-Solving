package epi.heap;

import java.util.Collections;
import java.util.PriorityQueue;

//Find the running median of a stream in O(n log n) time and O(n) space
//Link: https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
//Median is the number in the middle of the stream we we sort the stream and the total element in the stream is odd, else is the avg of the middle two numbers
public class RunningMedianInaStream {
    public static void main(String[] args){
        int[] stream = {1,0,3,5,2,0,1};

        for(int i: stream) {
            System.out.print(getRunningMedian(i)+" ");
        }

        //Output: 1.0 0.5 1.0 2.0 2.0 1.5 1.0
    }


    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//left bucket, less than the median
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //right bucket less than the median
    static double getRunningMedian(int cur){

        if(minHeap.isEmpty() || cur >= minHeap.peek()){//if the cur is >= to the min value of minHeap (right bucket) then it belongs to the right half of the median
            minHeap.add(cur);
        }else{//
            maxHeap.add(cur);
        }

        //balance the heaps if difference in both > 1
        if(Math.abs(minHeap.size() - maxHeap.size()) >1){
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }else{
                minHeap.add(maxHeap.poll());
            }
        }

        // both the heaps are balanced at this point , calculate the median

        if((minHeap.size()+maxHeap.size()) % 2 == 0){//total count is even, calculate the avb of middle two elements
            return (minHeap.peek() + maxHeap.peek())/2d;
        }else{
            return minHeap.size()>maxHeap.size()?minHeap.peek():maxHeap.peek();
        }

    }
}
