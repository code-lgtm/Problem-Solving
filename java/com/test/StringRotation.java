package com.test;
/*
 * Check if a string is rotation of another using isSubString method only ones
 * 
 */
public class StringRotation {

	public static void main(String[] args) {

		String ip1 = "waterbottle";
		String ip2 = "erbottlewat";

		System.out.println(isRotated(ip1, ip2));

	}

	private static boolean isRotated(String ip1, String ip2) {

		if(ip1 == null || ip2== null || (ip1.length() != ip2.length())) {
			return false;
		}

		int k = getRotationIndex(ip1.toCharArray(), ip2.toCharArray());
		if(k > 0) {//rotated by atleast one place
			String rotated = ip1.substring(k) + ip1.substring(0, k);
			return isSubString(rotated, ip2);
		}else {
			return false;
		}



	}



	private static boolean isSubString(String rotated, String ip2) {
		return rotated.contains(ip2);
	}

	//O(n2)
	private static int getRotationIndex(char[] ip1, char[] ip2) {
		int k = -1;
		for(int i = 0 ; i < ip1.length; i++) {
			k = i;
			for(int j = 0 ; j < ip2.length; j++) {
				if(ip1[k++] == ip2[j]) {
					if(k == ip1.length) {
						return i;//i is the rotation point
					}
				}else {
					break;
				}
			}
		}


		return -1;
	}

}
