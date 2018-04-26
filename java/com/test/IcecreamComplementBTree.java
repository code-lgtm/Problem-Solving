package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IcecreamComplementBTree {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money = 4;
		int[] costAry = {1,4,5,3,2};
		
		int[] costAry2 = {2, 2, 4 ,3};
		printFlavourIndex(costAry, money);

	}

	/* Custom BSearch
	private static int bSearch(int[] auxAry, int complement, int min, int max) {//search fot the complement in the sub array
		int ind = (min + max)/2;	
		int cur = auxAry[ind];
		if(cur == complement) {
			return cur;//found the complement
		}else if (cur > complement){//look at the left
			max = ind;
			return (max <= min) ? -1 : bSearch(auxAry, complement, min, max);

		}else {//cur < complement, then look at the right
			min = ind;
			return (max <= min) ? -1 : bSearch(auxAry, complement, min, max);
		}

	}
*/
	private static void printFlavourIndex(int[] costAry, int money) {

		int[] auxAry = costAry.clone();
	
		Arrays.sort(auxAry);//sorting for performing Binary search


		int price1 = -1, price2=-1;
		for(int i = 0; i<auxAry.length; i++) {//BSearch if a complement exist
			int complement = money - auxAry[i];
			//int foundComplement = bSearch(auxAry, complement, i+1, auxAry.length);
			
			int foundIndex = Arrays.binarySearch(auxAry, i+1, auxAry.length, complement);
			
			
			if(foundIndex > 0 ) {//found the complement
				price1= auxAry[i];
				price2 = auxAry[foundIndex];
				break;
			}
		}
		
	//translate price to Index
		int place1 = -1, place2= -1;
		for(int i = 0; i<costAry.length; i++) {//find the index of the prices
			if(costAry[i] == price1 && place1 == -1 && i != place2-1) {
				place1=i+1;
			}
			if(costAry[i] == price2 && place2 == -1 && i != place1-1) {
				place2=i+1;
			}
		
		}
		
		if(place1 > place2) {
			System.out.println(place2 +" "+ place1);
		}else {
			System.out.println(place1 +" "+ place2);
		}


	}

}
