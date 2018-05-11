package com.test;
/*
 * Check if a string is rotation of another using isSubString method only ones
 * 
 */
public class StringRotation_LinearTime {

	public static void main(String[] args) {

		String ip1 = "waterbottle";
		String ip2 = "erbottlewat";

		System.out.println(isRotated(ip1, ip2));

	}

	private static boolean isRotated(String ip1, String ip2) {

		if(ip1 == null || ip2== null || (ip1.length() != ip2.length())) {
			return false;
		}

		String ip22 = ip2+ip2;
		return isSubString(ip22, ip2);



	}



	private static boolean isSubString(String concat, String ip2) {
		return concat.contains(ip2);
	}


}
