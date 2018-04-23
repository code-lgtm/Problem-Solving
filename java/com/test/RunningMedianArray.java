package com.test;

import java.util.Arrays;

//Uses sorted array to calculate the median
//It's a n^2log(n) solution //n is the number of elements in the array

public class RunningMedianArray {

	public static void main(String[] args) {
		int[] i = {2, 4, 5, 7, 17};
		int[] j = {1,2};
		
	//	printMedian(i, 5);
		printMedian(j, 2);
		

	}

	private static void printMedian(int[] ip, int cnt) {//cnt is number of elements

		if(ip == null || ip.length == 0) {
			System.out.println("0.0");
		}else {
			
			Arrays.sort(ip);//sorting the array n(log(n)
			
			if(cnt % 2 == 0) {//even
				double med = (ip[(cnt/2) - 1] + ip[cnt/2])/2d;
				System.out.printf("%.1f",med);
                System.out.println("");
			}else {//odd
				System.out.println(ip[(cnt/2) ] +".0");
			}
		}
		
	}

}
