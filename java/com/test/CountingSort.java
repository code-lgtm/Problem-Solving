package com.test;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		
		int[] ip = {1,4,1,2,7,5,2};
		
		int[] sortedOp = countSort(ip, 0, 9);//passing input and input range
		System.out.println(Arrays.toString(sortedOp));

	}

	private static int[] countSort(int[] ip, int start, int end) {	

		//initialize an array to capture the count
		int[] cntAry = new int[end-start +1];
		for(int i: ip) {
			cntAry[i] += 1;
		}
		
		for(int i = 1; i< cntAry.length; i++) {
			cntAry[i] += cntAry[i-1];
		}
		
		int[] auxAry = new int[ip.length];
		
		for(int i: ip) {
			int place = cntAry[i]--;
			auxAry[place-1] = i;
		}
		
		return auxAry;
	}

}
