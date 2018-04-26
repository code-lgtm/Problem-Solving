package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IceHash {

	static Map<Integer, Integer> hash = new HashMap<Integer, Integer>();//key is cost, value is number of its occurence 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money = 4;
		int[] costAry = {1,4,5,3,2};

		int[] costAry2 = {2, 2, 4 ,3};




		printFlavourIndex(costAry2, money);

	}

	private static void printFlavourIndex(int[] costAry, int money) {
		//one pass (n) using HashMap
		//we will store price:index pair
		
		int pos1=-1, pos2=-1;
		for(int i = 0 ; i < costAry.length; i++) {
			int complement = money - costAry[i];
			if(complement > 0 && hash.containsKey(complement)){//found a solution
				pos1 = i +1;
				pos2 = hash.get(complement) +1;
				break;
			}
			
			hash.put(costAry[i], i);
		}
		
		System.out.println(Math.min(pos1, pos2)+" "+ Math.max(pos1, pos2));
		
	}

}
