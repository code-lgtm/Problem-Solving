package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Uses Heap to calculate the median - n(log n)

public class RunningMedianHeap {

	//taking left bucket as the max heap
	static PriorityQueue<Integer> left = new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});

	//right bucket is min heap
	static PriorityQueue<Integer> right = new PriorityQueue<Integer>();


	public static void main(String[] args) {





		//Heap comparator test code
		//		left.add(1);left.add(2);left.add(3);
		//		right.add(1);right.add(2);right.add(3);
		//	    System.out.println(left.peek()+" "+right.peek());


		for(int i = 1; i < 11 ; i++) {
			System.out.printf("%.1f",getMedian(i));
            System.out.println("");
			
		}

	}

	private static double getMedian(int ip) {

        //calculate initial peaks 
		int leftMax = left.peek() == null ? 0: left.peek();
		int rightMin = right.peek() == null ? 0: right.peek();
		
		//add the element to the bucket satisfying the heap property
		if(ip < leftMax) {
			left.add(ip);
		}else {
			right.add(ip);
		}
		
		
		//balance the heap by shifting the element
		if (left.size() - right.size() > 1) {
			right.add(left.poll());
		}else if (right.size() - left.size() > 1) {
			left.add(right.poll());
		}
		
		//recalculate peaks after balance
		 leftMax = left.peek() == null ? 0: left.peek();
		 rightMin = right.peek() == null ? 0: right.peek();
		
		 //Get the median
		if((left.size() + right.size()) %2 == 0) {//even
			return (leftMax + rightMin)/2d;
		}else {//odd
			if(left.size() > right.size()){
				return (double)leftMax;
			}else {
				return (double)rightMin;
			}
		}
		
	}

}
