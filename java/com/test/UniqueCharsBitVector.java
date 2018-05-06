package com.test;

public class UniqueCharsBitVector {

	public static void main(String[] args) {

		System.out.println(checkUnique("asdfghj"));
		
	}

	private static boolean checkUnique(String ip) {

		int lookup = 0;//all unset bits
		for(char c: ip.toCharArray()) {
			int indC = c - 'a';
			
			//checking if the indC th bit of lookup is set
			if(((1 << indC) & lookup) >= 1) {
				return false;
			}else {
				//set the indC th bit
				lookup |= (1 << indC);
			}
		}
		
		return true;
	}

}
