package com.test;

public class BoyerMooreSubStringMatch {

	public static void main(String[] args) {
		//explanation: https://www.youtube.com/watch?v=PHXAOKQk2dw
		//Assuming input to be lower char
		
		String str = "trusthardtoothbrushes";
		String sub=  "tooth";

		System.out.println(isSubString(str.toCharArray(), sub.toCharArray()));

	}

	private static boolean isSubString(char[] str, char[] sub) {
		/*
		 * value = length - index - 1		
		 * value = length //for the last char
		 * 
		 * Repeating char will overwrite values in the Badmap table
		 */

		int[] badMap = new int[27]; //27th letter is *
		for(int i = 0 ; i < badMap.length; i++) {
			badMap[i] = Integer.MIN_VALUE;
		}

		int len = sub.length;
		for(int i = 0 ; i < len; i++) {
			if(i == len -1) {//last index
				if(badMap[sub[i] - 'a'] != Integer.MIN_VALUE) {//If last char isn't yet defined, then define it as length, else leave
					badMap[sub[i] - 'a'] = len;
				}
			}else {
				badMap[sub[i] - 'a'] = len - i - 1;
			}

		}
		badMap[26] = len;//define a char * with value length
		
		//Match sub with str, starting from the rightmost char of sub.
		//If the char doesn't match then get the corresponding value from badmatch and jump those many chars to the right of str input
		
		for(int i = sub.length -1; i < str.length;) {
			int subInd = sub.length -1;
			int strInd = i;
			int rightShiftCnt = 1;
			while(subInd >= 0) {
				if(sub[subInd--] == str[strInd--] ) {
					if (subInd < 0) return true; //this implies that sub has completly matched
				}else {//miss-match
					if(badMap[str[i] - 'a'] > Integer.MIN_VALUE) {
						rightShiftCnt = badMap[str[i] - 'a'];
					}
					break;
				}
			}
			
			i += rightShiftCnt;
			
		}
		

		return false;
	}

}
